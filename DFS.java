package example;

import java.util.Iterator;
import java.util.LinkedList;



public class DFS {
      private int V;
      private LinkedList<Integer> adj[];
      
      @SuppressWarnings("unchecked")
	DFS(int v)
      {
    	  V=v;
    	  adj=new LinkedList[v];
    	  for(int i=0;i<v;i++)
    		  adj[i]=new LinkedList<Integer>();
      }
      void addEdge(int u,int w)
      {
    	  adj[u].add(w);
      }
      void DFSUtils(int s,boolean []visited)
      {
    	  visited[s]=true;
    	  System.out.print(s+" ");
    	  Iterator<Integer> it =adj[s].iterator();
    	  Integer i;
    	  while(it.hasNext())
    	  {
    		   i=it.next();
    		  if(visited[i]==false)
    			 DFSUtils(i,visited);
    		  
    	  }
      }
      void DFSGraph()
      {
    	  boolean []visited=new boolean[V];
    	  for(int i=0;i<V;i++)
    	  {
    		 if(visited[i]==false)
    			DFSUtils(i,visited); 
    	  }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS df =new DFS(5);
		df.addEdge(0, 1);
		df.addEdge(0, 2);
		df.addEdge(2, 3);
		df.addEdge(1, 4);
		df.addEdge(4, 3);
		df.DFSGraph();

	}

}
