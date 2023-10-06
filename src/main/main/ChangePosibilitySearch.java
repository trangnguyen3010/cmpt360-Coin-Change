package main;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangePosibilitySearch {
    private int desiredAmount;
    private int[] coinValues;
    private int maxLevel;

    public ChangePosibilitySearch(int desiredAmount, int[] coinValues) {
        setDesiredAmount(desiredAmount);
        setCoinValues(coinValues);
    }

    public void setDesiredAmount(int desiredAmount) {
        this.desiredAmount = desiredAmount;
    }

    public void setCoinValues(int[] coinValues) {
        this.coinValues = coinValues;
        this.maxLevel = coinValues.length - 1;
    }

    public ArrayList<int[]> findAllPosibility() {
        // Sort coin values
        Arrays.sort(coinValues);

        ArrayList<int[]> possibilities = new ArrayList<>();

        int[] currentSearch = new int[coinValues.length];
        Arrays.fill(currentSearch, 0);
        search(currentSearch, 0, 0, possibilities);

        return possibilities;
    }

    public void search(int[] currentSearch, int currentLevel, int currentAmount,
            ArrayList<int[]> possibilities) {
        // Base cases
        if (desiredAmount == 0) {
            return;
        } else if (currentAmount == desiredAmount) {
            possibilities.add(currentSearch);
            return;
        } else if (currentAmount > desiredAmount) {
            // do nothing;
            return;
        } else if (currentLevel == maxLevel + 1) {
            return;
        }
        // Recursion
        // Max repetition of the current coin value
        else {
            int amtToFill = desiredAmount - currentAmount;
            int currentCoinValue = coinValues[currentLevel];
            System.out.println("current level: " + currentLevel);
            if (currentCoinValue > desiredAmount) {
                // do nothing
                return;
            }
            int numNodeToSearch = Math.floorDiv(amtToFill, currentCoinValue);
            // i is the number of repetition of the current coin value
            for (int i = numNodeToSearch; i >= 0; i--) {
                int[] newSearch = currentSearch.clone();
                System.err.println("Size of new search: " + newSearch.length);
                newSearch[currentLevel] = i;
                search(newSearch, currentLevel + 1, currentAmount + i * currentCoinValue, possibilities);
            }
        }
    }
}
