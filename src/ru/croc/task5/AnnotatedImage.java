package ru.croc.task5;

public class AnnotatedImage {

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

    public Annotation findByPoint(int x, int y) {
        for (int i = 0; i < annotations.length; i++) {
            Annotation annotation = annotations[i];
            Figure figure = annotation.getFigure();
            if (figure instanceof Rectangle) {
                if (figure.getxCoord() == x && figure.getyCoord() == y ||
                        ((Rectangle) figure).getxCoord2() == x && ((Rectangle) figure).getyCoord2() == y) {
                    return annotation;
                }
            } if (figure.getxCoord() == x && figure.getyCoord() == y) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        Annotation annotation = null;
        for (int i = 0; i < annotations.length; i++) {
            annotation = annotations[i];
            if (annotation.getTitle().contains(label)) {
                return annotation;
            }
        }
        return annotation;
    }


}

