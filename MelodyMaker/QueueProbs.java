import java.util.*;
public class QueueProbs
{
    //3
    Queue<Integer>evenFirst(Queue<Integer> nums)
    {
        Queue<Integer> ans = new LinkedList<>();
        int size = nums.size();
        for(int i = 0; i < size; i++) 
        {
            if(nums.peek() % 2 == 0) 
                ans.offer(nums.poll());
            else 
                nums.offer(nums.poll());
        }
        
        while(!nums.isEmpty()) 
            ans.offer(nums.poll());
        return ans;
    }
    
    //4
    public boolean numPalindrome(Queue<Integer> nums)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!nums.isEmpty())
            ans.add(nums.poll());
        
        while (ans.size() >= 2)
        {
            if(ans.get(0) != ans.get(ans.size()-1))
                return false;
            else
            {
                ans.remove(0);
                ans.remove(ans.size()-1);
            } 
        }
    
        return true;
    }
    
    //riddle - yesterday, today, tommorrow
    
    //6
    public Stack<Integer>SieveOfEratosthenes(int num)
    {
        Queue<Integer> ans = new LinkedList<>();
        Stack<Integer> prime = new Stack<Integer>();
        ArrayList<Integer> lala = new ArrayList<Integer>();
        
        for(int i = 2; i <= num; i++)
            ans.offer(i);
        
        for(int i = 0; i < ans.size(); i++) 
            lala.add(ans.peek());
            
        while(!ans.isEmpty())
        {
            prime.push(ans.poll());
            for(int i = 0; i < lala.size(); i++)
            {
                if((prime.peek() % lala.get(i)) == 0)
                {
                    prime.pop();
                    break;
                }
            }
        }
        
        return prime;
    }
}
