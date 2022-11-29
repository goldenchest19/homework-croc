package ru.croc.task14;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {
    public List<String> getCommentsFilter(List<String> comments, Set<String> blackList) {
        String[] badWords = blackList.toArray(new String[blackList.size()]);
        return filterComments(comments, element -> Arrays.stream(badWords).anyMatch(element.toLowerCase()::contains));
    }
}
