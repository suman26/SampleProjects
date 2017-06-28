
//BFS.JAVA
package example;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings({ "unchecked", "rawtypes" })
	BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public void deleteEdge(int v,int w)
	{
		adj[v].remove(w);
	}

	public void BFSDisplay(int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[V];
		visited[s] = true;
		queue.add(s);
		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].iterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 5;
		BFS b = new BFS(v);
		b.addEdge(0, 1);
		b.addEdge(0, 2);
		b.addEdge(1, 2);
		b.addEdge(2, 3);
		b.addEdge(3, 4);
		b.BFSDisplay(0);
	}

}
