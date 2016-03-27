enum Apple
{
  jonathan,goldendel,reddel,winesap,cortland
}
class Enumdemo4
{
  public static void main(String arg[])
  {
     Apple ap,ap2,ap3;
     System.out.println(" here are all apple constants"+"and their ordinal values");
     for(Apple a:Apple.values())
          System.out.println(a+" "+a.ordinal());
     ap=Apple.reddel;
     ap2=Apple.goldendel;
     ap3=Apple.reddel;
    System.out.println();
    if(ap.compareTo(ap2)<0)
           System.out.println(ap+" comes before "+ap2);
    if(ap.compareTo(ap2)>0)
           System.out.println(ap2+" comes before "+ap);
    if(ap.compareTo(ap3)==0)
      System.out.println(ap+"is equal to"+ap3);
    if(ap.equals(ap2))
      System.out.println("error");
    if(ap.equals(ap3))
       System.out.println(ap+"equals"+ap3);
     if(ap==ap3)
       System.out.println(ap+"=="+ap3);
  }
}
  