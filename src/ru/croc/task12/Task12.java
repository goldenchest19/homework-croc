package ru.croc.task12;

import java.util.*;

public class Task12 {

    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> list = new ArrayList<>();
        list.add("я купил банан");
        list.add("я купил банан и киви");
        list.add("роза машина кот собака");
        list.add("мы построили большой дом");

        Set<String> set = new HashSet<>();
        set.add("киви");
        set.add("cобака");
        set.add("абрикос");
        set.add("дом");

        filter.filterComments(list, set);
    }
}
