# Shopping Cart

Requirement:
Project 1 required that I implement a program that acts as a shopping cart management application. The
program will use a tree-map in the method discussed by you in class to to things such as add items,
remove items, display the contents of the “shopping cart”, as well as display a total dollar amount for the
items. The input consisted of a text file called items which listed the items names(string) and the items
worth (int). The other file was called orders which consisted of shoppers doing specific actions with
items, such as adding or removing items. These files were to be read in through a scanner object.'

Method:
For this program we were asked to utilize java's built-in tree-map to imitate shopping for items We were
asked to create two tree-maps; one would represent the items in the store as keys and cost
As the value. The other was to represent the individual shoppers' names as keys, and their carts were the
values. However, their carts were actually another data structure all altogether, Array-lists. So in essence
this is what I had:
TreeMap<String, Integer> items= new TreeMap <String, Integer>()
TreeMap<String, ArrayList<String>> carts= new TreeMap <>()
I made both global objects so they would be seen and can be used through out the whole program. I also
created separate scanner objects for the items file and orders file that were called "itemFile" and
"ordersFile" respectively.

Running Program:
To run the program, using command line, you must first compile the program with javac shoppingCart.java command,
if compile is sucessful run the java shoppingCart items.txt orders.txt to run the program with the provided test files.
Program will output accordingly.

For any other information or analysis of program please read PROJ1REPORT cs241 file
