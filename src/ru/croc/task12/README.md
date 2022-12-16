Небольшой стартап разрабатывает социальный сервис, в котором пользователи могут оставлять комментарии. Со временем в комментариях появился спам и разработчики решили бороться с ним с помощью "черных списков" запрещенных слов. Они составили такие списки и поручили вам написать функцию, удаляющую из всех накопленных комментариев нежелательные.

Они предоставили вам интерфейс, который внедрили в свой продукт, и попросили написать его реализацию:

```java
import java.util.List;
import java.util.Set;

public interface BlackListFilter {

  /**
   * From the given list of comments removes ones 
   * that contain words from the black list.
   * 
   * @param comments list of comments; every comment 
   *                 is a sequence of words, separated 
   *                 by spaces, punctuation or line breaks   
   * @param blackList list of words that should not 
   *                  be present in a comment
   */
  void filterComments(List<String> comments, Set<String> blackList);
}
```

Реализуйте интерфейс BlackListFilter.
