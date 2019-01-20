package ru.job4j.pseudo;

public class StartDraw {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
