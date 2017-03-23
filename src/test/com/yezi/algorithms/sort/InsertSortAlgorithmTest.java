package test.com.yezi.algorithms.sort;

import com.yezi.algorithms.sort.InsertSortAlgorithm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InsertSortAlgorithmTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void execNormal() throws Exception {
        Integer[] sortArray = new Integer[] {
                4,3,2,1,5,8,7,6,10,14,11,29,43
        };

        Integer[] resultArray = new Integer[] {
                1,2,3,4,5,6,7,8,10,11,14,29,43
        };

        new InsertSortAlgorithm<Integer>().exec(sortArray, Integer::compareTo);

        assertArrayEquals(sortArray, resultArray);
    }

    @Test
    public void execNone() throws Exception {
        new InsertSortAlgorithm<Integer>().exec(null, null);
    }

    @Test
    public void execEmtpy() throws Exception {

        Integer[] sortArray = new Integer[] {
        };

        Integer[] resultArray = new Integer[] {
        };

        new InsertSortAlgorithm<Integer>().exec(sortArray, Integer::compareTo);

        assertArrayEquals(sortArray, resultArray);
    }

}