package OOPS;

public class AbstractClasses {
    public static abstract class Shape {
        private String color;
        public Shape(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public abstract double area();
        public abstract double perimeter();

        public void describe() {
            System.out.println("Shape: " + getClass().getSimpleName() +" | Color: " +color+ " | Area: " + String.format("%.2f", area()) + " | Perimeter: " + String.format("%.2f", perimeter()));
        }
    }
    static class Circle extends Shape {
        private double radius;
        public Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }
    static class Rectangle extends Shape {
        private double height;
        private double width;
        public Rectangle(String color, double height, double width) {
            super(color);
            this.height = height;
            this.width = width;
        }
        @Override
        public double area() {
            return height * width;
        }
        @Override
        public double perimeter() {
            return 2 * (height + width);
        }
    }
    static class Triangle extends Shape {
        private double a;
        private double b;
        private double c;
        public Triangle(String color, double a, double b, double c) {
            super(color);
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double area() {
            double s = 0.5 * (a + b + c);
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
        @Override
        public double perimeter() {
            return (a + b + c);
        }
    }
    public static void main(String[] args) {
        // Problem 5 — Abstract Classes
        Shape[] shapes = {
                new Circle("Red", 5),
                new Rectangle("Blue", 4, 6),
                new Triangle("Green", 3, 4, 5)
        };

        for(Shape s : shapes) {
            s.describe();
        }
    }
}
