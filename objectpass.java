class rect
{
 int l;
 int b;
 rect()
 {
   l=5;
   b=6;
 }
 rect(int x)
 {
   l=b=x;
 }
 rect(int x,int y)
 {
   l=x;
   b=y;
 }
 rect(rect r)
 {
   this.l=r.l;
   this.b=r.b;
 }
 void area()
 {
   System.out.println(" area "+l*b);
 }
}
class objectpass
{
  public static void main(String arg[])
  {
     rect a=new rect();
     rect b=new rect(6);
     rect c=new rect(5,6);
     rect d=new rect(b);
     a.area();
     b.area();
     c.area();
     d.area();
  }
}