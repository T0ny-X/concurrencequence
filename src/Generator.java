import java.util.Random;

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
        String[] sequences = new String[x];
        for (int i = 0; i < x; i++) {
            String builder = "";
            for (int j = 0; j < y; j++) {
                String[] alphabet = new String[]{"A","T","G","C"};
                int index = random.nextInt(alphabet.length);
                builder += alphabet[index];
            }
            System.out.print(builder+'\n');
            sequences[i] = builder;
        }
        return sequences;
    }

}