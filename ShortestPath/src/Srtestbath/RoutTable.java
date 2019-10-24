/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Srtestbath;
 
public class RoutTable 
{
public String graph;
public String algorithm;
public int totlapath;

    public RoutTable(String graph, String algorithm, int totlapath) {
        this.graph = graph;
        this.algorithm = algorithm;
        this.totlapath = totlapath;
    }

    @Override
    public String toString() {
        return "RoutTable{" + "graph=" + graph + ", algorithm=" + algorithm + ", totlapath=" + totlapath + '}';
    }



    
}
