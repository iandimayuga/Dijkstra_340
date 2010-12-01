package imo;

import java.io.FileNotFoundException;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class DijkstraMain
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main( String[] args) throws FileNotFoundException
	{
		Display.INPUT = false;
		Dijkstra d = new Dijkstra( GraphGen.getGraph(100, 1, 50));
		d.run();
	}
	
}
