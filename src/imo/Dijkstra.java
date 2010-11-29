package imo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;

public class Dijkstra
{
	private Display display;
	private DijkstraQueue dQueue;
	private Graph<Vertex, Edge> g;
	private ArrayList<Vertex> vHigh;
	private ArrayList<Edge> eHigh;
	private Forest<Vertex, Edge> f;
	
	public Dijkstra()
	{
	}
	
	//Build the graph here and then setup the Queue
	public void build()
	{
		//g = new DirectedSparseGraph<Vertex, Edge>();
		vHigh = new ArrayList<Vertex>();
		eHigh = new ArrayList<Edge>();
		g = GraphGen.getGraph( 10, 1, 10);
		display = new Display(g, null, vHigh, eHigh);
		f = new DelegateTree<Vertex, Edge>();
		dQueue = new DijkstraQueue( g.getVertices());
	}
	
	/*
	 * Remove vertices from the queue. The first vertex in the queue is 
	 * always the next vertex that needs to be added to the tree. 
	 * Once that vertex has been removed update the distance values of all 
	 * unremoved vertices connected to it.
	 */
	public void run()
	{
		while( dQueue.hasMore()) {
			Vertex v = dQueue.remove();
			v.setFinal(true);
			f.addVertex(v);
			
			Collection<Edge> edges = g.getOutEdges( v);
			Iterator<Edge> iterator = edges.iterator();
			
			//Create variables to store chosen edge
			Edge eChosen = new Edge(-1);
			
			while( iterator.hasNext()) {
				//Get the current object out of the iterator
				Edge e = iterator.next();
				
				long time = System.currentTimeMillis() + 1000;
				while( System.currentTimeMillis() < time);
				Vertex v2 = g.getDest(e);
				
				/* Only check the vertex if it has not been added to the tree.
				 * After that update the vertex if it is now closer to the root
				 * then it was before v was added to the tree.
				 */
				if(!v.isFinal() && v2.getDistance() > v.getDistance() + e.getWeight()){
					v2.setDistance( v.getDistance() + e.getWeight());
					eChosen = e;
				}
				//Even if a vertex has not been changed it may be in the wrong position
				dQueue.update(v2);

				//highlight v and e
				vHigh.clear();
				vHigh.add(v);
				eHigh.clear();
				eHigh.add(e);
				
				display.print();
			}
			//Before adding edge to forest make sure that this edge is not the original
			if(eChosen.getWeight() >= 0)
				f.addEdge(eChosen, v, dQueue.peek());
		}
	}
	
}
