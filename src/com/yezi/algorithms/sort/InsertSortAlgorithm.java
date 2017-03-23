package com.yezi.algorithms.sort;

import java.util.Comparator;


public class InsertSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {

    @Override
    public T[] exec(T[] ts, Comparator<T> comparator) {

        if (ts == null || comparator == null) {
            return null;
        }

        for (int sortedDiv=1; sortedDiv<ts.length; sortedDiv++) {
            doInsertSortStep(ts, sortedDiv, comparator);
        }
        return ts;

    }

    private void doInsertSortStep(T[] ts, int endPos, Comparator<T> comparator) {
        for (int i=endPos; i>0; i--) {
            if (comparator.compare(ts[i], ts[i-1]) <= 0) { //ts[i] <= ts[i-1]
                T tmp = ts[i];
                ts[i] = ts[i-1];
                ts[i-1] = tmp;
            } else {
                break;
            }
        }
    }

}
