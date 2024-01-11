import java.util.*;

public class Melody{
    Queue<Note> notes;
    
    Melody(Queue<Note> song){ 
        this.notes = song;
    }
    
    public double getTotalDuration()
    {
        double ans = 0;
        Queue<Note> lala = new LinkedList<>();
        boolean repeat = false;
        while(this.notes.isEmpty() == false) 
        {
            if(notes.peek().isRepeat()) 
                repeat = !repeat;
            if(repeat || notes.peek().isRepeat()) 
                ans += this.notes.peek().getDuration();
            ans += this.notes.peek().getDuration();
            lala.offer(notes.poll());
        }
        
        while(lala.isEmpty() == false) 
            notes.offer(lala.poll());
            
        return ans;
    }
    
    public String toString() 
    {
        String ans = "";
        Queue<Note> temp = new LinkedList<>();
        while(this.notes.isEmpty() == false) 
        {
            ans += this.notes.peek() + "\n";
            temp.offer(notes.poll());
        }
        
        while(temp.isEmpty() == false) 
            this.notes.offer(temp.poll());
            
        return ans;
    }
    
    public void changeTempo(double tempo) 
    {
        Queue<Note> temp = new LinkedList<>();
        while(this.notes.isEmpty() == false) 
        {
            this.notes.peek().setDuration(this.notes.peek().getDuration() / tempo);
            temp.offer(notes.poll());
        }
        while(temp.isEmpty() == false) 
            this.notes.offer(temp.poll());
    }
    
    public void reverse() 
    {
        Stack<Note> lala = new Stack<>();
        while(this.notes.isEmpty() == false) 
            lala.push(notes.poll());
        
        while(lala.isEmpty() == false) 
            notes.offer(lala.pop());
    }
    
    public void append(Melody other) 
    {
        Queue<Note> temp = new LinkedList<>();
        while(other.notes.isEmpty() == false) 
            temp.offer(other.notes.poll());
        
        while(temp.isEmpty() == false) 
        {
            other.notes.offer(temp.peek());
            this.notes.offer(temp.poll());
        }
    }
    
    public void play() 
    {
        Queue<Note> repeat = new LinkedList<>(), temp = new LinkedList<>();
        while(this.notes.isEmpty() == false) 
        {
            this.notes.peek().play();
            if(this.notes.peek().isRepeat()) 
            {
                repeat.offer(notes.peek());
                if(repeat.size() > 1) 
                {
                    while(repeat.isEmpty() == false)
                        repeat.poll().play();
                }
            }
            temp.offer(notes.poll());
        }
        
        while(temp.isEmpty() == false) 
            this.notes.offer(temp.poll());
    }

    public Queue<Note> getNotes() 
    {
        return notes;
    }
}
