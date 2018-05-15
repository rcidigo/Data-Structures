package sortA;

public class HeapSort implements SortAlgorithm {

	private SortTimer t;
	private double [] a;
	private int N;

	public HeapSort(double[]a, SortTimer t, int N)
	{
		this.t=t;
		this.a=a;
		this.N=N; // n is the size of the array
	}
	
	public void sort(double[] a, SortTimer t)
	{
    	heapify(a, t);        
//setting 'i' equal to size of the array
 // swapping i and the root
 
    	for (int i = N; i > 0; i--)
    	{
    		swap(a,0, i);
        	N--;
        	maxheap(a, 0);
    	}
	 t.getElapsedTime();
  }
	private void heapify(double[] a2, SortTimer t2) 
	{     
	    for (int i = N/2; i > 0; i--)
	    {
	        swap(a2,0, i);
	        N--;
	        maxheap(a2, 0);
		
	     }

	}
    // Method to swap largest element in heap         

    public void maxheap(double []a , int i)
    { 
        int left = 2*i +1 ; // left child for given 'i'
        int right = 2*i + 2; // right child for given 'i'
        int max = i;
        
        // setting max equal to left if left-child index is less than array size
        // and left child element is greater than array  element at position i
        if (left <= N && a[left] > a[i])
        {
            max = left;
            t.addComparison();
            }

        if (right <= N && a[right] > a[max])  
        {
            max = right;
            t.addComparison();
        }

        // if max not equal to i, call swap function and them max heap
        if (max != i)
        {
        	t.addComparison();
            swap(a, i, max);
            maxheap(a, max);
  
        }

    }    

    //Function to swap two numbers in an array

    public void swap(double[] a, int i, int j)
    {
        double tmp = a[i];
        a[i] = a[j];
        a[j] = tmp; 
        t.addMoves(3);
    }    	
	
	
}
