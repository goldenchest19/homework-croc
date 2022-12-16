### Задание

Вы разрабатываете небольшое приложение по аннотированию (разметке) изображений с целью последующего использования этой разметки для обучения моделей computer vision. В этом приложении пользователь может выделять области на изображении с помощью прямоугольников и окружностей и подписывать их произвольным текстом.

Прямоугольники определяются координатами левого нижнего и правого верхнего углов, а окружности - координатами центра и радиусом. Вся разметка для изображения представляется массивом Annotation[].

```java
class AnnotatedImage {

  private final String imagePath;

  private final Annotation[] annotations;

  public AnnotatedImage(String imagePath, Annotation... annotations) {
    this.imagePath = imagePath;
    this.annotations = annotations;
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public Annotation[] getAnnotations() {
    return this.annotations;
  }
}
```

Определите класс Annotation для представления данных разметки (подпись + фигура) и классы Figure, Rectangle, Circle для задания размеченных областей.

Переопределите метод toString класса Annotation так, чтобы в результат выводилась информация о полях и вложенных объектах.

#### Входные данные

Заданы в коде, расположены в ArrayList\<Figure\> figures

#### Выходные данные
  
Окружность:
```
“C (<X0>, <Y0>), <R>: <Подпись>”
```
Прямоугольник:
```
“R (<X1>, <Y1>), (<X2>, <Y2>): <Подпись>”
```
  
#### Результаты работы:
```
C (10.0, 10.0), 5.0: Moon
R (10.0, 70.0), (50.0, 10.0): Cloud
C (1.0, 1.0), 1.0: Birbie
```
