package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int i, j;
         for (i = 1, j = 1; i < data.length && j < data.length; i++, j++) {
            if (data[0][0] != data [i][j]) {
                result = false;
                break;
            }
        }

        for (i = 0, j = data.length - 1; i < data.length - 1 && j > 0; i++, j--) {
            if (data[i][j] != data[i + 1][j - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
