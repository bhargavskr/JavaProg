class length
{
  int l;
  length()
  {
       l=-1;
  }
  length(int x)
  {
       l=x;
  }
}
class breadth extends length
{
  
  int b;
  breadth()
  {
       super();
       b=-1;
  }
  breadth(int x,int y)
  {  
       super(x);
       b=y;
  }
  void area()
  {
    System.out.println(" area "+l*b);
  }
}
class height extends breadth
{
  
  int h;
  height()
  {    
       super();
       h=-1;
  }
  height(int x,int y,int z)
  {
       super(x,y);
       h=z;
  }
  void volume()
  {
    System.out.println(" volume "+h*l*b);
  }
} 
class multiinherit
{
   public static void main(String arg[])
   {
     height n=new height(10,20,30);
     n.volume();
     n.area();
   }
}