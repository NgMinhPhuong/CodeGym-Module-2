package com.codegym;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(13);
        set.add(23);
        set.add(31);
        set.add(34);
        Client cl = new Client(new CollectionUtilsAdapter());
        cl.printMaxValue(set);
    }
}
