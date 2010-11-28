package imo;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraQueue {
	
	private Comparator<Vertex> comparator = new VertexComparator();
	private PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>(10, comparator);
	
	//When creating the queue collect all Vertices and add them to pQueue
	public DijkstraQueue(Collection<Vertex> vertices){
		this.pQueue.addAll(vertices);
	}
	
	/*Add a vertex to the queue, PriorityQueue automatically handles
	adding it to the correct spot*/
	public void add(Vertex newV){
		pQueue.add(newV);
	}
	
	//This removes and returns the head of the queue
	public Vertex remove(){
		return pQueue.poll();
	}
	
	public boolean hasMore(){
		return !pQueue.isEmpty();
	}
	
	public void update(Vertex changeV){
		pQueue.remove(changeV);
		pQueue.add(changeV);
	}

}
