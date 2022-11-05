package ru.croc.task6;

import ru.croc.task5.*;

public class Task6 {

    public static void main(String[] args) throws Exception {

        Annotation annotation1 = new Annotation("Box",
                new Rectangle(100, 100, 200, 200)
        );

        Annotation annotation2 = new Annotation("Tree",
                new Circle(1, 1, 3)
        );
        AnnotatedImage annotatedImage = new AnnotatedImage("d", annotation1, annotation2);

        System.out.println(annotatedImage.findByPoint(2, 2));
        System.out.println(annotatedImage.findByLabel("Tr"));

        Figure figure1 = annotation1.getFigure();
        figure1.move(10, 10);
        System.out.println(annotation1);

        Figure figure2 = annotation2.getFigure();
        figure2.move(20, 15);
        System.out.println(annotation2);
    }
}
