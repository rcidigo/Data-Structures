package sortA;

public class SortTimer {
	 private long comparisons, moves, time;

	 public void reset()
	{
		comparisons=0; // resets moves and comparisons and marks time 
	    moves=0;
	    time=System.nanoTime();
	}
	 public void addComparison()
	{
		comparisons++;
	}
	 public void addComparisons(int n)
   {
	 comparisons+=n;
	}	
	 public void addMove() 
	{
	  moves++;
	}
	 public void addMoves(int n)
	{
	 moves+=n;
	}
	 public long getComparisons()
	{
	   return comparisons;
	}
	 public long getMoves()
	{
	  return moves;
	}
	 public long getElapsedTime()
	{
      long finalTime=System.nanoTime(); // creating finalTime and finding difference of time
	  return (finalTime-time);
	
	}

}