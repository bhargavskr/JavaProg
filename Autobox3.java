class Autobox3
{
  public static void main(String arg[])
  {
     Integer iob,iob2;
     int i;
     iob=100;
     ++iob;
     System.out.println(" After ++iob:"+iob);
     iob2=iob+(iob/3);
     System.out.println("iob2 after expression :"+iob2);
     i=iob+(iob/3);
      System.out.println(" after expression :"+i);
  }
}