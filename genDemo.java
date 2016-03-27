class gen<T>
{
  T ob;
  gen(T o)
  {
   ob=o;

  }
  T getob()
  {
   return ob;
  }
   void showtype()
  {
  System.out.println(" type of T is "+ob.getClass().getName());
  }
} 
class genDemo
{
   public static void main(String arg[])
   {
       gen<Integer>iob=new gen<Integer>(88);
       iob.showtype();
       int v=iob.getob();
       System.out.println(" value "+v);
       System.out.println();
       gen<String>strob=new gen<String>("generics test");
       strob.showtype();
       String str=strob.getob();
       System.out.println(" value "+str);
   }
}