enum Apple 
{
  jonathan,goldendel,reddel,winesap,cortland
}
class Enumdemo2
{
  public static void main(String arg[])
  {
      Apple ap;
      System.out.println(" here are all Apple constants ");
      Apple allapples[]=Apple.values();
      for(Apple a:allapples)
              System.out.println(a);
      System.out.println();
      ap=Apple.valueOf("winesap");
      System.out.println(" ap contains "+ap);
   }
}  