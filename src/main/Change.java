import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Change {
    static int desiredAmount;
    static int[] coinValues;

    public static void main(String[] args) {
        try {
            int[] validated_args = validateCommandLineArgs(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        findAllPosibility();
    }

    private static int[] validateCommandLineArgs(String[] args)
            throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("There is no arguments!");
        } else {
            if (args.length <= 1) {
                throw new IllegalArgumentException("There must be at least 1 coin value!");
            } else {
                int size = args.length;
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    Integer current = null;
                    try {
                        current = Integer.parseInt(args[i]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(
                                "There is an argument other than integer type: \n" + e.getMessage());
                    }

                    if (current < 0) {
                        throw new IllegalArgumentException("Amount or coin values can't be smaller than 0!");
                    }
                    arr[i] = current;
                }
                desiredAmount = arr[0];
                System.out.println("Desired amount: " + desiredAmount);
                coinValues = Arrays.copyOfRange(arr, 1, arr.length);
                System.out.println("Given coin values: " + Arrays.toString(coinValues));
                return arr;
            }
        }
    }

    public static ArrayList<Integer> findAllPosibility() {
        System.out.println("hello world");
        return null;
    }

}