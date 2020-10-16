# Connect 4 II: The AJAXening  
Using the starter repository, modify the application so users can play against one another on different browsers without refreshing the page. The application should make use of the XmlHttpRequest object to send data back and forth between the client browsers and the server.  
  
## Specifications  
These are the base requirements for making the page work. You can enhance.  
  
## Dependencies  
Python 3.7  
Flask 1.0.2  
pip install Flask==1.0.2  
Flask-SQLAlchemy 2.3.2  
pip install Flask-SQLAlchemy==2.3.2  
Flask-RESTful 0.3.7  
pip install Flask-RESTful==0.3.7  
## Managing Users  
Users can sign up for an account from the login page if they do not have an account.  
If a user is logged in, no matter what page they are on, they should have access to a logout link.  
## Landing Page  
The landing page should list all games in which the logged in user is involved.  
If the logged in user is the one who created a game, they should be provided the ability to delete the game.  
The landing page contains two “Top 10” score tables:  
The logged in player’s top 10 scores (with links to the game boards.)  
The communities top 10 scores (with the winning player’s username and links to the game boards).  
Scoring is determined by the lowest number of turns to achieve a win.  
A game that takes 7 turns to win is a higher score than a game that takes 18 turns to win.  
The landing page should also include the ability for users to create new games (via XmlHttpRequest) that are added to their list without refreshing the entire page.  
If a user is not logged in, they only see the top community scores without user names or links, and a prompt to login.  
## Games  
Only the user who created the game can delete a game.  
As users take turns the state of the game should be persisted to the database after each turn.  
The persistence should use XmlHttpRequest to persist the data to the server– no page refreshes allowed to persist data to the server during a game.  
Data should persist to localStorage as well.  
Only send new data (the difference) to a client’s machine in response to a poll (not the entire state of of the board).  
Only update the changed data on the screen in response to a poll, not rebuild the entire page.  
Refreshing the page should not mess with the game’s progress.  
Once a game is completed, it cannot be replayed.  
Unauthenticated users cannot access game boards.  
## RESTful APIs  
All XmlHttpRequest requests to interact with data on the backend should be done against routes designed using RESTful API design strategies.  
Actions should use the correct HTTP method to interact with data: GET, POST, PUT, DELETE.  
Implement query filtering on collection routes so you can issue a GET request against a collection /api/games/?user=twaits to only return games with user twaits  
You may use the library Flask-RESTful (v0.3.7) to manage your RESTful routes and resources.  
## Submission Guidelines  
DO NOT SUBMIT any IDE package files.  
You must name the main page for your game connect4.py, and place it in the root directory of your repository.  
Be sure to remember to push the latest copy of your code back to your GitHub repository before the the assignment is due. At the deadline, the repositories will automatically be copied for grading. Whatever is present in your GitHub repository at that time will be considered your submission for this assignment.  
  
Files included in the starter repo:  
  
/README.md  
/connect4.py  
/models.py  
/templates/game.html  
/templates/landing.html  
/templates/base.html  
/requirements.txt  
/static/main.js  
/static/main.css  
/static/images/white-circle.png  
/static/images/red-circle.png  
/static/images/black-circle.png  
Grading Criteria  
We will download a zip archive of the repo and run the connect4.py file in a terminal/console using Python version 3.7 (export FLASK_APP='connect4.py' flask initdb ; flask run).  
  
## Breakdown  
Landing page lists all games for current player: 5%  
Landing page lists top scores appropriately: 10%  
Login/Logout works correctly: 5%  
Account creation works: 5%  
Page viewing permissions function as specified: 5%  
Game creation works as specified: 10%  
Game persists to localStorage appropriately: 10%  
Game persists to backend as specified: 20%  
Game polls for new data and updates as specified: 20%  
Clear and readable presentation: 5%  
Submission/info sheet: 5%  
You will be dedecuted 20% immediately if you include:  
  
*.pyc Files  
__pycache__ Direcotries  
Any and all virtual environment files except for the requirements.txt file  
IDE files and system resources files  
