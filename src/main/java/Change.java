package java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Change {
    static int desiredAmount;
    static int[] coinValues;
    static int maxLevel;

    public static void main(String[] args) {
        try {
            int[] validated_args = validateCommandLineArgs(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        ArrayList<int[]> posibilities = findAllPosibility();
        if (posibilities.size() == 0) {
            System.out.println("IMPOSSIBLE!");
        } else {
            System.out.println("The number of posibilitties: " + posibilities.size());
            System.out.println("The minimum number of coins: " + Arrays.toString(posibilities.get(-1)));
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
                setDesiredAmount(arr[0]);
                System.out.println("Desired amount: " + desiredAmount);
                setCoinValues(Arrays.copyOfRange(arr, 1, arr.length));
                System.out.println("Given coin values: " + Arrays.toString(coinValues));
                return arr;
            }
        }
    }

    public static ArrayList<int[]> findAllPosibility() {
        // Sort coin values
        Arrays.sort(coinValues);

        ArrayList<int[]> possibilities = new ArrayList<>();

        int[] currentSearch = new int[coinValues.length];
        Arrays.fill(currentSearch, 0);
        search(currentSearch, 0, 0, possibilities);

        return possibilities;
    }

    public static void search(int[] currentSearch, int currentLevel, int currentAmount,
            ArrayList<int[]> possibilities) {
        // Base cases
        if (currentAmount == desiredAmount) {
            possibilities.add(currentSearch);
        } else if (currentAmount > desiredAmount) {
            // do nothing;
        }
        // Recursion
        // Max repetition of the current coin value
        else {
            int amtToFill = desiredAmount - currentAmount;
            int currentCoinValue = coinValues[currentAmount];
            if (currentCoinValue > desiredAmount) {
                // do nothing
                return;
            }
            int numNodeToSearch = Math.floorDiv(amtToFill, currentCoinValue);
            // i is the number of repetition of the current coin value
            for (int i = numNodeToSearch; i >= 0; i--) {
                int[] newSearch = currentSearch.clone();
                System.out.println("Size of new search: " + newSearch.length);
                newSearch[currentLevel] = i;
                search(newSearch, currentLevel + 1, currentAmount + i * currentCoinValue, possibilities);
            }
        }
    }

    public static void setDesiredAmount(int desiredAmount) {
        Change.desiredAmount = desiredAmount;
    }

    public static void setCoinValues(int[] coinValues) {
        Change.coinValues = coinValues;
        Change.maxLevel = coinValues.length - 1;
    }
}