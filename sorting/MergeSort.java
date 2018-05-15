package sortA;

public class MergeSort implements SortAlgorithm {
	private double[] a;
	private SortTimer t;
	
	public MergeSort(double[] a, SortTimer t)
	{
		this.t=t;
		this.a=a;
	}
	
	 public void sort(double [] a, SortTimer t) {
	       int left=0;
	       int right= a.length-1;
	        doMergeSort(a,left, right);
	    }
	 
	    private void doMergeSort(double [] a, int leftIndex, int rightIndex) {
	         t.addComparison();
	        if (leftIndex < rightIndex) 
	        {
	            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
	            // Below step sorts the left side of the array
	            doMergeSort(a,leftIndex, middleIndex);
	            // Below step sorts the right side of the array
	            doMergeSort(a, middleIndex + 1, rightIndex);
	            // Now merge both sides
	            mergeParts(a,leftIndex, middleIndex, rightIndex);
	        }
	    }
	 
	    private void mergeParts(double [] a, int leftIndex, int middleIndex, int rightIndex) 
	    {
	 
	    	if(a[middleIndex ]<= a[middleIndex+1]) return;
	    	
	    	//setting p and q cursors to heads of lists
	    	// creating new temporary array with fresh corresponding to index
	        int p = leftIndex;
	        int q = middleIndex + 1;
	        int fresh=0; 
	        // new array elements will be copied into
	        double []ab=new double[(rightIndex+1)-leftIndex];
	        
	        while (p <= middleIndex && q <= rightIndex)
	        {
	            t.addComparison();
	            // a[p]gets added to new array and p is inc
	        	if (a[p] <= a[q]) 
	        	{
	                ab[fresh++] = a[p];
	                p++;
	                t.addMove();
	             }
	            if (a[p] >= a[q])
	            {
	            	ab[fresh++]=a[q];
	            	q++;
	            	t.addMove();
	            }
	        }
	        
	        // case where atleast one list has some elements left over that are just copied into ab
	        while(p <= middleIndex)
	        {
	        	ab[fresh++]=a[p];
	        	p++;
	        	t.addMove();
	        }
	        
	        while(q <= rightIndex)
	        {
	        	ab[fresh++]=a[q];
	        	q++;
	        	t.addMove();
	        }
	       
	        // putting elements in ab to a
	        for(int i=leftIndex; i<= rightIndex;i++)
	        {
	        	a[i]=ab[i - leftIndex];
	        	t.addMove();
	        }
	 
	    }
	  }
