public class GuitarString 
{
    private RingBuffer buffer;
    private int called = 0;
    /** create a guitar string of the given frequency */
    public GuitarString(double frequency) {
        int num = (int)(Math.round(44100/frequency));
        buffer = new RingBuffer(num);
        for (int i = 0; i < num; i++)
        {
            buffer.enqueue(0);
        }
    }

    /** create a guitar string with size & initial values given by the array */
    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++)
        {
            buffer.enqueue(init[i]);
        }
    }

    /** pluck the guitar string by replacing the buffer with white noise */
    public void pluck() {
        int num = buffer.size();
        for (int i = 0; i < num; i++){
            try {
                buffer.dequeue();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for (int i = 0; i < num; i++){
            double randomNum = ((Math.random() * (1)) - 0.5);
            buffer.enqueue(randomNum);
        }
    }

    /** advance the simulation one time step */
    public void tic() {
        // YOUR CODE HERE
        double firstKey = 0;
        try {
            firstKey = buffer.dequeue();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        double avg = 0.994*(0.5*(firstKey + buffer.peek()));
        buffer.enqueue(avg);
        called++;
    }

    /** return the current sample */
    public double sample() {
        // YOUR CODE HERE





        return buffer.peek(); //REPLACE
    }

    /** return number of times tic was called */
    public int time() {
        // YOUR CODE HERE

        return called; //REPLACE
    }

    public static void main(String[] args) {
        int N = 25;
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString test = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int time = test.time();
            double sample = test.sample();
            System.out.printf("%6d %8.4f\n", time, sample);
            test.tic();
        }
        /*
         * Your program should produce the following output when the main() 
         * method runs (DON'T WORRY ABOUT VERY MINOR DIFFERENCES, E.G. OFF BY 0.001):
                0   0.2000
                1   0.4000
                2   0.5000
                3   0.3000
                4  -0.2000
                5   0.4000
                6   0.3000
                7   0.0000
                8  -0.1000
                9  -0.3000
               10   0.2988
               11   0.4482
               12   0.3984
               13   0.0498
               14   0.0996
               15   0.3486
               16   0.1494
               17  -0.0498
               18  -0.1992
               19  -0.0006
               20   0.3720
               21   0.4216
               22   0.2232
               23   0.0744
               24   0.2232
         */
    }
}
