 
package Srtestbath;
 
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class GeneratFiles
{   public int size;
    public    Random rnd ;
    public   String newline ;
    public  Formatter  output ; 
    public int EdgeRang;
    String filename;
public GeneratFiles( int siz ,int edgrange) throws FileNotFoundException     
{  this.size=siz;
     EdgeRang=edgrange;
     filename = "Graph"+size+".txt";
    output = new Formatter(filename );
     rnd= new Random(); 
     newline=System.getProperty("line.separator");
}

     
 public void createfile()
 {  
    for(int i = 0; i <size; i++)
    {for(int j = 0 ; j<size ;j++)
             { int num=rnd.nextInt((EdgeRang));
                    if(i==j)  
                         output.format("%d  ",0);
                   else
                     
                   output.format("%d  ",num);
               }
               output.format("%s" ,newline);
    } 
    output.close();
 }
 public String getfilename(){return filename;}
    
     
      
      
     }
       
    

