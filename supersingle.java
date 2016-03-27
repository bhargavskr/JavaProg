class rect
{
  int length;
  int breadth;
  rect()
  {
      length=-1;
      breadth=-1;
  }
  rect(int a,int b)
  {
    length=a;
    breadth=b;
  }
  rect(rect m)
  {
   length=m.length;
   breadth=m.breadth;
  }
  void area()
  {
    System.out.println(" area :"+length*breadth);
  }
}
class box extends rect
{
  int height;
  box()
  {
    super();
    height=-1;
  }
  box(int l,int b,int h)
  { 
     super(l,b);
     height=h;
  }
  box(box k)
  {
   super(k);
   height=k.height;
  }
  void volume()
  {
    System.out.println(" volume :"+length*breadth*length);
  }
}
class supersingle
{
  public static void main(String arg[])
  { 
    box m=new box(10,20,30);
    box n=new box();
    box p=new box(m);
    m.area();
    n.area();
    p.area();
    m.volume();
    n.volume();
    p.volume();
   }
}
