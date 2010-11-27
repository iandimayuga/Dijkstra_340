package imo;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex>{

	@Override
	public int compare(Vertex arg0, Vertex arg1) {
		if (arg0.getDistance() > arg1.getDistance()){
			return 1;
		}
		else if (arg0.getDistance() < arg1.getDistance()){
			return -1;
		}
		return 0;
	}
	
}
