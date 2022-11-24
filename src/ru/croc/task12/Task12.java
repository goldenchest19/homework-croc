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
        list.add("самый ужасный комментарий");

        Set<String> set = new HashSet<>();
        set.add("киви");
        set.add("банан");
        set.add("собака");
        set.add("абрикос");
        set.add("дом");

        filter.filterComments(list, set);
        System.out.println(list);
    }
}
