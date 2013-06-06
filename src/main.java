import graph.DfsGraph;

// Project 4: Strongly Connected Components - Due Wed June 5
//
// Develop a program to compute the strongly connected components of a directed graph.
// Use the various graph classes provided and the algorithm described in class. The steps are described below.
// 
// 1. Write a main program that reads an input graph file, constructs a graph and prints out the adjacency lists.
//	Done.
//
// 2. Use the DfsGraph class provided and depth-first search to implement the strongly connected components algorithm 
//  described by pseudocode on the course site and run it on the initial test graphs.
//
//
// 3. Implement your own version of the DfsGraph class and make sure it produces correct results.
//
// 4. Run your program on the final test graph.
//
// 5. Submit a project report that includes code and output for all test graphs provided.
//

public class main {
	static boolean	DEBUG	= true;
	
	public static void main(String[] args) {
		DfsGraph g = null;
		try {
			if (!DEBUG)
				g = new DfsGraph(args[0]);
			else
				g = new DfsGraph("~/Downloads/graph3.txt");
		} catch (Exception e) {
			System.out.println("Wrong arguments. Expected: filename");
			System.exit(1);
		}
		System.out.println(g.toString());
		// g.dfs(0);
		// for (int i = 0; i < g.getOrder(); i++)
		// System.out.println(g.getVertex(i).getIndex());
	}
}