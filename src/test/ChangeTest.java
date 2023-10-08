package test;

import main.ChangePosibilitySearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ChangeTest {
    private ChangePosibilitySearch search;

    @Before
    public void initialize() {
        search = new ChangePosibilitySearch(28, new int[] { 200, 100, 50, 25, 10, 5, 1 });
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_1_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200 });

        search.findAllPosibility();

        Assert.assertEquals(0, search.getNumberOfPossibilities());
        assertNull(search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_2_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100 });

        search.findAllPosibility();

        Assert.assertEquals(5, search.getNumberOfPossibilities());
        assertNull(search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_3_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100, 50 });

        search.findAllPosibility();

        Assert.assertEquals(0, search.getNumberOfPossibilities());
        assertNull(search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountAndASmallerDivisableCoinValue_expectOne() {
        search.setDesiredAmount(10);
        search.setCoinValues(new int[] { 2 });

        search.findAllPosibility();

        Assert.assertEquals(1, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] { 5 }, search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPossibility_givenLargeDesiredAmount() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {100, 5, 46, 23, 87});

        search.findAllPosibility();

        Assert.assertEquals(1479, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0, 10}, search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfSmallDenominations() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {10, 11, 12, 13, 14, 15});

        search.findAllPosibility();

        Assert.assertEquals(2777849, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0, 5, 62}, search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfBigDenominations() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {80, 90, 10, 111, 122, 133, 144, 155});

        search.findAllPosibility();

        Assert.assertEquals(796, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {0, 0, 1, 6, 2, 0, 0, 0}, search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfDenominations() {
        search.setDesiredAmount(100);
        search.setCoinValues(new int[] {1, 2, 3, 4, 5, 10, 13, 14, 15, 16, 25, 50, 75, 100});

        search.findAllPosibility();

        Assert.assertEquals(1223569, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, search.getMinimumNumberOfCoins());
    }

    @Test
    public void findAllPossibility_LargeDesiredAmountWithLargeCoins() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {100, 200, 500});

        search.findAllPosibility();

        Assert.assertEquals(10, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {0, 0, 2}, search.getMinimumNumberOfCoins());
    }


    @Test
    public void findAllPosibility_givenAssignmentExampleInput() {
        search.findAllPosibility();

        Assert.assertEquals(13, search.getNumberOfPossibilities());
        Assert.assertArrayEquals(new int[] {3, 0, 0, 1, 0, 0, 0}, search.getMinimumNumberOfCoins());
    }
}
