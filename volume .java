class rect
{
   int length;
   int breadth;
   rect()
   {
      length=-1;
      breadth=-1;
   }
   rect(int l,int b)
   {
     length=l;
     breadth=b;
   }
   int area()
   {
      return length*breadth;
   }
}
class box extends rect
{
  double height;
  box(int l,int b,int h)
  {
     length=l;
     breadth=b;
     height=h;
  }
class volume
{
  System.out.println(String arg[])
  {
       box b=new box(20,20,18);
       b.volume();
       rect r=new rect():
       r=b;
       System.out.println(" area "+r.area());
       System.out.println("height:"+r.height);
   }
}