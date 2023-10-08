package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.ChangePosibilitySearch;

public class ChangeTest {
    private ChangePosibilitySearch search;

    public static void main(String[] args) {
        ChangePosibilitySearch search = new ChangePosibilitySearch(28, new int[] { 200, 100, 50, 25, 10, 5, 1 });
        search.findAllPosibility();
    }

    @Before
    public void initialize() {
        search = new ChangePosibilitySearch(28, new int[] { 200, 100, 50, 25, 10, 5, 1 });
    }

    @Ignore
    public void findAllPosibility_givenZeroValue_expectEmpty() {
        search.setDesiredAmount(0);
        assertEquals(0, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_1_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200 });
        search.findAllPosibility();
        assertEquals(0, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_2_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100 });
        search.findAllPosibility();
        assertEquals(0, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_3_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100, 50 });
        search.findAllPosibility();
        assertEquals(0, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountAndASmallerDivisableCoinValue_expectOne() {
        search.setDesiredAmount(10);
        search.setCoinValues(new int[] { 2 });
        search.findAllPosibility();
        assertEquals(1, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPossibility_givenLargeDesiredAmount() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {100, 5, 46, 23, 87});
        search.findAllPosibility();
        assertEquals(1479, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfSmallDenominations() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {10, 11, 12, 13, 14, 15});
        search.findAllPosibility();
        assertEquals(2777849, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfBigDenominations() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {80, 90, 10, 111, 122, 133, 144, 155});
        search.findAllPosibility();
        assertEquals(796, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPossibility_givenLargeNumberOfDenominations() {
        search.setDesiredAmount(100);
        search.setCoinValues(new int[] {1, 2, 3, 4, 5, 10, 13, 14, 15, 16, 25, 50, 75, 100});
        search.findAllPosibility();
        assertEquals(1223569, search.getNumberOfPossibilities());
    }

    @Test
    public void findAllPossibility_LargeDesiredAmountWithLargeCoins() {
        search.setDesiredAmount(1000);
        search.setCoinValues(new int[] {100, 200, 500});
        search.findAllPosibility();
        assertEquals(10, search.getNumberOfPossibilities());
    }


    @Test
    public void findAllPosibility_givenAssignmentExampleInput() {
        search.findAllPosibility();
        assertEquals(13, search.getNumberOfPossibilities());
    }
}
