package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Change {

    public static void main(String[] args) {
        int[] validated_args;
        try {
            validated_args = validateCommandLineArgs(args);

            int desiredAmount = validated_args[0];
            int[] coinValues = Arrays.copyOfRange(validated_args, 1, validated_args.length);

            ChangePosibilitySearch changePosibilitySearch = new ChangePosibilitySearch(desiredAmount, coinValues);

            System.out.println("Desired amount: " + desiredAmount);
            System.out.println("Given coin values: " + Arrays.toString(coinValues));
            ArrayList<int[]> posibilities = changePosibilitySearch.findAllPosibility();
            if (posibilities.size() == 0) {
                System.out.println("IMPOSSIBLE!");
            } else {
                System.out.println("The number of posibilitties: " + posibilities.size());
                System.out.println("The minimum number of coins: " + Arrays.toString(posibilities.get(-1)));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
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
                return arr;
            }
        }
    }
}