from flask import Flask, request, abort, url_for, redirect, flash, session, render_template
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import extract
import datetime
from models import db, Patron, User, Stylist, Appt


app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///salon.db"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = True
app.secret_key = "zdgkakgj"
db.init_app(app)


@app.route("/")
def default():
    return redirect(url_for("login"))


@app.route("/login/", methods=["GET", "POST"])
def login():
    user = User.query.filter_by(usr=request.form.get('usr')).first()
    error = None
    if request.method == 'POST':
        if user is None:
            error = "Invalid Username!"
        elif not user.pwd == request.form.get('pwd'):
            error = "Invalid Password!"
        if error == None:
            if user.type == "o":
                return redirect(url_for("owner"))
            elif user.type == "s":
                return redirect(url_for("stylist", target=user.usr, ut=user.type))
            elif user.type == "p":
                return redirect(url_for("patron", target=user.usr, ut=user.type))
    return render_template("login.html", error=error)


@app.route("/register/", methods=["GET", "POST"])
def register():
    error = None
    if request.method == 'POST':
        new_username = request.form.get('new_usr')
        new_password = request.form.get('new_pwd')
        db_username = User.query.filter_by(usr=new_username).first()
        if not db_username == None:
            error = "Username error"
        if error == None:
            new_user = User(new_username, new_password, "p")
            new_patron = Patron(new_username, new_password)
            db.session.add(new_user)
            db.session.add(new_patron)
            db.session.commit()
            flash("successfully")
    return render_template("register.html", error=error)


@app.route("/owner/")
def owner():
    return render_template("ownerPage.html")


@app.route("/owner/create/", methods=["GET", "POST"])
def create():
    error = None
    if request.method == 'POST':
        new_username = request.form.get('new_usr')
        new_password = request.form.get('new_pwd')
        db_username = User.query.filter_by(usr=new_username).first()
        if not db_username == None:
            error = "Username error"
        if error == None:
            new_user = User(new_username, new_password, "s")
            new_stylist = Stylist(new_username, new_password)
            db.session.add(new_user)
            db.session.add(new_stylist)
            db.session.commit()
            flash("successfully")
    return render_template("createAccount.html", error=error)


@app.route("/owner/view/", methods=["GET", "POST"])
def view():
    stylists = Stylist.query.all()
    dtList = get_dtList()
    return render_template("viewAccount.html", stylists=stylists, dtList=dtList)


def get_dtList():
    list = []
    date = datetime.datetime.now()
    oneWeekLater = datetime.datetime.now() + datetime.timedelta(days=7)
    while date < oneWeekLater:
        if date.weekday() >= 1 and date.weekday() <= 5 and date.hour >= 10 and date.hour <= 19:
            list.append(date)
        date = date + datetime.timedelta(hours=1)
    return list


@app.route("/stylist/")
@app.route("/stylist/<target><ut>")
def stylist(target=None, ut=None):
    # if no target user is given
    if target is None or ut is None:
        error = "No specified stylist"
        return render_template("login.html", error=error)
    targetUser = Stylist.query.filter_by(usr=target).first()
    dtList = get_dtList()
    if not targetUser is None:
        return render_template("stylistPage.html", target=targetUser, ut=ut, dtList=dtList)
    else:
        abort(404)


@app.route("/stylist_p/")
@app.route("/stylist_p/<target><ut>/<patronName>")
def stylist_p(target=None, ut=None, patronName=None):
    if target is None or ut is None:
        error = "No specified stylist"
        return render_template("login.html", error=error)
    targetUser = Stylist.query.filter_by(usr=target).first()
    dtList = get_dtList()
    if not targetUser is None:
        return render_template("stylistPage.html", target=targetUser, ut=ut, dtList=dtList, patronName=patronName)
    else:
        abort(404)


@app.route("/patron/")
@app.route("/patron/<target><ut>/")
def patron(target=None, ut=None):
    if target is None or ut is None:
        error = "No specified patron"
        return render_template("login.html", error=error)
    targetUser = Patron.query.filter_by(usr=target).first()
    if not targetUser is None:
        stylists = Stylist.query.all()
        return render_template("patronPage.html", target=targetUser, ut=ut, stylists=stylists)
    else:
        abort(404)


@app.route("/book/<sn>/<y>_<m>_<d>_<h>/<patronName>", methods=["GET", "POST"])
def book(sn=None, y=None, m=None, d=None, h=None, patronName=None):
    date = datetime.datetime(int(y), int(m), int(d), int(h))
    error = None
    if request.method == 'POST':
        p = Patron.query.filter_by(usr=patronName).first()
        stylist = Stylist.query.filter_by(usr=sn).first()
        appt = Appt(date, patronName, sn)
        for item in stylist.appt:
            if item.dt.year == date.year and item.dt.month == date.month and item.dt.day == date.day and item.dt.hour == date.hour:
                if not item.patron.usr == patronName:
                    error = "Already booked"
        if error is None:
            appt.checked = True
            p.free = False
            stylist.free = False
            stylist.appt.append(appt)
            p.appt.append(appt)
            db.session.add(appt)
            db.session.commit()
            flash("successfully")
    return render_template("book.html", sn=sn, date=date, patronName=patronName, error=error)


@app.route("/cancel/<sn>/<y>_<m>_<d>_<h>/<patronName>", methods=["GET", "POST"])
def cancel(sn=None, y=None, m=None, d=None, h=None, patronName=None):
    date = datetime.datetime(int(y), int(m), int(d), int(h))
    if request.method == 'POST':
        p = Patron.query.filter_by(usr=patronName).first()
        s = Stylist.query.filter_by(usr=sn).first()
        for item in s.appt:
            if item.dt.year == date.year and item.dt.month == date.month and item.dt.day == date.day and item.dt.hour == date.hour:
                s.appt.remove(item)
        for item in p.appt:
            if item.dt.year == date.year and item.dt.month == date.month and item.dt.day == date.day and item.dt.hour == date.hour:
                p.appt.remove(item)
        s.free = True
        p.free = True
        for item in s.appt:
            if item:
                s.free = False
        for item in p.appt:
            if item:
                p.free = False
        db.session.commit()
        flash("Appointment cancelled")
    return render_template("cancel.html", sn=sn, date=date, patronName=patronName)


@app.route("/logout/")
def logout():
    session.clear()
    return redirect(url_for("login"))


@app.cli.command("initdb")
def initdb_command():
    db.drop_all()
    db.create_all()
    owner = User("owner", "pass", "o")
    db.session.add(owner)
    db.session.commit()


if __name__ == "__main__":
    app.run()
