package example;

import java.util.Iterator;
import java.util.LinkedList;
/*
 Using DFS to detect the cycle in undirected graph 
 */
public class CycleInUndirected {
private int V;
private LinkedList<Integer> adj[];

@SuppressWarnings("unchecked")
CycleInUndirected(int v)
{
	V=v;
	adj=new LinkedList[v];
	for(int j=0;j<v;j++)
		adj[j]= new LinkedList<Integer>();
}
void addEdge(int u,int w)
{
	adj[u].add(w);
	adj[w].add(u);
}
 boolean cycleInUndirectedGraph(int s,boolean visited[],int parent)
 {
	 visited[s]=true;
	 Integer i;
	 Iterator<Integer> it =adj[s].iterator();
	 while(it.hasNext())
	 {
		 i =it.next();
		 if(visited[i]!=true)
		 {
			 if(cycleInUndirectedGraph(i,visited,s))
				 return true;
		 }
		 else if(parent !=i)
			 return true;
	 }
	 return false;
 }
 
 boolean cycleDetection()
 {
	 boolean visited[]=new boolean[V];
	 for(int k=0;k<V;k++)
		 visited[k]=false;
	 
	 for(int k=0;k<V;k++)
	 {
		 if(visited[k]!=true)
		 {
			 if(cycleInUndirectedGraph(k,visited,-1))
				 return true;
		 }
	 }
	 return false;
	 
 }
 public static void main(String args[])
 {
     // Create a graph given in the above diagram
	 CycleInUndirected g1 = new CycleInUndirected(5);
     g1.addEdge(1, 0);
     g1.addEdge(0, 2);
     g1.addEdge(2, 0);
     g1.addEdge(0, 3);
     g1.addEdge(3, 4);
     if (g1.cycleDetection())
         System.out.println("Graph contains cycle");
     else
         System.out.println("Graph doesn't contains cycle");

     CycleInUndirected g2 = new CycleInUndirected(3);
     g2.addEdge(0, 1);
     g2.addEdge(1, 2);
     if (g2.cycleDetection())
         System.out.println("Graph contains cycle");
     else
         System.out.println("Graph doesn't contains cycle");
 }
}
