import java.util.Random;
enum Answers
{
  no,yes,maybe,later,soon,never
}
class Question
{
   Random rand=new Random();
   Answers ask()
   {
      int prob=(int)(100*rand.nextDouble());
      if(prob<15)
        return Answers.maybe;
       else if(prob<30)
          return Answers.no;
      else if(prob<60)
          return Answers.yes;
      else if(prob<75)
          return Answers.later;
      else if(prob<98)
          return Answers.soon;
      else
          return Answers.never;
    }
} 
class Askme
{
   static void answer(Answers result)
   {
        switch(result)
        {
              case no:
                    System.out.println("no");
                      break;
              case yes:
                      System.out.println("yes");
                      break;
             case later:
                       System.out.println(" later");
                      break;
             case soon: 
                       System.out.println("soon");
                       break;
             case never:
                        System.out.println(" never");
                       break;
             case maybe:
                        System.out.println(" maybe");
                        break;
        }
    }
    public static void main(String arg[])
    {
         Question q=new Question();
         answer(q.ask());
         answer(q.ask());
         answer(q.ask()); 
         answer(q.ask());
    }
}
    