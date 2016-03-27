package mypack;
public class import1
{
  String name;
  double bal;
  public import1(String n,double b)
  {
    name=n;
    bal=b;
  }
  public void show()
  {
     if(bal<0)
     System.out.println("-->");
     System.out.println(name+" "+bal);
  }
}
