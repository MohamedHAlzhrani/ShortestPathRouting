/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Srtestbath;
 
public class ShortPathDijkestra
{public   int  V;
 int totalpath;
 public ShortPathDijkestra( int s)
 { 
     V=s+1;
 }
    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;
        for (int v = 1; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    void printSolution(int dist[], int n)
    {  
        //System.out.println("Vertex  Distance from  Source  to ");
        for (int i = 0; i < V; i++)
        {// System.out.println( i+ " =  "+dist[i]);
        totalpath+=dist[i];
        }
    }
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V+1];
        Boolean sptSet[] = new Boolean[V+1];
        for (int i = 1; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 1; v < V; v++)
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
    printSolution(dist, V);
    }   
    
    public int getTotalpath()
    {return totalpath;}
}
