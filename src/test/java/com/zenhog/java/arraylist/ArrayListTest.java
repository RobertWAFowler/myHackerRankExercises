package com.zenhog.java.arraylist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArrayListTest {

    List<List<Integer>> integerMatrix = new ArrayList<>();

    private void assertNumberAtPosition(int x, int y, int expectedInt) {
        assertThat(findNumAtPosition(x, y), is(Integer.valueOf(expectedInt)));
    }

    @Before
    public void setup(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(41);
        list1.add(77);
        list1.add(74);
        list1.add(22);
        list1.add(44);

        List<Integer> list2 = new ArrayList<>();
        list2.add(12);

        List<Integer> list3 = new ArrayList<>();
        list3.add(37);
        list3.add(34);
        list3.add(36);
        list3.add(52);

        List<Integer> list4 = new ArrayList<>();

        List<Integer> list5 = new ArrayList<>();
        list3.add(20);
        list3.add(22);
        list3.add(33);

        integerMatrix.add(list1);
        integerMatrix.add(list2);
        integerMatrix.add(list3);
        integerMatrix.add(list4);
        integerMatrix.add(list5);
    }

    @Test
    public void getNumberAtExistingPositionTest(){
        assertNumberAtPosition(1, 1, 41);
        assertNumberAtPosition(1, 3, 74);
        assertNumberAtPosition(3, 4, 52);
        assertNumberAtPosition(3, 1, 37);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNumberAtNonExistingPositionTest(){
        findNumAtPosition(4,3);
    }

    private Integer findNumAtPosition(int x, int y) {
        int xIndex = x - 1;
        int yIndex = y - 1;

        List<Integer> rowList = integerMatrix.get(xIndex);
        Integer result = rowList.get(yIndex);

        return result;
    }
}

