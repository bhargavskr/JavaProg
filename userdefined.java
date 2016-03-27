class userdefined
{
  static void throwfun(int a)throws UserException
  {
    if(a<0)
    
        throw new UserException(a);
        System.out.println("normal exit");
    
  }
  public static void main(String arg[])
  {
         try
         {
              throwfun(10);
              throwfun(-5);
         }
         catch(UserException ue)
         {
            System.out.println(" exception caught:"+ue);
         }
    }
}
class UserException extends Exception
{
    private int x;
    UserException(int a)
    {
        x=a;
     }
    public String toString()
    {
          return "it students raised this exception "+x;
    }
}