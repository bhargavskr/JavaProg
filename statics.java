class stat
{
  static int x=67;
  static int y=98;
  static void show()
  {
    System.out.println(" x ="+x);
  }
}
class statics
{
  public static void main(String arg[])
  {
    stat.show();
    System.out.println(" y ="+stat.y);
  }
}