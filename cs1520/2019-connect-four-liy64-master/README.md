# Connect Four!  
You will be implementing the game, Connect Four, to be played in the web browser. This assignment is to demonstrate an understanding of how to utilize JavaScript to collect, persist, and manipulate data, and to respond to user interactions to dynamically change the DOM.  
  
   -For this version, you will assume that only one user is viewing the page that presents your game at a time (e.g., the two players are using a laptop that they pass back and forth between turns).  
   -Wikipedia’s Connect Four entry lays out the rules.  
   -Your game will be built on a 7x6 grids, with rows labeled 1-6 and columns labeled A-G.  
   -Each player has 21 tokens.  
      Player one’s tokens are red.  
      Player two’s tokens are black.  
   -The tokens cannot overlap.  
   -The game will have to be aware of how many tokens of the same color are touching, and how many remain to reach four.  
   -The player selects the column to drop the token. You do not need to animate the drop.  
## Specifications
These are the base requirements for making the page work. You can enhance. You cannot use external libraries like jQuery for this project.  
  
When the page is loaded, your game should begin by asking the first player for her name (for example, let's assume that the first player is Alice), and a string representing their birthday. The board should not be displayed.  
   Your game should be flexible in accepting the multiple date formats.  
     MM/DD/YYYY - i.e. 01/01/2019  
     M/D/YYYY - i.e. 1/1/2019  
     MM-DD-YYYY - i.e. 01-01-2019  
     M-D-YYYY - i.e. 1-1-2019  
     MMM. DD, YYYY - i.e. Jan. 01, 2019  
     MMM. D, YYYY - i.e. Jan. 1, 2019  
     MMMMMM DD, YYYY - i.e. January 01, 2019  
     MMMMMM D, YYYY - i.e. January 1, 2019  
   Use a regex function to validate the strings, and split the string into three variables representing Day, Month, and Year.  
   Set the player’s birthday attribute as a JavaScript Date object constructed from the three variables.  
After gathering the first player’s name and birthday, your game should prompt the second player for their name and birthday (for example, lets assume the second player is Bob).  
The player who takes the first turn is the oldest.  
A timer should be displayed at the top of the page tracking the duration of the game. The timer does not start until the first player confirms the start of their first turn.  
With this starting information in hand, your game should begin the first player’s turn  
   -At the start of a turn, your game should use a dialog (you may use alert(), but you do not have to) indicating whose turn it is by name (e.g., “Click OK to begin Alice’s turn”).  
   -After the prompt is dismissed, your game should render one 7x6 grid created dynamically with JavaScript.  
     The grid should have a yellow background and blue border.  
     Empty cells should have a white circle using the image from the starter repo located at /images/white-circle.png.  
The count of remaining tokens for player one should be displayed on the left of the board.  
The count of remaining tokens for player two should be displayed on the right of the board.  
The player is then free to click a column to place their token.  
   -The token should occupy the lowest available cell in the column.  
   -When a player places a token, the cell the token occupies should contain a circle referencing the player’s token color: /images/red-circle.png and /images/black-circle.png.  
   -If the player clicks on a column where no tokens can be placed, a dialog should tell them the column is full.  
   -Once a token is placed, the remaining tokens should be decremented by one.  
After the player has placed their token, the player’s turn is ended and the other player’s turn should begin with a dialog (e.g., “Click to begin Bob’s turn”). 
  
The game continues until one player achieves a Connect Four. The player who achieves a Connect Four is alerted with a message that they won (i.e. “Congratulations! Alice won in insert game duration here!”).   
    -Your game should keep track of the names and game durations of the 10 fastest games in local storage.   
        Consider using an Array of JavaScript Objects (i.e. [ { key: value } ])
    -Only update local storage if there are less than or equal to 10 entries, or the duration of the game beats any time currently tracked in local storage.  
    -When the game is over, remove the board and display the top 10 list.  
    -Empty values should render -- in the listing.  
    -Include a button to start a new game.  
    -Starting a new game removes the score listing.  
## Submission Guidelines  
DO NOT SUBMIT any IDE package files.
You must name the main page for your game connect-four.html, and place it in the root directory of your repository.  
Be sure to remember to push the latest copy of your code back to your GitHub repository before the the assignment is due. At the deadline, the repositories will automatically be copied for grading. Whatever is present in your GitHub repository at that time will be considered your submission for this assignment.  
This should all be done with a single connect-four.html file. You may use multiple JavaScript files, but the entire application should work on a single html file.  
Files included in the starter repo:  
README.md  
/css directory  
/js directory  
/images/white-circle.png  
/images/red-circle.png  
/images/black-circle.png  
## Grading Criteria  
We will download a zip archive of the repo and run the HTML/JS file created locally in the Chrome browser.  
  
This project will require extensive manipulation of the DOM to enable the game to run as described.
Your game does not need to persist across page refreshes. It is acceptable for a page refresh to restart the game.  
While you are not going to be heavily graded on the style and design of your game, * it should be presented in a clear and readable manner.  
## Breakdown  
Turns proceed as described: 20%  
Game board is displayed properly: 20%  
Event handling is processed as described: 15%  
Birthday strings are correctly validated using regex: 5%  
Birthday strings are correctly parsed with regex and date object created according to specification: 10%  
Score saving works appropriately: 15%  
Clear and readable presentation: 5%  
Utilization of Javascript topics covered in class: 10%  
i.e. Functions, Dynamic DOM manipulation, EventHandling, type checking, etc.  
Late assignments will receive zero credit.  
