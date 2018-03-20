package cn.cecurio.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * 插入排序
 */
public class SortTest {

    int data[] = {9, 4, 66, 1, 32, 80, 23, 9};;

    @Before
    public void before() {

    }

    @Test
    public void insertSortTest() {
        MySort.insertSort(data);
        outputArray(data);
    }

    @Test
    public void bubbleSortTest() {
        MySort.bubbleSort(data);
        outputArray(data);
    }

    @Test
    public void bubbleSort2Test() {
        MySort.bubbleSort2(data);
        outputArray(data);
    }


    public void outputArray(int data[]) {
        for (int i = 0; i < data.length; i++) {
            if (i != 0) System.out.print(" , ");
            System.out.print(data[i]);
        }
        System.out.println();
    }
}
