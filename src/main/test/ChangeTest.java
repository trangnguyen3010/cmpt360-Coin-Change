package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.ChangePosibilitySearch;

public class ChangeTest {
    private ChangePosibilitySearch search;

    public static void main(String[] args) {
        ChangePosibilitySearch search = new ChangePosibilitySearch(0, new int[] { 2, 4 });
        search.setDesiredAmount(10);
        search.setCoinValues(new int[] { 2 });
        search.findAllPosibility();
    }

    @Before
    public void initialize() {
        search = new ChangePosibilitySearch(28, new int[] { 200, 100, 50, 25, 10, 5, 1 });
    }

    @Test
    public void findAllPosibility_givenZeroValue_expectEmpty() {
        search.setDesiredAmount(0);
        assertEquals(0, search.findAllPosibility().size());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_1_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200 });
        assertEquals(0, search.findAllPosibility().size());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_2_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100 });
        assertEquals(0, search.findAllPosibility().size());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountSmallerThanAllCoinValues_3_expectEmpty() {
        search.setDesiredAmount(5);
        search.setCoinValues(new int[] { 200, 100, 50 });
        assertEquals(0, search.findAllPosibility().size());
    }

    @Test
    public void findAllPosibility_givenDesiredAmountAndASmallerDivisableCoinValue_expectOne() {
        search.setDesiredAmount(10);
        search.setCoinValues(new int[] { 2 });
        assertEquals(1, search.findAllPosibility().size());
    }

    @Ignore
    public void findAllPosibility_givenAssignmentExampleInput() {
        assertEquals(23, search.findAllPosibility().size());
    }
}
