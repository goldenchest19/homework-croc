package ru.croc.task14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task14 {

    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> list = new ArrayList<>();
        list.add("мы построили большой дом");
        list.add("мы построили большойe дом");
        list.add("я купил банан");
        list.add("я купил банан и киви");
        list.add("роза машина кот собака");
        list.add("самый ужасный комментарий");

        Set<String> set = new HashSet<>();
        set.add("банан");
        set.add("киви");
        set.add("собака");
        set.add("абрикос");
        set.add("дом");

        list = filter.getCommentsFilter(list, set);
        System.out.println(list);
    }
}
