enum Apple
{
  jonathan,goldendel,reddelwinesap,cortland
}
class enumdemo
{
   public static void main(String args[])
   {
      Apple ap;
      ap=Apple.reddel;
      System.oout.println("value of ap:"+ap);
      System.out.println();
      ap=Apple.goldendel;
      if(ap==Apple.goledendel)
      System.out.println(" ap containsgoldendel \n");
      switch(ap)
      {
        case jonathan:
                       System.out.println(" jonathan is red ");
                       break;
        case goldendel:
                       System.out.println(" golden delicious is red ");
                       break;
       case reddel:
                      System.out.println(" red delicious is red");
                      break;
       case winesap:
                     System.out.println(" winesap is red");
                     break;
       case cortland:
                       System.out.println(" cortland is red");
                       break;
      }
   }
}