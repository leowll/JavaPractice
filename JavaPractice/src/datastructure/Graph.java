package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	String[] vertex;
	int[][] edges;
	int edgeNum;

	public Graph(int n) {
		this.edges = new int[n][n];
	}

	public void setVertex(String[] v) {
		this.vertex = v;
	}

	public void addEdge(int v1, int v2, int weight) {
		this.edges[v1][v2] = weight;
		this.edges[v2][v1] = weight;
		this.edgeNum++;
	}

	public void bfs() {
		boolean visited[] = new boolean[this.vertex.length];
		for (int i = 0; i < this.vertex.length; i++) {
			if (!visited[i]) {
				bfs(visited, i);
			}
		}
	}

	private void bfs(boolean[] visited, int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(v);
		visited[v] = true;
		int u, iNeighbor;
		System.out.print(vertex[v] + " ");
		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			iNeighbor = getFirstNeighbor(u);
			while (iNeighbor != -1) {
				if (!visited[iNeighbor]) {
					queue.addLast(iNeighbor);
					visited[iNeighbor] = true;
					System.out.print(vertex[iNeighbor] + " ");
				}
				iNeighbor = getNextNeighbor(u, iNeighbor);
			}
		}
	}

	public void dfs() {
		boolean visited[] = new boolean[this.vertex.length];
		for (int i = 0; i < this.vertex.length; i++) {
			if (!visited[i]) {
				dfs(visited, i);
			}
		}
	}

	private void dfs(boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(this.vertex[v] + " ");
		int iNeighbor = getFirstNeighbor(v);
		while (iNeighbor != -1) {
			if (!visited[iNeighbor]) {
				dfs(visited, iNeighbor);
			}
			iNeighbor = getNextNeighbor(v, iNeighbor);
		}
	}

	private int getFirstNeighbor(int v) {
		for (int i = 0; i < vertex.length; i++) {
			if (this.edges[v][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	private int getNextNeighbor(int v, int iNeighbor) {
		for (int i = iNeighbor + 1; i < vertex.length; i++) {
			if (this.edges[v][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		Graph g = new Graph(6);
		g.setVertex(new String[] { "V1", "V2", "V3", "V4", "V5", "V6" });
		g.addEdge(0, 1, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(2, 5, 1);
		g.bfs();
		System.out.println("\n");
		g.dfs();
	}

}