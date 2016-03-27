class rect
{
 int length;
 int breadth;
 void accept(int l,int b)
 {
    length=l;
    breadth=b;
 }
  void area()
 {
   System.out.println(" area is :"+length*breadth);
 }
}
class recarea
{
   public static void main(String arg[])
   {
     rect r=new rect();
     r.accept(10,20);
     r.area();
   }
}
