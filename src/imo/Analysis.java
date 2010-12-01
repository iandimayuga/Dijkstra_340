package imo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Analysis
{
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main( String[] args) throws IOException
	{
		PrintWriter out = new PrintWriter(new FileWriter( new File("analysis/data.csv")));
		Display.DISPLAY = false;
		for( int i = 10; i < 2000; i+= 10) {
			long sum = 0;
			int repeats = 10;
			for( int j = 0; j < repeats; j++) {
				System.out.println("Creating graph of size " + i);
				Dijkstra d = new Dijkstra( GraphGen.getGraph( i, 1, 50));
				System.out.print( "Running... ");
				System.out.flush();
				long time = System.currentTimeMillis();
				d.run();
				time = System.currentTimeMillis() - time;
				System.out.println(" time = " + time);
				sum += time;
			}
			long average = sum / repeats;
			System.out.println("AVERAGE = " + average);
			out.println(i + "," + average);
		}
		out.flush();
		out.close();
	}
	
}
