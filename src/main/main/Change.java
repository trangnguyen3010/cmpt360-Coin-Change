package main;

import java.util.Arrays;

public class Change {

    public static void main(String[] args) {
        int[] validated_args;
        try {
            validated_args = validateCommandLineArgs(args);

            int desiredAmount = validated_args[0];
            int[] coinValues = Arrays.copyOfRange(validated_args, 1, validated_args.length);

            ChangePosibilitySearch changePosibilitySearch = new ChangePosibilitySearch(desiredAmount, coinValues);

            System.out.println(changePosibilitySearch.getResultString());
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
                    int current;
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