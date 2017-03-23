package com.yezi.algorithms.sort;

import java.util.Comparator;


public class MergeSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {

    private Creator<T> mCreator;

    public MergeSortAlgorithm(Creator<T> creator) {
        mCreator = creator;
    }

    @Override
    public T[] exec(T[] ts, Comparator<T> comparator) {
        if (ts == null || ts.length <= 0 || comparator == null || mCreator == null) {
            return null;
        }

        return merge(ts, 0, ts.length, comparator);
    }

    private T[] merge(T[] ts, int start, int length, Comparator<T> comparator) {
        if (length == 1) {
            T[] resultArray = mCreator.createArray(1);
            resultArray[0] = ts[start];
            return resultArray;
        }

        T[] leftArray = merge(ts, start, length/2, comparator);
        T[] rightArray = merge(ts, start+length/2, length-length/2, comparator);

        return combine(leftArray, rightArray, comparator);
    }

    private T[] combine(T[] sortedArray1, T[] sortedArray2, Comparator<T> comparator) {
        T[] resultArray = mCreator.createArray(sortedArray1.length + sortedArray2.length);

        int curPos1 = 0;
        int curPos2 = 0;

        int curResultPos = 0;

        while(curPos1 < sortedArray1.length && curPos2 < sortedArray2.length) {
            if (comparator.compare(sortedArray1[curPos1], sortedArray2[curPos2]) < 0) { //sortedArray1[curPos1] < sortedArray2[curPos2]
                resultArray[curResultPos] = sortedArray1[curPos1];
                curPos1++;
            } else {
                resultArray[curResultPos] = sortedArray2[curPos2];
                curPos2++;
            }
            curResultPos++;
        }

        if (curPos1 == sortedArray1.length) { // already has element exist in sortedArray2
            copyArray(sortedArray2, curPos2, -1, resultArray, curResultPos);
        } else {
            copyArray(sortedArray1, curPos1, -1, resultArray, curResultPos);
        }
        return resultArray;
    }

    private void copyArray(T [] from, int startPos, int length, T[] to, int toStartPos) {
        int endPos = length < 0 ? from.length : Math.min(startPos+length, from.length);

        int j = toStartPos;
        for (int i=startPos; i<endPos; i++) {
            if (j < to.length) {
                to[j] = from[i];
                j++;
            } else {
                break;
            }
        }
    }
}
