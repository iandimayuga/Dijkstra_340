package imo;

import java.util.LinkedList;

import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class DisplayTest
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args)
	{
		
		Vertex vA = new Vertex( "A");
		Vertex vB = new Vertex( "B");
		Vertex vC = new Vertex( "C");
		Edge eAB = new Edge( 14);
		Edge eAC = new Edge( 8);
		Edge eBC = new Edge( 29);
		
		Graph<Vertex, Edge> g = new SparseGraph<Vertex, Edge>();
		
		g.addVertex( vA);
		g.addVertex( vB);
		g.addVertex( vC);
		g.addEdge( eAB, vA, vB, EdgeType.DIRECTED);
		g.addEdge( eAC, vA, vC, EdgeType.DIRECTED);
		g.addEdge( eBC, vB, vC, EdgeType.DIRECTED);
		
		Forest<Vertex, Edge> f = new DelegateTree<Vertex, Edge>();
		
		f.addVertex( vA);
		f.addEdge( eAB, vA, vB);
		f.addEdge( eAC, vA, vC);
		
		LinkedList<Vertex> vHigh = new LinkedList<Vertex>();
		LinkedList<Edge> eHigh = new LinkedList<Edge>();
		
		vHigh.add( vA);
		vHigh.add( vC);
		eHigh.add( eAC);
		
		Graph<Vertex, Edge> rg = GraphGen.getGraph(25, 1, 10, 0);
		
		Display.print( rg, f, vHigh, eHigh);
	}
	
}
