public class GuitarHero {

    public static final int SAMPLING_RATE = 44100;
    public static final double CONCERT_A = 440;
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] notes = new GuitarString[37];
        for (int i = 0; i < 37; i++){
            notes[i]= new GuitarString(440 * Math.pow(1.05956, (i+1)-24));
        }
        int individualKey = 0;
        while (true)
        {
            if (StdDraw.hasNextKeyTyped())
            {
                char key = StdDraw.nextKeyTyped();
                individualKey = keyboard.indexOf(key);
                if (individualKey != -1){
                    notes[individualKey].pluck();
                }
            }
            if (individualKey != -1)
            {
                StdAudio.play(notes[individualKey].sample());
                notes[individualKey].tic();
            }
        }
    }
}
