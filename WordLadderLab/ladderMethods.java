import java.util.*;

public class ladderMethods
{
    public ladderMethods()
    {}
    
    public static void main(String args[])
    {
        String x ="Hello";
        String y = x.substring(0,0);
        
        for (int l=0; l<x.length(); l++)
        {
            for (char a = 'A'; a<'Z';a++)
            {
                String z = x.substring(0,l) + a + x.substring(l+1,x.length());
                System.out.println(z);
            }
        }


    }
}