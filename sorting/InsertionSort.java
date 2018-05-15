package sortA;


public class InsertionSort implements SortAlgorithm 
{

private SortTimer t;
private double [] a;

public InsertionSort(double[]a, SortTimer t)
{
	this.t=t;
	this.a=a;
}

	public void sort( double[] a, SortTimer t) 
	{
	    this.setT(t);
		int i, j;
		double current;
		
			for(i=0; i< a.length;i++)
			{
				t.addComparison();
				current=a[i]; // set current element is pointing to i
				j=i;         // set j to i
			
				while(j>0 && ( a[j-1]> current))
				{
					a[j]=a[j-1];
					j--;
					t.addMove();
				}
			
				a[j]=current;
			}
	
			t.getElapsedTime();
		
	}

	public SortTimer getT() {
		return t;
	}

	public void setT(SortTimer t) {
		this.t = t;
	}
		
		
}
