/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: PACKAGE_NAME
 */
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.SymbolGraph;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphProperties {

	private Graph g;
	private Integer numberOfVertices;
	private Integer numberOfEdges;
	private HashMap<Integer, List<Integer>> graphData = new HashMap<>();


	private void translateGraphToJava(Graph g) {
		for(int i = 0; i < numberOfVertices; i++) {
			List<Integer> list = new ArrayList<>();
			Bag<Integer> notList = (Bag<Integer>) g.adj(i);
			for(Integer a : notList)
				list.add(a);
			graphData.put(i, list);
		}
	}

	private boolean listContains(List<Integer> list, int checkThis) {
		for(Integer a : list)
			if(a.equals(checkThis)) return true;
		return false;
	}

	private int eccentricity(int startingVertex) {
		List<Integer> connectedVertices = new ArrayList<>();
		connectedVertices.add(startingVertex);
		int lastNumberOfConnected = 0;
		int iterations = 0;
		do {
			iterations++;
			List<Integer> toBeAdded = new ArrayList<>();
			lastNumberOfConnected = connectedVertices.size();
			for(Integer v : connectedVertices) {
				List<Integer> adjacentVertices = graphData.get(v);
				for(Integer av : adjacentVertices) {
					if(!listContains(toBeAdded, av) && !listContains(connectedVertices, av))
						toBeAdded.add(av);
				}
			}
			connectedVertices.addAll(toBeAdded);
			if(connectedVertices.size() == numberOfVertices)
				return iterations;
		} while(lastNumberOfConnected != connectedVertices.size());
		throw new IllegalArgumentException();
	}

	//bara fyrir clarity ad thetta virkar
	private boolean isConnected() {
		try {
			eccentricity(0);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	GraphProperties(Graph g) {
		numberOfEdges = g.E();
		numberOfVertices = g.V();
		translateGraphToJava(g);
		System.out.println("The thing is " + (isConnected() ? "" : "not ") + "connected");
		this.g = g;
	}

	public int diameter() {
		int max = 0;
		for(int i = 0; i < numberOfVertices; i++) {
			int a = eccentricity(i);
			if (a > max) max = a;
		}
		return max;
	}

	public int radius() {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < numberOfVertices; i++) {
			int a = eccentricity(i);
			if(a < min) min = a;
		}
		return min;
	}

	public int center() {
		int r = radius();
		for(int i = 0; i < numberOfVertices; i++)
			if(eccentricity(i) == r) return i;
		return -1;
	}

	public static void main(String[] args) {
		SymbolGraph sg = new SymbolGraph("routes.txt", " ");
		GraphProperties gp = new GraphProperties(sg.graph());

		StdOut.println("Eiginleikar leiðanetsins:");
		StdOut.println("");
		StdOut.println("Þvermál:   " + gp.diameter());
		StdOut.println("Radíus:    " + gp.radius());
		StdOut.println("Miðhnútur: " + sg.nameOf(gp.center()));
		StdOut.println("");
		StdOut.println(" Völlur frávik ");
		StdOut.println("===============");
		for (int v = 0; v < sg.graph().V(); v++) {
			StdOut.println(String.format("  %-5s   %-4d", sg.nameOf(v), gp.eccentricity(v)));
		}
	}

}
