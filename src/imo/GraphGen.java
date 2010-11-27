package imo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections15.Factory;

import edu.uci.ics.jung.algorithms.generators.random.MixedRandomGraphGenerator;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

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
	 * @param minW Minimum edge weight, inclusive.
	 * @Param maxW Maximum edge weight, exclusive.
	 * @param seed Seed for pseudo-random generation.
	 * @return A random Graph with numV vertices and numE edges.
	 */
	public static Graph<Vertex, Edge> getGraph( final int numV, final int minW, final int maxW, final long seed)
	{
		final Random r = new Random(seed);
		
		Factory<Graph<Vertex,Edge>> gFact = new Factory<Graph<Vertex,Edge>>() {
			@Override
			public Graph<Vertex, Edge> create() {
				return new SparseGraph<Vertex, Edge>();
			}
		};
		
		ArrayList<Vertex> verts = GraphGen.genVerts( numV);
		
		final Iterator<Vertex> vIter = verts.iterator();
		
		Factory<Vertex> vFact = new Factory<Vertex>() {
			@Override
			public Vertex create() {
				return vIter.next();
			}
		};
		Factory<Edge> eFact = new Factory<Edge>() {
			@Override
			public Edge create() {
				return new Edge( r.nextInt(maxW - minW) + minW);
			}
		};
		
		Set<Vertex> vSeed = new HashSet(verts);
		
		Graph<Vertex, Edge> g = MixedRandomGraphGenerator.<Vertex,Edge>generateMixedRandomGraph(gFact, vFact, eFact, new HashMap<Edge,Number>(), numV, false, vSeed);
		
		for(Edge e : g.getEdges())
		{
			Pair<Vertex> pair = g.getEndpoints(e);
			g.removeEdge(e);
			g.addEdge(e, pair,EdgeType.DIRECTED);
		}
		
		return g;
	}
	
	/**
	 * Loads a Graph from a .csv file representing an adjacency matrix.
	 * @param file Relative filepath of the input Graph.
	 * @return The Graph represented in the file.
	 */
	public static Graph<Vertex, Edge> getGraph( String file)
	{
		return null;
	}
	
	private static ArrayList<Vertex> genVerts( int numV)
	{
		ArrayList<Vertex> ret = new ArrayList<Vertex>(numV);
		for(int i = 0; i < numV; i++)
		{
			String name = "";
			for(int repeat = 0; repeat <= i / 26; repeat++)
			{
				name += String.valueOf((char) ((i % 26) + 97));
			}
			ret.add(new Vertex(name));
		}
		
		return ret;
	}
}
