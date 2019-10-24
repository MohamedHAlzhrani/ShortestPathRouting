package Srtestbath;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
 
public class BellmanFord
{ static int  MAX_VALUE=999;
     
    static  Scanner  input ;
    public static  String [] GraphFiles() throws FileNotFoundException
    { String [] Files = new String[6];
        GeneratFiles File1 = new GeneratFiles(50 , 15);
        File1.createfile();
        Files[1]=File1.getfilename();
       GeneratFiles File2 = new GeneratFiles(100, 25);
        File2.createfile();
        Files[2]=File2.getfilename();
        GeneratFiles File3 = new GeneratFiles(150 , 30);
        File3.createfile();
         Files[3]=File3.getfilename();
      GeneratFiles File4 = new GeneratFiles(200 , 40);
        File4.createfile();
         Files[4]=File4.getfilename();
      GeneratFiles File5 = new GeneratFiles(250 , 50);
        File5.createfile();
         Files[5]=File5.getfilename();
         return   Files ;
    
    }
    public static void createadjacencymatrix( int [][] matrix ,String Fname) throws FileNotFoundException
    { input = new Scanner(new  File( Fname));
    for (int sourcenode = 1; sourcenode < matrix.length; sourcenode++)
        {
            for (int destinationnode = 1; destinationnode < matrix.length; destinationnode++)
            {
                matrix[sourcenode][destinationnode] = input.nextInt();
 	        if (sourcenode == destinationnode)
                {
                    matrix[sourcenode][destinationnode] = 0;
                    continue;
                }
                if (matrix[sourcenode][destinationnode] == 0)
                {
                    matrix[sourcenode][destinationnode] = MAX_VALUE;
                }
            }
        }
   for(int i = 1; i <matrix.length; i++)
    {
        for(int j = 1 ; j<matrix.length ;j++)
            { if(matrix[i][j] != matrix[j][i])
                    matrix[j][i]=matrix[i][j];}
    } 
    
    }
              
 //==================start main====================
    public static void main(String  [] arg) throws FileNotFoundException
    {    Scanner scanner = new Scanner(System.in);
        int source;
        
          System.out.println("Enter the source vertex");
        source = scanner.nextInt();
        int [][] adjacencymatrix50=new int[51][51];
        int [][] adjacencymatrix100=new int[101][101];
        int [][] adjacencymatrix150=new int[151][151];
        int [][] adjacencymatrix200=new int[201][201];
        int [][] adjacencymatrix250=new int[251][251];
        String [] files=GraphFiles();
        
         createadjacencymatrix(adjacencymatrix50 ,  files[1] );
         createadjacencymatrix(adjacencymatrix100 , files[2] );
         createadjacencymatrix(adjacencymatrix150 , files[3] );
         createadjacencymatrix(adjacencymatrix200 , files[4] );
        
        createadjacencymatrix(adjacencymatrix250 , files[5] );
       
        ShortPathDijkestra  DGraph50 = new ShortPathDijkestra(50); 
        ShortPathDijkestra  DGraph100 = new ShortPathDijkestra(100);
        ShortPathDijkestra  DGraph150 = new ShortPathDijkestra(150);
        ShortPathDijkestra  DGraph200 = new ShortPathDijkestra(200);
        ShortPathDijkestra  DGraph250 = new ShortPathDijkestra(250);
        
        Graph DGraphu50 = new Graph(50); 
        Graph  DGraphu100 = new Graph(100);
        Graph  DGraphu150 = new Graph(150);
        Graph  DGraphu200 = new Graph(200);
        Graph  DGraphu250 = new Graph(250);
          
        
        //==================================
        BellmanShortPath BGraph50 =  new BellmanShortPath(50);
        BGraph50.BellmanFordEvaluation(source, adjacencymatrix50); 
        BellmanShortPath BGraph100 = new BellmanShortPath(100);
        BellmanShortPath BGraph150 = new BellmanShortPath(150);
        BellmanShortPath BGraph200 = new BellmanShortPath(200);
       BellmanShortPath BGraph250 = new BellmanShortPath(250);
        
        BGraph50.BellmanFordEvaluation(source, adjacencymatrix50);
        BGraph100.BellmanFordEvaluation(source, adjacencymatrix100);
        BGraph150.BellmanFordEvaluation(source, adjacencymatrix150);
        BGraph200.BellmanFordEvaluation(source, adjacencymatrix200);
        BGraph250.BellmanFordEvaluation(source, adjacencymatrix250);
      
        //=================================
          
           DGraph50.dijkstra(adjacencymatrix50, source);
           DGraph100.dijkstra(adjacencymatrix100,source);
           DGraph150.dijkstra(adjacencymatrix150,source);
           DGraph200.dijkstra(adjacencymatrix200, source);
           DGraph250.dijkstra(adjacencymatrix250, source);
       
           RoutTable [] rout = new RoutTable[10];
           rout[0]= new RoutTable("Graph50","Dijkstra", DGraph50.getTotalpath());
           rout[1]= new RoutTable("Graph50","BellmanFord",BGraph50.getTotalpath());
           rout[2]= new RoutTable("Graph100","Dijkstra",DGraph100.getTotalpath());
           rout[3]= new RoutTable("Graph100","BellmanFord",BGraph100.getTotalpath());
           rout[4]= new RoutTable("Graph150","Dijkstra",DGraph150.getTotalpath());
           rout[5]= new RoutTable("Graph150","BellmanFord",BGraph150.getTotalpath());
           rout[6]= new RoutTable("Graph200","Dijkstra",DGraph200.getTotalpath());
           rout[7]= new RoutTable("Graph200","BellmanFord",BGraph200.getTotalpath());
           rout[8]= new RoutTable("Graph250","Dijkstra",DGraph250.getTotalpath());
           rout[9]= new RoutTable("Graph250","BellmanFord",BGraph250.getTotalpath());
        System.out.println("========Lan Project Rout Table for shortest path=====================");
        System.out.println(" from vertex "+ source + "to all vertex in graph ");   
        System.out.println("");
           
           for(int i = 0; i< 10; i ++)
           {System.out.println(rout[i]);
            }
           System.out.println("g"+DGraphu50.toString());
           DGraphu100.toString();
           DGraphu150.toString();
           DGraphu200.toString();
           DGraphu250.toString();
           scanner.close();
           
    }
}