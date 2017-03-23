package test.com.yezi.algorithms.sort;

import com.yezi.algorithms.sort.MergeSortAlgorithm;
import com.yezi.algorithms.sort.SortAlgorithm;
import org.junit.Test;

import static org.junit.Assert.*;


public class MergeSortAlgorithmTest {

    @Test
    public void testNull() {
        new MergeSortAlgorithm<Integer>(null).exec(null, null);
    }

    @Test
    public void testEmpty() throws Exception {
        new MergeSortAlgorithm<>(new SortAlgorithm.Creator<Integer>() {

            @Override
            public Integer[] createArray(int size) {
                return new Integer[size];
            }
        }).exec(new Integer[0], Integer::compareTo);
    }

    @Test
    public void testArray() throws Exception {
        Integer[] sortArray = new Integer[] {
                4,3,2,1,5,8,7,6,10,14,11,29,43
        };

        Integer[] resultArray = new Integer[] {
                1,2,3,4,5,6,7,8,10,11,14,29,43
        };

        sortArray = new MergeSortAlgorithm<>(new SortAlgorithm.Creator<Integer>() {

            @Override
            public Integer[] createArray(int size) {
                return new Integer[size];
            }
        }).exec(sortArray, Integer::compareTo);

        assertArrayEquals(sortArray, resultArray);
    }
}