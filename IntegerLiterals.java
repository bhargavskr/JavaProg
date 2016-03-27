class IntegerLiterals
{
   public static void main(String arg[])
   {
   int a,x,d,g,f;
   a=21;
   System.out.println(a);
   a=06;
   System.out.println(a);
 a=(int)0x21209210912L;  
    System.out.println(a);
   a=0x278;
    System.out.println(a);
	a=0Xafbb;
	 System.out.println(a);
   long z=21209210912L;
	 System.out.println(z);
 z=0x21209210912L;
	 System.out.println(a);	
   float c;
   double r;
   c=19012.09809f;
 System.out.println(c);	
   
   c=827827.18921982f;
 System.out.println(c);	
   
   r=281782.29879;
 System.out.println(r);	
   
   r=2817281.329873d;
 System.out.println(r);	
   char l;
   l='a';
   System.out.println(l);
   l='a'+'b';
   System.out.println(l);
   l='\144';
      System.out.println(l);
	  l='\ua432';
      System.out.println(l);
   String q="hsdlkjs jfsdkfewrfwe";
      System.out.println(q);
   
   byte p;
   int o;
   double i;
   
   o=878;
   i=9879.7843;
      System.out.println(o);
      System.out.println(i);
	  p=(byte)o;
	     System.out.println(p);
		 p=(byte)i;
		    System.out.println(p);
      o=(int)i;
      System.out.println(o);
   
   int aa[]={554,76,657,675,675};
   int[] bb=new int[5];
 // int ii;
   for(int ii=0;ii<5;ii++){
		
  // aa[ii]=ii;
   bb[ii]=ii;
      System.out.println(aa[ii]);
	  System.out.println(bb[ii]);
	  }
 //  System.out.println(ii);
  
int pp[][]=new int[3][];
pp[0]=new int[4];
pp[1]=new int[6];
pp[2]=new int[8];
int ll,oo;
for(ll=0;ll<3;ll++){
  System.out.println("\n");
for(oo=0;oo<4+ll*2;oo++)

  System.out.print(pp[ll][oo]);
  }
    System.out.println("\n");
  int ppp[][]=new int[3][3];
 

 for(ll=0;ll<3;ll++){
  //System.out.println("\n");
for(oo=0;oo<3;oo++)
System.out.print(ppp[ll][oo]);
}
 int kk;

 int pppp[][][]=new int[3][3][3];
  for(ll=0;ll<3;ll++){
  System.out.println("\n");
for(oo=0;oo<3;oo++)
{
System.out.println("\n");
for(kk=0;kk<3;kk++)
System.out.print(pppp[ll][oo][kk]);
}
 }
  

  }
   
   }