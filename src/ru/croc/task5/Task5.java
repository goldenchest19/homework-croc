package ru.croc.task5;

public class Task5 {

    public static void main(String[] args) throws Exception {
//        Annotation annotation = new Annotation("Car",
//                new Rectangle(170, 100, 150, 200)
//        ); // throw exception
//        Rectangle rectangle = new Rectangle( 10, 10, 20, 20);
//        rectangle.setxCoord2(5); // throw exception

        Annotation annotation1 = new Annotation("Box",
                new Rectangle(100, 100, 150, 200)
        );
        Annotation annotation2 = new Annotation("Tree", new Circle(100, 100, 10));
        AnnotatedImage annotatedImage = new AnnotatedImage("d", annotation1, annotation2);
        Annotation[] annotations = annotatedImage.getAnnotations();

        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}
