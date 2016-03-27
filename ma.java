class multiply
{
   int a[3][3],b[3][3],c[3][3],i,j;
   multiply()
   {
     for(i=0;i<3;i++)
     {
        for(j=0;j<3;j++)
        {
          c[i][j]=0;
        }
      }
   }
   void getdata()throws IOException
   {
       DataInputStream dis=new DataInputStream(System.in); 
       System.out.println(" enter matrixa");
       a=Integer.parseInt(dis.readLine());
       System.out.println(" enter matrixb");
       b=Integer.parseInt(dis.readLine());
  }
 void calc()
 {
    for(i=0;i<3;i++)
      for(j=0;j<3;j++)
        c[i][j]=0;
    for(i=0;i<3;i++)
      for(j=0;j<3;j++)
        for(k=0;k<3;k++)
     c[i][j]=c[i][j]+(a[i][k]*b[k][j])
   