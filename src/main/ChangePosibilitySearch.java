package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ChangePosibilitySearch {
    private int desiredAmount;
    private int[] coinValues;
    private int maxLevel;

    private ArrayList<int[]> possibilities;

    public ChangePosibilitySearch(int desiredAmount, int[] coinValues) {
        setDesiredAmount(desiredAmount);
        setCoinValues(coinValues);
        findAllPosibility();
    }

    public int getNumberOfPossibilities() {
        return possibilities.size();
    }

    public int[] getMinimumNumberOfCoins() {
        if (possibilities.isEmpty()) {
            return null;
        } else {
            return possibilities.get(possibilities.size() - 1);
        }
    }

    public String getResultString() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Desired amount: ").append(desiredAmount).append("\n");
        resultBuilder.append("Given coin values: ").append(Arrays.toString(coinValues)).append("\n");
        resultBuilder.append("The number of possibilities: ").append(getNumberOfPossibilities()).append("\n");
        if (getNumberOfPossibilities() == 0) {
            resultBuilder.append("IMPOSSIBLE!");
        } else {
            resultBuilder.append("The minimum number of coins: ")
                    .append(Arrays.stream(getMinimumNumberOfCoins()).sum())
                    .append("\n");
            resultBuilder.append("(");
            IntStream.range(0, maxLevel + 1).boxed()
                    .forEach(i -> {
                        if (getMinimumNumberOfCoins()[i] != 0) {
                            resultBuilder.append(getMinimumNumberOfCoins()[i])
                                    .append("@")
                                    .append(coinValues[i])
                                    .append(", ");
                        }
                    });
            resultBuilder.append(")");
        }
        return resultBuilder.toString();
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

    public void findAllPosibility() {
        ArrayList<int[]> possibilities = new ArrayList<>();

        int[] currentSearch = new int[coinValues.length];
        Arrays.fill(currentSearch, 0);
        search(currentSearch, 0, 0, possibilities);

        this.possibilities = possibilities;
    }

    public void search(int[] currentSearch, int currentLevel, int currentAmount,
            ArrayList<int[]> possibilities) {
        int amtToFill = desiredAmount - currentAmount;

        // If the amount to fill is 0, then we have found a solution
        if (amtToFill == 0) {
            possibilities.add(currentSearch);
            return;
        }
        // If we have gone pass the max level, then we have gone through all coin values
        else if (currentLevel > maxLevel) {
            return;
        }

        int currentCoinValue = coinValues[currentLevel];
        // If the current coin value is smaller than the amount to fill, then we can use it
        if (currentCoinValue <= amtToFill) {
            int maxNumRepeat = Math.floorDiv(amtToFill, currentCoinValue);
            // i is a possible repetition of the current coin value
            for (int i = maxNumRepeat; i >= 0; i--) {
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
