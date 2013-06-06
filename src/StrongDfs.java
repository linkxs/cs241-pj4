import java.io.IOException;
import java.util.Stack;

class StrongDfs extends MyDfsGraph {
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
