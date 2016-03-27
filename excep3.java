public class excep3
{
   public static void main(String arg[])
   {
      try
      {
          Class c=Class.forName(arg[0].trim());
          String name=c.getName();
          Class sc=c.getSuperclass();
          String sname=sc.getName();
          System.out.println("name is:"+name+"and SuperClass name is :"+sname);
      }
       catch(ClassNotFoundException cnf)
       {
           System.out.println(" no such class ");
       }
   }
}