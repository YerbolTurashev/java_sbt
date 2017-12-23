package ru.sbt;

import java.util.*;

public class CountMapImpl<E> implements CountMap<E>{

    private final Map<E, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();

    }

    @Override
    public void add(E o) {
        if(map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(E o) {
        return map.get(o);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int remove(E o) {
        int count = getCount(o);
        if(count == 1) {
            map.remove(o);
        } else {
            map.put(o, count - 1);
        }
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<E> source) {
        Iterator<E> it = source.iterator();
        while (it.hasNext()) {

            E key = it.next();
            Integer sourceCount = source.getCount(key);

            if(!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + sourceCount);
            }
        }

    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        destination.putAll(map);
    }
}
