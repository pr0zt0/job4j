package ru.job4j.pseudo;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder figure = new StringBuilder();
        figure.append("++++");
        figure.append("+     +");
        figure.append("+     +");
        figure.append("++++");
        return figure.toString();
    }
}
