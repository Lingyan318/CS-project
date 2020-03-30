from flask import Flask, request, session, render_template, abort, redirect, url_for, make_response
from flask_restful import reqparse, abort, Api, Resource
from models import db, Player, Game
import datetime
import os
import json
import pickle

app = Flask(__name__)
app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///" + os.path.join(
    app.root_path, "connect4.db"
)
# Suppress deprecation warning
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False
app.config["SECRET_KEY"] = 'development key'
db.init_app(app)
api = Api(app)

class mainpage(Resource):
    def get(self):
        if ('login_id' in session) and (session['login_id'] is not None):
            return render_template("login.html", login = True)
        return render_template("login.html")

class signup(Resource):
    def get(self):
        if ('login_id' in session) and (session['login_id'] is not None):
            return render_template("signup.html", login = True)
        return render_template("signup.html")
    def post(self):
        new_name = request.form['name']
        new_pass = request.form['pass']
        new_birth = request.form['birth']
        if Player.query.filter_by(username=new_name).first() is None:
            new_player = Player(username = new_name,password = new_pass, birthday = datetime.datetime.strptime(new_birth, '%Y-%m-%d').date())
            db.session.add(new_player)
            db.session.commit()
            new_id = Player.query.filter_by(username = new_name).first().id
            session['login_id'] = new_id
            return redirect(url_for('land'))
        else:
            errmsg = new_name + ' already exists! Please input another name'
            return render_template('signup.html', errormsg = errmsg)

class login(Resource):
    def get(self):
        if ('login_id' in session) and (session['login_id'] is not None):
             return render_template("login.html", login = True)
        return render_template("login.html")
    def post(self):
        name = request.form['name']
        password = request.form['pass']
        user = Player.query.filter_by(username=name).first()
        if user is None:
            # no user
            errormsg = 'Incorrect user name or password!'
            return render_template("login.html", errormsg = errormsg)
        else:
            # user found
            if user.password != password:
                errormsg = 'Incorrect user name or password!'
                return render_template("login.html", errormsg = errormsg)
            session['login_id'] = user.id
            return redirect(url_for('land'))

class logout(Resource):
    def get(self):
        session['login_id'] = None
        return redirect(url_for('login'))
    def post(self):
        session['login_id'] = None
        return redirect(url_for('login'))

class land(Resource):
    def get(self):
        def turnnum(game):
            return game.nextturn
        def wingame(game):
            print('-', game.winner.id, player_id)
            if game.winner.id == player_id:
                return True
            return False
        if ('login_id' not in session) or (session['login_id'] is None):
            return render_template("login.html")
        player_id = session['login_id']
        player_one = Player.query.filter_by(id = player_id).first()
        if request.method == 'GET':
            involve_games = Game.query.filter_by(player_one_id = player_id, game_over = False).all()+Game.query.filter_by(player_two_id = player_id, game_over = False).all()
            finish_games = Game.query.filter_by(player_one_id = player_id, game_over = True).all()+Game.query.filter_by(player_two_id = player_id, game_over = True).all()
            finish_games = filter(wingame, finish_games)
            finish_games = sorted(finish_games, key=turnnum)
            if len(finish_games)>10:
                finish_games = finish_games[0:10]
            all_games = Game.query.filter_by(game_over = True).all()
            all_games = sorted(all_games, key=turnnum)
            if len(all_games)>10:
                all_games = all_games[0:10]
            return render_template("landing.html", involve_games = involve_games, user = player_one.username, finish_games = finish_games, all_games = all_games, login = True, userid = player_id)

class game_ope(Resource):
    def post(self):
        if ('login_id' not in session) or (session['login_id'] is None):
            return render_template("login.html")
        player_id = session['login_id']
        player_one = Player.query.filter_by(id = player_id).first()
        res = {}
        data = json.loads(str(request.data, encoding='utf-8'))
        name = data['player_two']
        player_two = Player.query.filter_by(username=name).first()
        if player_two is None:
            # no user
            res['status'] = 1
        elif player_one.id == player_two.id:
            res['status'] = 1
        else:
            new_game = Game(player_one = player_one, player_two = player_two)
            db.session.add(new_game)
            db.session.commit()
            res['status'] = 0
            res['id'] = new_game.id
            res['title'] = new_game.game_title()
        return json.dumps(res), 200
    def delete(self):
        if ('login_id' not in session) or (session['login_id'] is None):
            return render_template("login.html")
        player_id = session['login_id']
        player_one = Player.query.filter_by(id = player_id).first()
        res = {}
        data = json.loads(str(request.data, encoding='utf-8'))
        game_id = data['game_id']
        game = Game.query.filter_by(id=game_id).first()
        db.session.delete(game)
        db.session.commit()
        res['status'] = 0
        return json.dumps(res), 200

