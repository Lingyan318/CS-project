# Treat Yo Self  
Use the Flask and Flask-SQLAlchemy to create a portal for Treat Yo Self Salon. There are three classifications of users for the site: the Owner, Stylists and Patrons. The salon has one owner, multiple stylists, and multiple patrons.  
  
Stylists work Tuesday through Saturday, from 10am to 8p.  
  
Stylists only offer one service: a haircut. Each haircut takes 1 hour and starts on the hour.  
  
Patrons can make an appointment with any stylist. On a stylist’s page, patrons can see available appointment time slots for the stylists. They can cancel appointments they have made.  
  
## Specifications  
These are the base requirements for making the web application. You can enhance.  

## Dependencies  
Python 3.7  
Flask 1.0.2  
pip install Flask==1.0.2  
Flask-SQLAlchemy 2.3.2  
pip install Flask-SQLAlchemy==2.3.2  
### Managing Users  
Each user (Owner, Stylist, or Patron) should have a username and password.  
All passwords will be stored in plain text.  
Patrons are free to register for their own account.  
Stylist accounts must be created by the Owner (it is fine for the Owner to set passwords for the Stylist).  
If a user is logged in, no matter what page they are on, they should have access to a logout link.  
### Owner  
Should be able to login with the username owner and password pass.  
Once logged in, the Owner should be presented with a link to create new Stylist accounts, and a list for each stylist and their scheduled appointments for the next week.  
For each appointment, the name of the Patron, date and time of the appointment.  
If no appointments are scheduled for a stylist, a message should be displayed informing the Owner of this explicitly.  
On a Stylist’s profile page, the owner can see a list of all future (based on the current day) appointments for the next week including date and time, and patron’s name. Any time slot that does not have an appointment should explicitly indicate it.  
On a Patron’s profile page, the owner can see a list of all future appointments (based on the day) the patron has, including date and time, and stylist.  
### Stylist  
Once logged in, Stylists should directed to their profile page.  
They should see a list of all future (based on the day) appointments for the next week.  
including date and time,  
patron’s name.  
Any time slot that does not have an appointment should explicitly indicate it.  
### Patron  
Once logged in, Patrons should be presented with a list of Stylists who work at the Salon.  
On a Stylist’s page, a patron can view a list of all future (based on the day) appointments.  
Any available appointment slot should indicate it is available.  
Clicking an available slot should take them to a page with a form to request an appointment.  
Any time slot that is taken by a different patron than the one logged in should just say Booked
On the Patron’s profile page, they can see a list of all of their upcoming appointments including today’s.  
Patron’s should be able to cancel any of their own appointments.  
### Data Management  
To ease bootstrapping and testing of your application, hardcode the Owner’s username and password in your app to be owner and pass.  
All other data for your application should be stored in a SQLite database named salon.db using SQLAlchemy’s ORM and the Flask-SQLAlchemy extension.  
## Submission Guidelines  
DO NOT SUBMIT  
any IDE package files.  
*.pyc, __pychache__  
salon.db  
You must name the main page for your game salon.py, and place it in the root directory of your repository.  
Be sure to remember to push the latest copy of your code back to your GitHub repository before the the assignment is due. At the deadline, the repositories will automatically be copied for grading. Whatever is present in your GitHub repository at that time will be considered your submission for this assignment.  
You must be able to run your application by setting the FLASK_APP environment variable to your salon.py and running flask run  
You must be able to initialize your database by setting the FLASK_APP environment variable to your salon.py and running flask initdb  
Add a requirements.txt file containing the installed dependencies for your project. Make sure to add that file to source control.  
Run pip freeze > requirements.txt from the root of your project with your virtualenv activated.
Be sure to use a virtualenv otherwise this list will get ridiculously long.  
Files included in the starter repo:  
README.md  
salon.py  
## Additional Notes/Hints  
Since we covered Flask already, I highly recommend setting up some dummy routes you will need that will, at the very least, return "Hello World" to make sure you can get Flask working.  
You may find it handy to use the HTML date input type for appointment scheduling.  
I recommend creating a development bootstrapping Flask cli command that allows you to delete and recreate a database with an Owner, Stylists, and Patrons, with some appointments to make development and debugging easier.  
Consider using datetime.datetime.now() for appointment time generation so you don't have to worry about resetting appointment times for the as time passes.  
Also, timedelta provides a way to simply perform math on dates.  
In addition to the operations listed above timedelta objects support certain additions and subtractions with date and datetime objects.  
Model relationships are your friend!!! Use them to tie the patrons and stylist together through appointments.  
I recommend creating another object to handle the appointments that contain pointers to the datetime, stylist, and patron.  
SQLAlchemy query filters can be used to get the exact data you need.  
Get familiar with using GET and POST in your routes to handle object creation and persistence.  
Use a SQL visualization tool to help inspect the database. Many IDEs include built-in SQLite tools (VS Code, PyCharm, etc.)  
Since we do not use a textbook, use the documentation links to dig into the features you will need to use. If an approach feels to complicated/complex for what you are trying to do, it probably is.
While you are not going to be heavily graded on the style and design of your web site, it should be presented in a clear and readable manner.  
## Grading Criteria  
We will download a zip archive of the repo and run the salon.py Flask application via flask run in a terminal/console using a virtualenv with the dependencies from your requirements.txt installed in Python version 3.7.  
  
## Breakdown  
Owner login set correctly: 5%  
Patron registration: 5%  
Stylist account creation: 5%  
Login works appropriately: 15%  
Logout always available and works: 5%  
Owner page displays as specified: 15%  
Stylist page displays as specified: 15%  
Patron page displays as specified: 5%  
Patron create appointment works: 10%  
Patron cancel appointment works: 10%  
Clear and readable presentation: 5%  
Submission/info sheet: 5%  
