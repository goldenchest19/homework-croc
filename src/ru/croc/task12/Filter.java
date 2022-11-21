package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class Filter implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {

        for (int i = 0; i < comments.size() && i != -1; i++) {
            for (String word : blackList) {
                if (i == -1) {
                    break;
                }
                if (comments.size() > 0 & comments.get(i).toLowerCase().contains(word)) {
                    comments.remove(i);
                    i--; // так как размер списка при удалением уменьшается, мы уменьшаем счетчик
                }
            }
        }
    }

}
