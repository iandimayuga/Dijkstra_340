package imo;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraQueue {
	
	private Comparator<Vertex> comparator = new VertexComparator();
	private PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>(10, comparator);
	
	//When creating the queue collect all Vertices and add them to pQueue
	public void DijkstraQueue(Collection<Vertex> vertices){
		this.pQueue.addAll(vertices);
	}

}
