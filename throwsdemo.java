class throwsdemo
{
  static void proc()throws ClassNotFoundException
  {
       Class c=Class.forName("java.lang.math");
       if(c==null)
       
           throw new ClassNotFoundException();
           System.out.println(" class found "+c);
       
  }
  public static void main(String arg[])
  {
     try
     {
         proc();
      }
     catch(ClassNotFoundException cnf)
     {
        System.out.println(" class not found ");
     }
  }
}
 
 
 