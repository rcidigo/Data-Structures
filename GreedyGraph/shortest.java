import graph.*;

import java.io.*;
import java.util.*;

public class shortest 
{
	public static void main (String[]args) throws IOException 
	{
		// Hard coded to ask for user input
		Scanner kb= new Scanner(System.in);
		System.out.println(" Please enter graph name");

			String name = kb.nextLine();

			 File f= new File(name);
		// checks to see if file exists
		if(!f.exists() )
		{
			System.out.println("File does not exist");
		}

		//can switch between to
		
		//SPTGraph G= new SPTGraph(name); 
		MyGreedyGraph G = null;
		G= new MyGreedyGraph(name);
		System.out.println(G);
		
		System.out.println(" Please enter start vertex: ");
		int  s = kb.nextInt();
		
		System.out.println(" Please enter destination vertex: ");
		int d = kb.nextInt();
		
		// array list to hold path
		ArrayList <Integer> path= new ArrayList<>();
		G.greedy(s);
		
		int x=d;
		
		// while current doesnt equal start
		while( G.getVertex(x)!= G.getVertex(s))
		{
			path.add(x);
			x=G.getVertex(x).getParent();
		}
		
		System.out.println("Path from "+s+" to "+d +":");
		System.out.println("----------------");
		int plength=0;
		for( int i= path.size()-1; i>=0; i--)
		{// print array backwards to get path
			System.out.print(path.get(i)+", ");
			plength++;
		}
	 System.out.println("\n\nPath Length: "+plength);
	}
	
	public static class SPTGraph extends GreedyGraph
	{
		SPTGraph(String name) throws IOException
		{super(name);}
	
	 public double newCost (int v, int w) // override newcost
	 {
		 return costOf(v)+ weightOf(new Edge(v,w, false));
	 }

	}
	
}
