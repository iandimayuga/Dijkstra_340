package imo;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class DijkstraMain
{
	
	/**
	 * @param args
	 */
	public static void main( String[] args)
	{
		Dijkstra d = new Dijkstra();
		d.build("resources/Testing.csv");
		d.run();
	}
	
}
