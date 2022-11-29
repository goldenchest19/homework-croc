package ru.croc.task14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface BlackListFilter {
    
    default <T> List<T> filterComments(Iterable<T> comments, Predicate<T> blackList) {
        List<T> returnList = new ArrayList<>();
        for (T comment : comments) {
            if (!blackList.test(comment)) {
                returnList.add(comment);
            }
        }
        return returnList;
    }
}
