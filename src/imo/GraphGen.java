package imo;

import java.util.ArrayList;

import edu.uci.ics.jung.graph.Graph;

/**
 * A class for generating Graphs, either randomly or from a file.
 *
 */
public final class GraphGen
{
	private GraphGen()
	{ //Cannot instantiate
	}
	
	/**
	 * Randomly generates a Graph within specified parameters.
	 * @param numV Number of vertices.
	 * @param numE Number of edges.
	 * @param seed Seed for pseudo-random generation.
	 * @return A random Graph with numV vertices and numE edges.
	 */
	public Graph<Vertex, Edge> getGraph( int numV, int numE, long seed)
	{
		return null;
	}
	
	/**
	 * Loads a Graph from a file representing an adjacency matrix.
	 * @param file Relative filepath of the input Graph.
	 * @return The Graph represented in the file.
	 */
	public Graph<Vertex, Edge> getGraph( String file)
	{
		return null;
	}
	
	private ArrayList<Vertex> genVerts( int numV)
	{
		return null;
	}
}
