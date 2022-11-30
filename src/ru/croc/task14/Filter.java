package ru.croc.task14;

import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {
    public List<String> getCommentsFilter(List<String> comments, Set<String> blackList) {
        return filterComments(comments, element -> blackList.stream().anyMatch(element.toLowerCase()::contains));
    }
}
