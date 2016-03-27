import java.io.*;
class matrix
{
  int i,j,k;
  int a[][]=new int[3][3];
  int b[][]=new int[3][3];
  int c[][]=new int[3][3];
  void getdata() throws IOException
  {  
     
     InputStreamReader ds=new InputStreamReader(System.in);
     BufferedReader ds1=new BufferedReader(ds);
     System.out.println(" enter the values of first matrix "); 
     {
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
       a[i][j]=Integer.parseInt(ds1.readLine());
     }
     InputStreamReader di=new InputStreamReader(System.in);
     BufferedReader di1=new BufferedReader(di);
     System.out.println(" enter the values of second matrix "); 
     {
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
       b[i][j]=Integer.parseInt(di1.readLine());
     }
   }
  void calc()
  {
        for(i=0;i<3;i++)
        {
           for(j=0;j<3;j++)
           {
              System.out.print(+a[i][j]+" ");
           }
          System.out.println();
        }
        System.out.println(" \n ");
        for(i=0;i<3;i++)
        { 
           for(j=0;j<3;j++)
           {
              System.out.print(+b[i][j]+" ");
           }
          System.out.println();
        }
        System.out.println(" \n ");
        for(i=0;i<3;i++)
        { 
           for(j=0;j<3;j++)
           {
             c[i][j]=0;
           }
        }
        for(i=0;i<3;i++)
        {   
           
           for(j=0;j<3;j++)
           { 
              
             for(k=0;k<3;k++)
              {
                 c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
              }
             System.out.print(c[i][j]+" ");
           }
           System.out.println();
        }
  }
}
class matmul
{
 public static void main(String arg[])throws IOException
 {
 matrix x=new matrix();
  x.getdata();
 x.calc();
 }
}
