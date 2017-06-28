//cycle in graph
package example;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInDirected {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	CycleInDirected(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int u, int w) {
		adj[u].add(w);
	}

	boolean cycleDetect(int s, boolean visited[], boolean rec[]) {
		if (visited[s] == false) {
			visited[s] = true;
			rec[s] = true;
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				int u = it.next();
				if (visited[u] != true && cycleDetect(u, visited, rec))
					return true;
				else if (rec[u] != false)
					return true;
			}
		}
		rec[s] = false;
		return false;

	}

	boolean cycleUtil() {
		boolean visited[] = new boolean[V];
		boolean rec[] = new boolean[V];
		for (int j = 0; j < V; j++) {
			visited[j] = false;
			rec[j] = false;
		}
		for (int i = 0; i < V; i++)
			if (cycleDetect(i, visited, rec)) {
				return true;
			}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 5;
		CycleInDirected ts = new CycleInDirected(v);
		ts.addEdge(0, 1);
		ts.addEdge(0, 2);
		ts.addEdge(2, 3);
		ts.addEdge(3, 1);
		ts.addEdge(1, 2);
		if (ts.cycleUtil())
			System.out.println("There is cycle in graph");
		else
			System.out.println("No Cycle in graph");
	}
}
