package infotech;
class balance
{
   String name;
   double bal;
   balance(String n,double b)
   {
     name=n;
     bal=b;
   }
   void show()
   {
     if(bal>0)
      {
         System.out.print(" -->");
         System.out.println(name+"  "+bal);
      }
   }
}
class pack1
{
   public static void main(String arg[])
   {
       balance cur=new balance("jeevan",222.06);
       cur.show();
   }
}  