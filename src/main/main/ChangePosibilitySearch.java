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
        // Sort coin values
        Arrays.sort(coinValues);
        this.coinValues = coinValues;
        this.maxLevel = coinValues.length - 1;
    }

    public ArrayList<int[]> findAllPosibility() {
        ArrayList<int[]> possibilities = new ArrayList<>();

        int[] currentSearch = new int[coinValues.length];
        Arrays.fill(currentSearch, 0);
        search(currentSearch, 0, 0, possibilities);

        return possibilities;
    }

    public void search(int[] currentSearch, int currentLevel, int currentAmount,
            ArrayList<int[]> possibilities) {
        int amtToFill = desiredAmount - currentAmount;

        if (amtToFill == 0) {
            possibilities.add(currentSearch);
            return;
        } else if (currentLevel > maxLevel) {
            return;
        }

        int currentCoinValue = coinValues[currentLevel];
        if (currentCoinValue <= amtToFill) {
            int numNodeToSearch = Math.floorDiv(amtToFill, currentCoinValue);
            // i is the number of repetition of the current coin value
            for (int i = numNodeToSearch; i >= 0; i--) {
                int currentNodeAmt = i * currentCoinValue;

                // if the amount of current node is already larger than the amount to fill, no need to search further
                if (currentNodeAmt <= amtToFill) {
                    int[] newSearch = currentSearch.clone();
                    newSearch[currentLevel] = i;
                    if (currentLevel <= maxLevel) {
                        search(newSearch, currentLevel + 1, currentAmount + currentNodeAmt, possibilities);
                    }
                }
            }
        }
    }
}
