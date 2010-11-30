package imo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.Collection;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.DefaultEdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.EdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public final class Display
{
	public static boolean DISPLAY = true;
	
	private JFrame frame;
	private JPanel panel;
	
	private Layout<Vertex, Edge> graph;
	private TreeLayout<Vertex, Edge> tree;
	private BasicVisualizationServer<Vertex, Edge> left;
	private BasicVisualizationServer<Vertex, Edge> right;
	private Collection<Vertex> vHigh;
	private Collection<Edge> eHigh;
	
	private Transformer<Vertex, Paint> vPaint = new Transformer<Vertex, Paint>()
	{
		public Paint transform( Vertex v)
		{
			if( vHigh.contains( v)) {
				return Color.yellow;
			} else if( v.isFinal()) {
				return Color.green;
			} else {
				return Color.red;
			}
		}
	};
	
	private Transformer<Edge, Paint> ePaint = new Transformer<Edge, Paint>()
	{
		public Paint transform( Edge e)
		{
			return eHigh.contains( e) ? Color.red : Color.black;
		}
	};
	
	private EdgeLabelRenderer eRend = new DefaultEdgeLabelRenderer( Color.red, false);
	
	public Display( Graph<Vertex, Edge> g, Forest<Vertex, Edge> f, final Collection<Vertex> vHigh, final Collection<Edge> eHigh)
	{
		if( DISPLAY) {
			this.vHigh = vHigh;
			this.eHigh = eHigh;
			
			graph = new ISOMLayout<Vertex, Edge>( g);
			
			// left side
			try {
				graph.setSize( new Dimension( 500, 500));
			} catch( NullPointerException e) {
				System.out.println( "Display has not been initialized");
				System.exit( -1);
			}
			
			left = new BasicVisualizationServer<Vertex, Edge>( graph);
			left.setPreferredSize( new Dimension( 600, 600));
			
			left.getRenderContext().setVertexFillPaintTransformer( vPaint);
			left.getRenderContext().setEdgeDrawPaintTransformer( ePaint);
			left.getRenderContext().setVertexLabelTransformer( new ToStringLabeller());
			left.getRenderContext().setEdgeLabelTransformer( new ToStringLabeller());
			left.getRenderContext().setEdgeLabelRenderer( eRend);
			left.getRenderer().getVertexLabelRenderer().setPosition( Position.CNTR);
			
			// right side
			if( f != null) {
				tree = new TreeLayout<Vertex, Edge>( f);
				
				right = new BasicVisualizationServer<Vertex, Edge>( tree);
				right.setPreferredSize( new Dimension( 600, 600));
				
				right.getRenderContext().setVertexFillPaintTransformer( vPaint);
				right.getRenderContext().setEdgeDrawPaintTransformer( ePaint);
				right.getRenderContext().setVertexLabelTransformer( new ToStringLabeller());
				right.getRenderContext().setEdgeLabelTransformer( new ToStringLabeller());
				right.getRenderContext().setEdgeLabelRenderer( eRend);
				right.getRenderer().getVertexLabelRenderer().setPosition( Position.CNTR);
				
				right.setLocation( 600, 0);
			}
			
			left.setLocation( 0, 0);
			
			frame = new JFrame( "Dijkstra's Algorithm");
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
			// start frame
			panel = new JPanel();
			panel.add( left);
			if( right != null) panel.add( right);
			frame.getContentPane().add( panel);
			frame.pack();
			frame.setVisible( true);
		}
	}
	
	/**
	 * Displays a graph and a tree, side by side.
	 * 
	 * @param g The graph, displayed in traditional layout
	 * @param f The tree, displayed as a tree.
	 * @param vHigh A set of vertices you'd like highlighted in a color different from both "finalized" and "unfinalized."
	 * @param eHigh A set of edges you'd like highlighted. Good for "best path" highlighting.
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	public void print()
	{
		if( DISPLAY) {
			
			Scanner s = new Scanner( System.in);
			if( tree != null) {
				panel.remove( right);
				
				tree = new TreeLayout<Vertex, Edge>( (Forest<Vertex, Edge>) tree.getGraph());
				
				right = new BasicVisualizationServer<Vertex, Edge>( tree);
				right.setPreferredSize( new Dimension( 600, 600));
				
				right.getRenderContext().setVertexFillPaintTransformer( vPaint);
				right.getRenderContext().setEdgeDrawPaintTransformer( ePaint);
				right.getRenderContext().setVertexLabelTransformer( new ToStringLabeller());
				right.getRenderContext().setEdgeLabelTransformer( new ToStringLabeller());
				right.getRenderContext().setEdgeLabelRenderer( eRend);
				right.getRenderer().getVertexLabelRenderer().setPosition( Position.CNTR);
				
			}
			
			panel.remove( left);
			left.fireStateChanged();
			panel.add( left);
			left.setLocation( 0, 0);
			
			if( right != null) {
				panel.add( right);
				right.setLocation( 600, 0);
			}
			
			frame.pack();
			frame.setVisible( true);
			
			s.nextLine();
		}
	}
}
