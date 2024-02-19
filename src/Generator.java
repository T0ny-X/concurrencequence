import java.util.Random;

// Sequence generating related functions
// No constructor, but can have one to define symbols to generate.

public class Generator {

    private static final Random random = new Random();

    public static String[] generate(int x, int y) {
        return RNG(x,y);
    }
    // Overload to achieve default length of 10
    public static String[] generate(int x) {
        return RNG(x,10);
    }
    // Overload to achieve default of 1
    public static String[] generate() {
        return RNG(1,10);
    }

    // Actual function
    public static String[] RNG(int x, int y) {
        //Iterate to be i strings, each string j random characters.
        String[] sequences = new String[x];
        for (int i = 0; i < x; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < y; j++) {
                String[] alphabet = new String[]{"A","T","G","C"};
                int index = random.nextInt(alphabet.length);
                builder.append(alphabet[index]);
            }
            // Comment out print to minimize interference on time.
            System.out.print(builder.toString() +'\n');
            sequences[i] = builder.toString();
        }
        // return no utilized to minimize runtime
        return sequences;
    }

}