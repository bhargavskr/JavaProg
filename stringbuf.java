class stringbuf
{
  public static void main(String arg[])
  {
     StringBuffer sb=new StringBuffer(" happy pongal");
     System.out.println(" length"+sb.length());
     System.out.println("capacity="+sb.capacity());
     sb.insert(7,"bogi and ");
     System.out.println("length:"+sb.length());
     System.out.println("capacity="+sb.capacity());
  }
}