class game(Resource):
    def get(self, game_id):
        if ('login_id' not in session) or (session['login_id'] is None):
            return render_template("login.html")
        player_id = session['login_id']
        player = Player.query.filter_by(id = player_id).first()
        if game_id:
            game = db.session.query(Game).get(game_id)
            if game is None:
                return abort(404)
            gameres = {}
            gameres['player_1_id'] = game.player_one_id
            gameres['player_2_id'] = game.player_two_id
            gameres['player_1_name'] = game.player_one.username
            gameres['player_2_name'] = game.player_two.username
            gameres['player_1_remain'] = 21
            gameres['player_2_remain'] = 21
            gameres['nextturn'] = 1
            gameres['player_1_birth'] = ''
            gameres['player_2_birth'] = ''
            gameres['over'] = game.game_over
            gameres['game_title'] = game.game_title()
            gameres['user_id'] = player_id
            gameres['user_name'] = player.username
            gameres['turns'] = pickle.loads(game.turns)
            gameres['game_id'] = game_id
            return render_template("game.html", game=gameres, login = True)
    def post(self, game_id):
        if ('login_id' not in session) or (session['login_id'] is None):
            return render_template("login.html")
        player_id = session['login_id']
        player = Player.query.filter_by(id = player_id).first()
        data = json.loads(str(request.data, encoding='utf-8'))
        game = db.session.query(Game).get(game_id)
        if game is None:
            return abort(404)
        if data['method'] == 'submit':
            newturns = pickle.loads(game.turns)
            pos = data['pos']
            newturns.append(pos)
            game.turns = pickle.dumps(newturns)
            game.nextturn = game.nextturn+1
            db.session.commit()
            print(newturns)
            return '',200
        elif data['method'] == 'update':
            res = {}
            localnextturn = data['nextturn']
            turns = pickle.loads(game.turns)
            turnlen = len(turns)
            if localnextturn-1==turnlen:
                res['status'] = 'success'
                res['turns'] = []
            elif localnextturn-1 < turnlen:
                res['status'] = 'success'
                res['turns'] = turns[localnextturn-1:]
            else:
                res['status'] = 'error'
            return json.dumps(res), 200
        elif data['method'] == 'over':
            game.game_over = True
            if data['winner'] == 1:
                game.winner = game.player_one
            elif data['winner'] == 2:
                game.winner = game.player_two
            db.session.commit()
            return '', 200
        return abort(404)

api.add_resource(mainpage, '/')
api.add_resource(signup, '/signup')
api.add_resource(login, '/login')
api.add_resource(logout, '/logout')
api.add_resource(land, '/land')
api.add_resource(game_ope, '/game')
api.add_resource(game, "/game/<game_id>/")

# CLI Commands
@app.cli.command("initdb")
def init_db():
    """Initializes database and any model objects necessary for assignment"""
    db.drop_all()
    db.create_all()

    print("Initialized Connect 4 Database.")


@app.cli.command("devinit")
def init_dev_data():
    """Initializes database with data for development and testing"""
    db.drop_all()
    db.create_all()
    print("Initialized Connect 4 Database.")

    g = Game()
    db.session.add(g)

    p1 = Player(username="tow", birthday=datetime.datetime.strptime('11/06/1991', '%m/%d/%Y').date())
    p2 = Player(username="twaits", birthday=datetime.datetime.strptime('01/14/1987', '%m/%d/%Y').date())

    db.session.add(p1)
    print("Created %s" % p1.username)
    db.session.add(p2)
    print("Created %s" % p2.username)

    g.player_one = p1
    g.player_two = p2

    db.session.commit()
    print("Added dummy data.")

@api.representation("text/html")
def out_html(data,code, headers=None):
    resp = make_response(data, code)
    resp.headers.extend(headers or {})
    return resp

if __name__ == "__main__":
    app.run(threaded=True, debug = True)
