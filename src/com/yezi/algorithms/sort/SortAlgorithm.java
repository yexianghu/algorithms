package com.yezi.algorithms.sort;


import java.util.Comparator;

public interface SortAlgorithm<T extends Comparable<T>> {

    interface Creator<T> {

        T[] createArray(int size);
    }

    T[] exec(T[] ts, Comparator<T> comparator);
}
