import graph.Graph;

import java.io.IOException;

class MyDfsGraph extends Graph {
	public MyDfsGraph(String graphHolder) throws IOException {
		super(graphHolder);
	}
	
	public MyDfsGraph(String graphHolder, int order, int size,
			boolean directed, boolean weighted) {
		super(graphHolder, order, size, directed, weighted);
	}
	
	public void dfs(int v) {
		preVisit(v);
		markVertex(v);
		for (Integer x : getNeighbors(v)) {
			if (vertexMarked(x))
				doMarked(v, x);
			else {
				doUnmarked(v, x);
				dfs(x);
			}
		}
		postVisit(v);
	}
	
	public void doMarked(int v, int x) {
	}
	
	public void doUnmarked(int v, int x) {
	}
	
	public void preVisit(int v) {
	}
	
	public void postVisit(int v) {
	}
}