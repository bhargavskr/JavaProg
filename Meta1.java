import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Myanno
{
  String str();
  int val();
}
class Meta1
{
   @Myanno(str="two parameters ",val=19)
   public static void myMeth(String str,int i)
   {
     Meta1 ob=new Meta1();
     try
     {
         Class c=ob.getClass();
         Method m=c.getMethod("myMeth",String.class,int.class);
         Myanno anno=m.getAnnotation(Myanno.class); 
         System.out.println(anno.str()+"   "+anno.val());
      }
     catch(NoSuchMethodException exc)
     {
         System.out.println(" method not found ");
     }
   }
   public static void main(String arg[])
   {
      myMeth("test",10);
  }
}  