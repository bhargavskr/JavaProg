import java.io.*;
class matmulu
{
 public static void main(String arg[])throws IOException
 {
     int i,j;
     int[][] a;
     a=new int[3][3];
     InputStreamReader dis=new InputStreamReader(System.in);
     BufferedReader dis1=new BufferedReader(dis);
     System.out.println(" enter the values "); 
     {
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
       a[i][j]=Integer.parseInt(dis1.readLine());
     }
 }
}
