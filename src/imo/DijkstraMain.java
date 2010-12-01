package imo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DijkstraMain
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main( String[] args) throws FileNotFoundException
	{
		Scanner s = new Scanner( System.in);
		Dijkstra d = new Dijkstra( GraphGen.getGraph( "resources/Testing.csv"));
		d.run();
		
		System.out.println( "Enter to run a random graph.");
		while( !(s.nextLine().equals( "0"))) {
			Display.INPUT = false;
			d = new Dijkstra( GraphGen.getGraph( 26, 1, 20));
			d.run();
			System.out.println( "Enter to run another random graph.");
		}
	}
	
}
