import java.util.*;
public class Runner
{
    public static void main(String args[])
    {
        QueueProbs x = new QueueProbs();
        Queue<Integer>ans = new LinkedList();
        Queue<Integer>test = new LinkedList();
        ans.offer(3);
        ans.offer(5);
        ans.offer(4);
        ans.offer(17);
        ans.offer(6);
        ans.offer(83);
        ans.offer(1);
        ans.offer(84);
        ans.offer(16);
        ans.offer(37);
        test.offer(3);
        test.offer(8);
        test.offer(17);
        test.offer(9);
        test.offer(17);
        test.offer(8);
        test.offer(3);
        System.out.println("evenFirst : " + x.evenFirst(ans));
        System.out.println("palindrome : " + x.numPalindrome(test));
        System.out.println("sieve of eratosthenes : " + x.SieveOfEratosthenes(20));
    }
}
