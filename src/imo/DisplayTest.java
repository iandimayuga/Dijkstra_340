package imo;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

public class DisplayTest
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main( String[] args) throws FileNotFoundException
	{
		
		Vertex vA = new Vertex( "A");
		Vertex vB = new Vertex( "B");
		Vertex vC = new Vertex( "C");
		Edge eAB = new Edge( 14);
		Edge eAC = new Edge( 8);
		Edge eBC = new Edge( 29);
		
		Graph<Vertex, Edge> g = new DirectedSparseGraph<Vertex, Edge>();
		
		g.addVertex( vA);
		g.addVertex( vB);
		g.addVertex( vC);
		g.addEdge( eAB, vA, vB);
		g.addEdge( eAC, vA, vC);
		g.addEdge( eBC, vB, vC);
		
		Forest<Vertex, Edge> f = new DelegateTree<Vertex, Edge>();
		
		f.addVertex( vA);
		f.addEdge( eAB, vA, vB);
		f.addEdge( eAC, vA, vC);
		
		LinkedList<Vertex> vHigh = new LinkedList<Vertex>();
		LinkedList<Edge> eHigh = new LinkedList<Edge>();
		
		vHigh.add( vA);
		vHigh.add( vC);
		eHigh.add( eAC);
		
		Graph<Vertex, Edge> rg = GraphGen.getGraph("resources/testgraph.csv");
		
		Display.print( rg, f, vHigh, eHigh);
	}
	
}
