package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pipe<T, U> {
    private ArrayList<U> arrayList=new ArrayList<>();
    private List<Filter<T, U>> filters = new ArrayList<Filter<T, U>>();

    public void addFilter(Filter<T, U> filter){
        filters.add(filter);
    }

    public T runFilters(T input, ArrayList<U> extra){
        int count=0;
        for (Filter<T, U> filter: filters) {
            input = filter.execute(input, extra.get(count));
            count++;
        }
        return input;
    }
}