enum Apple
{
  jonathan(10),goldendel(9),reddel(12),winesap(15),cortland(8);
  private int price;
  Apple(int p)
  {
     price=p;
  }
  int getPrice()
  {
     return price;
  }
}
class Enumdemo3
{
  public static void main(String arg[])
  {
  Apple ap;
  System.out.println("winesap costs "+Apple.winesap.getPrice()+"cents \n");
  System.out.println(" all apples prices ");
  for(Apple a:Apple.values())
        System.out.println(a+"costs"+a.getPrice()+" cents");
  }
}