import java.util.Scanner;

// Project 4: Strongly Connected Components - Due Wed June 5
//
// Develop a program to compute the strongly connected components of a directed graph.
// Use the various graph classes provided and the algorithm described in class. The steps are described below.
// 
// 1. Write a main program that reads an input graph file, constructs a graph and prints out the adjacency lists.
//
// 2. Use the DfsGraph class provided and depth-first search to implement the strongly connected components algorithm 
//  described by pseudocode on the course site and run it on the initial test graphs.
//
// 3. Implement your own version of the DfsGraph class and make sure it produces correct results.
//
// 4. Run your program on the final test graph.
//
// 5. Submit a project report that includes code and output for all test graphs provided.
//

public class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int order = s.nextInt(), size = s.nextInt();
		boolean directed = false, weighted = true;
		
		if (s.next().equalsIgnoreCase("directed")) {
			directed = true;
			weighted = false;
		}
		Graph g = new Graph("Graph", order, size, directed, weighted);
		
		while (s.hasNext()) {
			if (weighted)
				g.addEdge(s.nextInt(), s.nextInt(), s.nextDouble());
			else
				g.addEdge(s.nextInt(), s.nextInt());
		}
		
		System.out.println(g.toString());
	}
}