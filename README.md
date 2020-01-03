EX1_oop
In this project we created a number of classes that represents Monom,Polynom and Complexfunction. each class has its own functions, and has its own implemntetion. even more we created a JUnit test for each class of the above to test different scenarios of inputs.

We alse created a GUI class that draws the function so it can be visible for us to see them on a graph.

Monom class

each Monom is composed of a coefficeint -a and power-b, for example: ax^b

main functions are: equals-return true or false wheter an object is equals to a monom f- return the value of the monom in the given x-real number. derivative - return the monom after the derivative action. toString - return a string represents the monom

there are some functions in the class for more info go to our Wiki.

Polynom class

each Polynom is composed of a several monom saved in an arraylist

main functions are: copy - making a copy of the polynom. equals - return a true or false comparing two objects of type function

ComplexFunction class

each complexFUnction is composed of an Operation(plus,mul,div,max,min,comp,none,error), a left function and a right function. the left function is always the first to create, there is no possibility for a right function to exsit and a left one not. if there is not two functions the right one will be null and operation will be none.

main functions are:

plus,mul,div,max,min and etc. copy-making a copy of the complexfunction. initfromstring - initialize a complex function from a string. equals - return a true or false answer when comparing two objects of functions

FunctionGUi class

The main functions here are draw with given parameters and draw with parameters given in a file. there are another two important function: initfromfile,savetofile. initfromfile- reading each line from the file and making a new function that added to function list from it we can draw. savetofile- writing to a file all the functions in the list created.
