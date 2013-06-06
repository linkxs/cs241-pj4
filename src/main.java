import graph.DfsGraph;

import java.io.IOException;
import java.util.Stack;

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
//	Done.
//
// 3. Implement your own version of the DfsGraph class and make sure it produces correct results.
//
// 4. Run your program on the final test graph.
//
// 5. Submit a project report that includes code and output for all test graphs provided.
//

public class main {
	static boolean	DEBUG	= false;
	
	public static void main(String[] args) {
		StrongDfs g = null;
		try {
			if (!DEBUG)
				g = new StrongDfs(args[0]);
			else
				g = new StrongDfs("/Users/linkxs/Downloads/graph3.txt");
		} catch (Exception e) {
			System.out.println("Wrong arguments. Expected: filename");
			System.exit(1);
		}
		System.out.print(g.toString());
		
		g.passOne(); // Perform persistent depth-first search on g, visiting
						// vertices in natural order.
		StrongDfs h = reverse(g); // Construct graph h, which is a copy of g
									// with each edge reversed.
		System.out.println("Vertex stack: " + h.s.toString());
		System.out.print(h.toString());
		h.passTwo();
	}
	
	static StrongDfs reverse(StrongDfs g) {
		StrongDfs h = new StrongDfs("reverse(" + g.getName() + ")",
				g.getOrder(), g.getSize(), g.isDirected(), g.isWeighted());
		for (int i = 0; i < g.getOrder(); i++)
			for (Integer j : g.getVertex(i).getNeighbors())
				h.addEdge(j, i);
		h.s = (Stack<Integer>) g.s.clone();
		return h;
	}
}

class StrongDfs extends DfsGraph {
	public Stack<Integer>	s		= new Stack<Integer>();
	private boolean			passOne	= false;
	
	public StrongDfs(String arg0) throws IOException {
		super(arg0);
	}
	
	public StrongDfs(String string, int order, int size, boolean directed,
			boolean weighted) {
		super(string, order, size, directed, weighted);
	}
	
	void passOne() {
		passOne = true;
		for (int i = 0; i < order; i++) {
			if (!vertexMarked(i))
				dfs(i);
		}
	}
	
	// Perform persistent depth-first search on h, visiting the vertices in LIFO
	// order using the stack.
	void passTwo() {
		passOne = false;
		int num = 1;
		while (!s.empty()) {
			int v = s.peek();
			System.out.println("Component " + num);
			if (!vertexMarked(v))
				dfs(v);
			num++;
		}
	}
	
	public void preVisit(int v) {
		if (!passOne) {
			System.out.println("\t" + v);
			s.pop();
		}
	}
	
	// During the search, when post-visiting vertex v, push v on a stack.
	public void postVisit(int v) {
		if (passOne)
			s.push(v);
	}
}
