class callref
{
  int x,y;
  callref(int a,int b)
  {
   x=a;
   y=b;
  }
  void show(callref m)
  {
   this.x=m.x+10;
   this.y=m.y+20;
  }
}
class callbyref
{
  public static void main(String arg[])
  {
    callref cr=new callref(10,20);
    System.out.println(" before passing "+cr.x+cr.y);
    cr.show(cr);
    System.out.println(" after passing "+cr.x+cr.y);
  } 
}
