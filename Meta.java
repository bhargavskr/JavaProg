import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Myanno
{
   String str();
   int val();
}
class Meta
{
   @Myanno(str=" annotation example ",val=100)
   public static void myMeth()
   {
    Meta ob=new Meta();
    try
    {
      Class c=ob.getClass();   
      Method m=c.getMethod("myMeth");
      Myanno anno=m.getAnnotation(Myanno.class);
      System.out.println(anno.str()+" "+anno.val());
    }
    catch(NoSuchMethodException exe)
    {
         System.out.println(" method not found ");
     }
   }
   public static void main(String arg[])
   {
       myMeth();
   }
}
