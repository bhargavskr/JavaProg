class stringmethod
{
  public static void main(String arg[])
  {
    String s1=new String("pulse");
    String s2=new String("annual day");
    String s3=s1;
    System.out.println(" length of strob1:"+s1.length());
    System.out.println(" character at the index 3 is :"+s2.charAt(3));
    if(s1.equals(s3))
    {
        System.out.println(" s1==s3");
    }
    else
    {
       System.out.println("s1!=s3");
    }
  }
}
