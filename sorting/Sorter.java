package sortA;
//
//Sortalgorithm s= null;
// in switch statement
//s= new InsertionSort()

public class Sorter {
	static float totalComp=0, totalMoves=0, totalTime=0;
	public static void main (String[]args)
	{
		SortAlgorithm s= null;
		if(args.length< 2)
		{
			System.out.println(" Invalid Usage"
					+ " Valid Usage: [sortname] [arraysize]");
			System.exit(0);
		}
		 
		int arraySize=Integer.parseInt(args[1]);
		SortTimer t= new SortTimer();
		
		double [] a=null;
		
	
		
		// switch statement for implementing different sorts
		
	     
		switch(args[0]) // args[0] being name of sort class
		{
			case "insert": 
							System.out.println("Sorting Method: INSERTION");
							System.out.printf("%-10s %20s %20s %20s %n ", "Array Size", "Microseconds", "Comparisons", "Moves");
							
							for (int size=1; size < arraySize+1; size++) // represents 10^size
							{
								t.reset(); // resets comparisons/moves to 0, marks time
								for(int x=0; x < 5; x++)
								{
									 a= randomArray(size); // to execute up to 10^ p  // random array method is called and return array
									s = new InsertionSort(a,t);      // creating insertion object
									s.sort(a,t); 								// using insertion method sort for array a  and t
									sumAll(t); // will add moves to totalMoves and so on
								}

								avgAll(t);
									
									// print out everything & reset everything to 0
									System.out.printf("%-20d %-20.0f %-20.0f %-20.0f %n",a.length, totalTime/1000, totalComp, totalMoves);
							
									t.reset(); // resets everything to 0, accept time
							}
							if(Verfied(a))
								System.out.println("Array is Sorted");
							else
							System.out.println("***ERROR*** NOT SORTED");								
								break;
			// for rest of sorts let k go up to 6					
			case "heap":		
							System.out.println(" Sorting Method: HEAP");
							System.out.printf("%-10s %20s %20s %20s %n ", "Array Size", "Microseconds", "Comparisons", "Moves");
							
							for (int size=1; size < 7; size++) // represents 10^size
							{
								t.reset(); 
								for(int x=0; x < 5; x++)
								{
									a= randomArray(size); 
									s= new HeapSort(a, t, a.length);      
									s.sort(a,t); 								
									sumAll(t);
								}
									
									avgAll(t);
									System.out.printf("%-10d %12f %12f %12f %n",a.length, totalTime/1000, totalComp, totalMoves);
									
									t.reset(); // resets everything to 0, accept time
									
							}
							if(Verfied(a))
								System.out.println("Array is Sorted");
							else
							System.out.println("*** ERROR**** NOT SORTED");										
								break;
								
			case "quick":
							System.out.println(" Sorting Method: QUICKSORT");
							System.out.printf("%-10s %20s %20s %20s %n ", "Array Size", "Microseconds", "Comparisons", "Moves");
							for (int size=1; size< arraySize +1; size++) // represents 10^size
							{
								t.reset(); // resets comparisons/moves to 0, marks time
								for(int x=0; x < 5; x++)
								{
									a= randomArray(size); // to execute up to 10^ p  // random array method is called and return array
									s = new QuickSort(a,t);      // creating insertion object
									s.sort(a,t); 	// using insertion method sort for array a  and t
									sumAll(t);
								}
									
									avgAll(t);
									System.out.printf("%-20d %-20f %-20f %-20f %n",a.length, totalTime/1000, totalComp, totalMoves);
									
									t.reset(); 
							}
							if(Verfied(a))
								System.out.println("Array is Sorted");
							else
							System.out.println("*** ERROR**** NOT SORTED");	
							
								break;
								
			case "merge":
							System.out.println(" Sorting Method: MERGE");
							System.out.printf("%-10s %20s %20s %20s %n ", "Array Size", "Microseconds", "Comparisons", "Moves");
							
							for (int size =1; size < arraySize; size ++) // represents 10^ l
							{
								t.reset(); 
								for(int x=0; x < 5; x++)
								{
									a= randomArray( size ); // to execute up to 10^ p  // random array method is called and return array
									s = new MergeSort(a,t);     
									s.sort(a,t); 								
								sumAll(t);
								}
								avgAll(t);
									System.out.printf("%-20d %-20f %-20f %-20f %n",a.length, totalTime/1000, totalComp, totalMoves);									
									t.reset(); 
							}
							if(Verfied(a))
								System.out.println("Array is Sorted");
							else
							System.out.println("*** ERROR**** NOT SORTED");	
																	
								break;
								
			default:            System.out.println("That is an invalid sorting"
			                                      + "mechanism for this program ");
								System.exit(0);
								break;
			
		}
	}

	
	public static double [] randomArray( int k) // created random arrays
	{
		double [] ranArray = new double [(int)Math.pow(10, k)];
	  
			for(int i=0; i< ranArray.length; i++)
				ranArray[i]= Math.random();
	
		return ranArray;

    }
	public static boolean Verfied(double [] a)
	{
		for(int i=0; i< a.length; i++)
			if(a[i] <= a[i+1]) return true;
					return false;
		
	}
	
	public static void sumAll(SortTimer t)
	{
		totalMoves+=t.getMoves();
		totalComp+= t.getComparisons();
		totalTime+= t.getElapsedTime();
	}
	public static void avgAll(SortTimer t)
	{
		totalMoves/=5;								
		totalComp/=5;
		totalTime/=5;
	}
	
}
