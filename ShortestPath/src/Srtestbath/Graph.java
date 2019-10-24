/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Srtestbath;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
public class Graph {

      private boolean adjacencyMatrix[][];

      private int vertexCount;

 

      public Graph(int vertexCount) {

            this.vertexCount = vertexCount;

            adjacencyMatrix = new boolean[vertexCount][vertexCount];

      }

 

      public void addEdge(int i, int j) {

            if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {

                  adjacencyMatrix[i][j] = true;

                  adjacencyMatrix[j][i] = true;

            }

      }

 

      public void removeEdge(int i, int j) {

            if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {

                  adjacencyMatrix[i][j] = false;

                  adjacencyMatrix[j][i] = false;

            }

      }

 

      public boolean isEdge(int i, int j) {

            if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount)

                  return adjacencyMatrix[i][j];

            else

                  return false;

      }

    @Override
    public String toString() {
        return "Graph{" + "adjacencyMatrix=" + adjacencyMatrix + ", vertexCount=" + vertexCount + '}';
    }

}
