/* Programmer: Richard Idigo
   Project 1: Shopping Cart
   Due Date: October 13, 2014
   Instrutor: Professor Srinivas
*/


import java.util.*;
import java.io.*;

public class shoppingCart {

    static TreeMap<String, Integer> items= new TreeMap <String,Integer>(); // creating treemap for price6
    static TreeMap<String, ArrayList<String>> carts= new TreeMap <String,ArrayList<String>>(); // treemap for shoppers carts
   
    public static void main (String[]args) throws FileNotFoundException
    {  
    	if(args.length !=2) exit();
    	String i_file=args[0];
    	String o_file= args[1];
         
           //Will Open File
          File file=new File(i_file);
          Scanner itemFile=new Scanner(file);

         //Will read next line
          while(itemFile.hasNext())
          {
               String text=itemFile.next(); // will represent the item name
               String num= itemFile.next(); // will represent item price
               num=num.replace("$","");      // deletes $
              
               int price= Integer.parseInt(num); // converts string to int
         
              items.put(text, new Integer (price)); // adding names and prces to treeMap
          }
          
       File file2=new File(o_file);
       Scanner orderfile= new Scanner(file2);
       
       String command, shopper; // action for shopping cart
     
       while(orderfile.hasNext())
       {
    	  command= orderfile.next(); // represents action
    	  shopper=orderfile.next();
    	  
    	  int x=0;
    	  if(command.equals("add")) x=1;
    	  else if(command.equals("delete")) x=2;
    	  else if(command.equals("cart")) x=3;
    	  else if(command.equals("checkout")) x=4;
    	  
    	  switch(x)
    	  {
    	       case 1: 
    		       String item= orderfile.next();
    		       add(shopper, item);
    		       break;
    		 
    	       case 2:
    		       String deleteitem= orderfile.next();
    		       delete(shopper, deleteitem);
    		       break;
    		  
    	       case 3:
    		       showCart(shopper);
    		       break;
    		  
    	       case 4:
    		       checkOut(shopper);
    		       break;
    		  
    	       default: 
    		        System.out.println("This is not a command");
    	            break;
    	
    	}
    	
       
       }
       itemFile.close();
       orderfile.close();
    }
/*
 * Exits program when incorrect usage occurs
 */
    public static void exit()
    {
        System.out.println("Incorrect usage");
        System.out.println("Usage: ShoppingCart java 'arg1' 'arg2'");
        System.out.println("Where 'arg1' and 'arg2' are valid text files.");   
        System.exit(0);
    }
    /*
     * Adds item to list of specified shopper
     */
    public static void add(String cus, String pro)
    {
    	ArrayList<String>cart= carts.get(cus);
    	if(cart==null) cart=new ArrayList<String>();
    	if(cart.contains(pro)) System.out.println(cus+" has already added "+pro+" to their cart");
    	   else
    	   {
    		   cart.add(pro);
    		   System.out.println(pro+" was added to "+cus+"'s cart");
    	   }
    	      carts.put(cus, cart);
    }
    /*
     * deletes specified item from list of shopper, if it exists
     */
    public static void delete(String cus, String pro)
    { 
    	ArrayList<String>cart= carts.get(cus);
    	
    	if(cart==null) cart=new ArrayList<String>();
    	if(cart.contains(pro)) 
    	{
    		cart.remove(pro);
    		System.out.println(pro+" Removed from "+cus+"'s cart");	
    	}
    	
    	System.out.println(pro+" Not found in "+cus+"'s cart");
    }
    /*
     * Displays entire list of specified shopper
     */
    public static void showCart(String cus)
    { // need to format display and show price as well
    	ArrayList<String>cart= carts.get(cus);
    	
    	System.out.println(" CART OF : "+cus);
    	System.out.println("--------------------"); // 20 '-'
    	System.out.println("Item         Price  ");
    	System.out.println("--------------------"); // 20 '-'
    	
    	for(int i=0; i<cart.size();i++)
    	{
    	   String str= cart.get(i);
    	   int price = items.get(str);
    	   System.out.printf("%-10s %8d %n", str, price);
    	}
    }
    /*
     * Prints the total value of each item from cart
     * of specified shopper
     */
    public static void checkOut(String cus)
    { // need to add up all value and display
    	ArrayList<String>cart=carts.get(cus);
    	
    	int total=0; // will accumulate the total of each item
    	for(int i=0; i<cart.size();i++)
    	{
    	   String str= cart.get(i);
    	   int price = items.get(str);
    	   total+=price;
    	}
    	
    	System.out.println(cus+" checked out. Total= $"+total);
    }
  
}


