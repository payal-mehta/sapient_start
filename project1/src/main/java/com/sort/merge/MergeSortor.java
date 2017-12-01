package com.sort.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MergeSortor<T> {
	private final List<T> items;
    private final Comparator<T> c;

    public MergeSortor(final List<T> original, final Comparator<T> c) {
        if (original == null) {
            this.items = Collections.emptyList();
        } else {
            this.items = original;
        }
        this.c = c;
    }

    protected List<T> compute() {
        List<T> result = null;
        int currentSize = this.items.size();
        if (currentSize <= 1) {
            result = items;
        } else{
            int midPoint = currentSize / 2;
            List<T> left =new MergeSortor<T>(items.subList(0, midPoint), c).getSortedResult();
            List<T> right =new MergeSortor<T>(items.subList(midPoint,
                    currentSize), c).getSortedResult();
            result = merge(left,right);
        }
        return result;
    }
    private List<T> merge(List<T>left,List<T>right) {

        List<T> result = new ArrayList<T>(left.size()+right.size());
        T firstLeft = null;
        T firstRight = null;
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                firstLeft = left.get(0);
                firstRight = right.get(0);
                if (c.compare(firstLeft, firstRight) <= 0) {
                    result.add(firstLeft);
                    left = left.subList(1, left.size());
                } else {
                    result.add(firstRight);
                    right = right.subList(1, right.size());
                }
            } else if (left.size() > 0){
                result.add(left.get(0));
                left = left.subList(1, left.size());
            } else if (right.size() > 0){
                result.add(right.get(0));
                right = right.subList(1, right.size());
            }
        }

        return result;
    }

    public List<T> getSortedResult() {
        return this.compute();
    }
}
