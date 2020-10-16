# Talk Python to Me  
Use the built-in features of Python to keep track of list of your favorite movies. Define functions to output data in specific formats, and filter the data to return specific items that match the criteria. You are expected to use classes, inheritance, decorators, list comprehensions, string manipulation functions, etc.  
  
Your script will run non-interactively.  
  
## Specifications  
These are the base requirements for making the page work. You can enhance. You cannot use any Python imports for this project.    
Classes and Inheritance  
Media Class  
Has a title property of type string  
Constructor takes title as a parameter  
Define slug method that returns the title in lower case title  
Ensure that the title has been stripped of special characters  
Consider using an iterator (for ... in ...:)  
Replace spaces with -  
For example:  
Don't Tell Mom the Babysitter's Dead would be dont-tell-mom-the-babysitters-dead   
G.I. Joe would be gi-joe  
Movie Class  
Subclasses Media class  
Use super method to set title in constructor.  
Defines additional properties and methods:  
Year (int)  
Director (str)  
Runtime (float)  
override __repr__ method to return <Movie: Title>  
override __str__ method to return (Year) Title  
define abbreviation method that returns first three characters of title in lower case with no spaces or special characters.    
## Functions  
Define a slugs() function that uses a list comprehension to print() each Movie slug.  
Define a abbr() function that uses a list comprehension to print() each Movie abbreviation.  
Define a before_year() function that takes an int parameter as a year and uses a list comprehension to print() each Movie object if the movie was released before a specified year.  
Define main() function and  
print Thanks for checking the Local Movie Database!  
call slugs()  
call abbr()  
call before_year()  
print Thank you at the end  
## Decorator  
Define a decorator to use on slugs(), abbr(), and before_year():  
Decorator should take an argument of msg  
Prints "=====\n%s\n=====" % msg  
Add decorator to functions named above, and pass in an appropriate heading message for each function.   
## Module  
Define if __name__ == '__main__': block at end of file  
Add at least 5 Movie objects to movies list.  
Execute main() function.  
## Submission Guidelines  
DO NOT SUBMIT any IDE package files.  
You must name the main page for your game movies.py, and place it in the root directory of your repository.  
Be sure to remember to push the latest copy of your code back to your GitHub repository before the the assignment is due. At the deadline, the repositories will automatically be copied for grading. Whatever is present in your GitHub repository at that time will be considered your submission for this assignment.  
Files included in the starter repo:  
README.md  
movies.py  
## Grading Criteria  
We will download a zip archive of the repo and run the movies.py file in a terminal/console using Python version 3.7 (python movies.py).  

## Breakdown  
Class inheritance and use of super: 10%  
Class slug method works appropriately: 15%  
Class abbreviation method works appropriately: 10%  
Class dunder str and repr functions defined and return correctly: 10%  
Use of list comprehensions where specified and correct output: 15%  
Use of decorator for printing headers: 20%  
Main function outputs in correct order: 10%  
Utilization of Python topics covered in class: 10%  
i.e. Classes, functions, decorators, list comprehensions, string manipulation, etc.  
