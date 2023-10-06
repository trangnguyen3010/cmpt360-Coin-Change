import java.lang.reflect.Array;
import java.util.ArrayList;

public class Change {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("There is no arguments!");
            System.exit(1);
        } else {
            int size = args.length;
            int[] arr = new int[size];
            try {
                for (int i = 0; i < size; i++) {
                    arr[i] = Integer.parseInt(args[i]);
                }
            } catch (Exception e) {
                System.err.println("There is an argument other than integer type: \n" + e.getMessage());
                System.exit(1);
            }
        }
        findAllPosibility();
    }

    public static ArrayList<Integer> findAllPosibility() {
        System.out.println("hello world");
        return null;
    }

}