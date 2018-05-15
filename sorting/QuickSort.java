package sortA;
import java.util.Random;

public class QuickSort implements SortAlgorithm {
	private SortTimer t;
	Random random= new Random(); // for pivot
	private double []a;
	private int pos;
	
	public QuickSort(double[]a, SortTimer t)
	{
		this.t=t;
		this.a=a;
	}

	@Override
	public void sort(double[] a, SortTimer t) {
		int left=0;
		int right= (a.length)-1;
		quicksort( left, right);
		
	}

	public void quicksort(int left, int right) {
		if(left<right)
		{
			//picking pivot within between left and right
			int pivot= random.nextInt(right-left+1)+left;
			partition(a,left, right, pivot);
			// elements less than pivot
			quicksort(left, pos-1);
			// elements greater than picvot
			quicksort(pos+1,right);
			
		}
		
		t.getElapsedTime();
	}
	private int partition(double[]b,int left, int right, int p)
	{
		
		// swap  p and right, right is the first on the greater than pivot side
		swap(b, p, right, t);
	    
	     pos=left;
	   
	    for(int i=left;i<right-1;i++)
	    {
	    	 t.addComparison();
	    	if(b[i]<=b[p])
	    	{
	    		swap(a, i, pos, t);
	    		pos++;
	    	}
	    
	    }
	    swap(a, p, pos, t);
	    return pos;	

  }

  public static void swap(double [] array, int s1, int s2, SortTimer t )
  {
	  double temp= array[s1];
	  array[s1]=array[s2];
	  array[s2]=temp;
	  t.addMoves(3);
  }


}
