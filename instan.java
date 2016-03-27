class A
{
   int i,j;
}
class B 
{
 int i,j;
}
class C extends A
{
   int k;
}
class D extends A
{
  int k;
}
class  instan
{
   public static void main(String arg[])
   {
       A a=new A();
       B b=new B();
       C c=new C();
       D d=new D();
       if(a instanceof A)
           System.out.println(" a is instance of A");
       if(b instanceof B)
            System.out.println(" b is instance of B");
       if(c instanceof C)
            System.out.println(" c is instance of C");
       if(c instanceof A)
            System.out.println(" c can be cast to a");
       if(a instanceof C)
            System.out.println(" a can be cast to c");
       System.out.println();
       A ob;
       ob=d;
       System.out.println("ob now refers to D");
       if(ob instanceof D)
             System.out.println(" ob is instance of D");
       System.out.println();
       ob=c;
        System.out.println("ob now refers to c");
         if(ob instanceof D)              
        System.out.println(" ob is cast to D");
       else
         System.out.println(" ob cannot be cast to D");
      if(ob instanceof A)
            System.out.println(" ob can be cast to A");
      System.out.println();
      if(a instanceof Object)
            System.out.println(" a may be cast to object ");
      if(b instanceof Object)
            System.out.println(" b may be cast to object ");
      if(c instanceof Object)
            System.out.println(" c may be cast to object ");
       if(d instanceof Object)
            System.out.println(" d may be cast to object ");
  }
}