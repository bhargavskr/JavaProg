class call
{
     void show(int x,int y)
     {
        x=x+10;
        y=y+22;
        System.out.println(" formal parameters are "+x +y);
     }
}
class callbyvalue
{
  public static void main(String arg[])
  {
     int a=10,b=20;
     System.out.println(" before passing "+a +b);
     call c=new call();
     c.show(a,b);
     System.out.println(" after passing "+a +b);
  }
}