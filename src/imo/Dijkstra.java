package imo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.uci.ics.jung.graph.Graph;

public class Dijkstra
{
	private Display display;
	private DijkstraQueue dQueue;
	private Graph<Vertex, Edge> g;
	private ArrayList<Vertex> vHigh;
	private ArrayList<Edge> eHigh;
	
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
		dQueue = new DijkstraQueue( g.getVertices());
	}
	
	/*
	 * Remove vertices from the queue. The first vertex in the queue is always the next vertex that needs to be added to the tree. Once that vertex has been removed update the distance values of all unremoved vertices connected to it.
	 */
	public void run()
	{
		while( dQueue.hasMore()) {
			Vertex v = dQueue.remove();
			v.setFinal( true);
			Collection<Edge> edges = g.getOutEdges( v);
			Iterator<Edge> iterator = edges.iterator();
			while( iterator.hasNext()) {
				long time = System.currentTimeMillis() + 1000;
				while( System.currentTimeMillis() < time);
				Edge e = iterator.next();
				Vertex v2 = g.getDest( e);
				if( v2.getDistance() > v.getDistance() + e.getWeight()) v2.setDistance( v.getDistance() + e.getWeight());
				dQueue.update( v2);

				//highlight v and e
				vHigh.clear();
				vHigh.add( v);
				eHigh.clear();
				eHigh.add(e);
				
				display.print();
			}
		}
	}
	
}
