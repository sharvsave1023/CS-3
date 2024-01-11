import java.util.*;
import java.io.*;
public class main
{
    public static void main(String args[]) throws Exception
    {
        Scanner read;
        Scanner scan = new Scanner(new File("/Users/sharvfiles/VS_Code/Code/CS3/WordLadderLab/input.txt"));
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();
        while (scan.hasNext() == true)
        {
            input.add(scan.next());
            output.add(scan.next());
        }
        
        for (int i = 0; i<input.size(); i++)
        {
            String start = input.get(i).toUpperCase();
            String end = output.get(i).toUpperCase();
            read = new Scanner (new File("/Users/sharvfiles/VS_Code/Code/CS3/WordLadderLab/dictionary.txt"));
            Set<String> dict = new HashSet<String>();
            Queue<Stack<String>> ladder = new LinkedList();
            Stack<String> words = new Stack<String>();
            while(read.hasNext() == true)
            {
                String word = read.next();
                if (word.length() == start.length())
                    dict.add(word);
            }
            if(!dict.contains(start)||!dict.contains(end)||start.length()!=end.length())
            {
                System.out.println("No ladder between " + input.get(i) +" and " + output.get(i));
                continue;
            }
            words.push(start);
            dict.remove(start);
            ladder.offer(words);
            
            while (ladder.isEmpty() == false)
            {
                Stack <String> ladderOne = ladder.poll();
                
                if (ladderOne.peek().equals(end))
                {
                    System.out.println("Ladder Found! ---> " + ladderOne);
                    continue;
                }
                Stack<String> sw = new Stack<String>();

                for (int l=0; l<start.length(); l++)
                {
                    String letTest = ladderOne.peek();
                    for (char a = 'A'; a<='Z';a++)
                    {
                        String x = letTest.substring(0,l) + a + letTest.substring(l+1,start.length());
                        if (dict.contains(x))
                        {
                            dict.remove(x);
                            sw.push(x);
                            if (x.equals(end))
                                break;
                        }
                    }
                    if(sw.isEmpty() == false)
                        if (sw.peek().equals(end))
                            break;
                }
                while(sw.isEmpty() == false)
                {
                    String sim = sw.pop();
                    Stack<String> s = (Stack<String>)ladderOne.clone();
                    s.push(sim);
                    if (sim.equals(end))
                    {
                        while(ladder.isEmpty() == false)
                        {
                            ladder.poll();
                        }
                        ladder.offer(s);
                        break;
                    }
                    ladder.offer(s);
                }
            }
        }
    }
}