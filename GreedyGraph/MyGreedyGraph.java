	import graph.*;
	import java.io.IOException;

public class MyGreedyGraph extends Graph {
	GreedyPriorityQueue Q; // make global
	MyGreedyGraph(String name) throws IOException //constructor
	{
		super(name);
		process_header(name);
		add_vertices();
		Q = new GreedyPriorityQueue();
		add_edges();	
	}
	
	public GreedyVertex getVertex(int u)
	{
	 	return (GreedyVertex) vertices[u]; // override getVertex and cast GreedyVertex
	}
	public void add_vertices()    // override add_vertices
	{
		vertices= new GreedyVertex[getOrder()];
		for(int i=0; i< vertices.length;i++)
			vertices[i]=new GreedyVertex(i);
	}
	public void addFringe( GreedyVertex v, GreedyVertex w)
	{
		getEdge(v.getIndex(),w.getIndex()).setSelected(true);						 // selecting uv edge
		w.setFringe(true);									 						// make w fringe vertex
		w.setParent(v.getIndex());													// change w parent to v
		w.setCost(v.getCost()+ getEdge(v.getIndex(),w.getIndex()).getWeight());    // calculate w cost
		Q.add(w);
	}
	
	public void modifyFringe(GreedyVertex v, GreedyVertex w)
	{
		getEdge(v.getIndex(),w.getIndex()).setSelected(true);
		getEdge(w.getIndex(), w.getParent()).setSelected(false);
		w.setParent(v.getIndex());
		w.setCost(v.getCost()+ getEdge(v.getIndex(),w.getIndex()).getWeight());
		Q.promote(w);
		
	}
	// used provided pseudo code to implement
	public void greedy (int u )
	{
		getVertex(u).setCost(0);        // get vertex of u and set cost to 0
		getVertex(u).setMarked(true);   // mark vertex of u
		Q.add(getVertex(u));            // add to Q
		
		while(Q.size()!=0)             // while q not empty
		{
			GreedyVertex v= Q.poll();
			int[] neigh=v.getNeighbors(); // holds all the adjacent vertexes(neighbors)
				for(int i=0; i <neigh.length;i++)
				{
					GreedyVertex  w= getVertex(neigh[i]);
						if(!w.isMarked())
						{
							if(	w.isFringe())
							{
								if(w.getCost() > (v.getCost()+ getEdge(v.getIndex(),w.getIndex()).getWeight()))
								{
									modifyFringe(v,w);
								}		
							}
							else // not a fringe	
								addFringe(v,w);
						}
						
				}
			
		}
		
	}
	
	
}
