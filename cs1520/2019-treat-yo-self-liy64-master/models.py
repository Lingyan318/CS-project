from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    usr = db.Column(db.String(8), unique=True, nullable=False)
    pwd = db.Column(db.String(8), unique=False, nullable=False)
    type = db.Column(db.String(1), unique=False, nullable=False)

    def __init__(self, usr, pwd, type):
        self.usr = usr
        self.pwd = pwd
        self.type = type

    def __repr__(self):
        return "<User %r>" % self.usr


class Stylist(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    usr = db.Column(db.String(8), unique=True, nullable=False)
    pwd = db.Column(db.String(8), unique=False, nullable=False)
    appt = db.relationship('Appt', backref='stylist', lazy=True)
    free = db.Column(db.Boolean, unique=False)

    def __init__(self, usr, pwd):
        self.usr = usr
        self.pwd = pwd
        self.free = True

    def __repr__(self):
        return "<Stylist %r>" % self.usr


class Patron(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    usr = db.Column(db.String(8), unique=True, nullable=False)
    pwd = db.Column(db.String(8), unique=False, nullable=False)
    appt = db.relationship('Appt', backref='patron', lazy=True)
    free = db.Column(db.Boolean, unique=False)

    def __init__(self, usr, pwd):
        self.usr = usr
        self.pwd = pwd
        self.free = True

    def __repr__(self):
        return "<Patron %r>" % self.usr


class Appt(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    dt = db.Column(db.DateTime, unique=False)
    stylist_usr = db.Column(db.String(8), db.ForeignKey('stylist.usr'))
    patron_usr = db.Column(db.String(8), db.ForeignKey('patron.usr'))
    checked = db.Column(db.Boolean, unique=False)

    def __init__(self, dt, stylist_usr, patron_usr):
        self.dt = dt
        self.stylist_usr = stylist_usr
        self.patron_usr = patron_usr
        self.checked = False

    def __repr__(self):
        return "%r" % self.dt
