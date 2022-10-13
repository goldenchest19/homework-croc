package ru.croc.task1;

import java.util.Scanner;

public class Main {

    static class Point {
        double x;
        double y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point a = new Point();
        System.out.print("Введите координату х вершины №1: ");
        a.x = scanner.nextDouble();
        System.out.print("Введите координату y вершины №1: ");
        a.y = scanner.nextDouble();

        Point b = new Point();
        System.out.print("Введите координату х вершины №2: ");
        b.x = scanner.nextDouble();
        System.out.print("Введите координату y вершины №2: ");
        b.y = scanner.nextDouble();

        Point c = new Point();
        System.out.print("Введите координату х вершины №3: ");
        c.x = scanner.nextDouble();
        System.out.print("Введите координату y вершины №3: ");
        c.y = scanner.nextDouble();

        calculateArea(a, b, c);
    }

    public static void calculateArea(Point firstPoint, Point secondPoint, Point thirdPoint) {
        double a = calculateDistance(firstPoint, secondPoint);
        double b = calculateDistance(firstPoint, thirdPoint);
        double c = calculateDistance(secondPoint, thirdPoint);

        if (!isExistTriangle(a, b, c)) {
            System.out.println("Треугольник не существует");
        } else {
            double P = (a + b + c) / 2;
            double S = Math.sqrt(
              P * (P - a) * (P - b) * (P - c)
            );

            String finalArea = String.format("%.2f", S);
            System.out.println("Площадь треугольника: " +  Double.parseDouble(finalArea));
        }
    }

    public static boolean isExistTriangle(double a, double b, double c) {
        return a + b > c & a + c > b & b + c > a;
    }

    public static double calculateDistance(Point firstPoint, Point secondPoint) {
        if (!isComparePoint(firstPoint, secondPoint)) {
            return Math.sqrt(
                    (firstPoint.x - secondPoint.x) * (firstPoint.x - secondPoint.x) +
                            (firstPoint.y - secondPoint.y) * (firstPoint.y - secondPoint.y)
            );
        } else {
            System.out.println("Введены некоректные точки!");
            return 0;
        }
    }

    public static boolean isComparePoint(Point firstPoint, Point secondPoint) {
        return firstPoint.x == secondPoint.x & firstPoint.y == secondPoint.y;
    }
}
