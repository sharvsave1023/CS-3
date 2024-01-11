import org.xml.sax.SAXNotSupportedException;
import java.lang.Exception;
public class RingBuffer
{
    private static final double NullPointerException = 0;
    private double[] data;
    private int      first;
    public int      last;  
    private int      size; 

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity) {

    data = new double[capacity];
    last = -1;
    first = 0;
    size = 0;

        
    }

    /** return number of items currently in the buffer */
    public int size() {
        



        return (last-first)+1; 
    }

    /** is the buffer empty (size equals zero)? */
    public boolean isEmpty() {
        

        return size() == 0; 
    }

    /** is the buffer full (size equals array capacity)? */
    public boolean isFull() throws Exception {
        
        return data.length == (size()); 
    }

    /** add item x to the end */
    public void enqueue(double x)  {
        
        
        int ind = (last+1)%data.length;
        
        size++;
        try {
            if (isFull()){
               throw new RuntimeException();
            }
            else {
                data[ind] = x;
                last++;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
            
        
        
        

    }

    /** delete and return item from the front */
    public double dequeue() throws Exception {
        
       if (isEmpty()){
         System.out.println("RIP");
         throw new RuntimeException();
       }
       
       double e = data[first%data.length];
       first++;
       size--;
       return e;
       

    }

    /** return (but do not delete) item from the front */
    public double peek() {
        
        if (isEmpty()){
            throw new RuntimeException();
        }
        return data[first%data.length];
        
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        double t = 0;
        try {
            t = buffer.dequeue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = 0;
            try {
                x = buffer.dequeue();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            double y = 0;
            try {
                y = buffer.dequeue();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());

        /*
         * Your program should produce the following output:
         *
         *  Size after wrap-around is 100
			*  5050.0
         */
    }
}
