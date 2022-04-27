package practic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Matrix {

    private double[][] mass;
    private Matrix m1;
    private Matrix m2;

    public Matrix(int iSize, int jSize) {
        this.mass = new double[iSize][jSize];
    }

    public Matrix(double[][] mass, double[][] mass2) {
        this.mass = sumMatrix(mass, mass2);

    }

    public double[][] getMass() {
        return mass;
    }

    public void setMass(double[][] mass) {
        this.mass = mass;
    }

    public double[][] pst() throws IOException {
        System.out.println("Матрица размером " + getMass().length * getMass()[0].length + " чисел");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Матрицу заполнить рандомно-нажми 1\nпрописать руками-нажми 2");
        switch (Integer.parseInt(bf.readLine())) {
            case 1: {
                for (int i = 0; i < getMass().length; i++) {
                    for (int j = 0; j < getMass()[i].length; j++) {
                        getMass()[i][j] = (int) (Math.random() * 50);
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Матрица размером " + getMass()[0].length + " * " + getMass().length);
                boolean stop = false;
                while (!stop) {
                    System.out.println("Укажи строку, столбец, помещаемое значение.");
                    try {
                        int ind = Integer.parseInt(bf.readLine());
                        int ind2 = Integer.parseInt(bf.readLine());
                        getMass()[ind][ind2] = Integer.parseInt(bf.readLine());
                        System.out.println("Нажми 0 что бы закончить.Для продолжения-любую клавишу");
                        String test = bf.readLine();
                        if (test.equals("0")) {
                            stop = true;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Не существует такой ячейки");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Введено не числовое значение");
                    }
                }
                break;
            }
        }
        return mass;
    }

    public void print() {
        for (int i = 0; i < getMass().length; i++) {
            for (int j = 0; j < getMass()[i].length; j++) {
                System.out.print(getMass()[i][j] + "| ");
            }
            System.out.println();
        }

    }

    public double maximum() {
        double max = Double.MIN_VALUE;
        double tmp;
        for (int i = 0; i < getMass().length; i++) {
            for (int j = 0; j < getMass()[i].length; j++) {
                tmp = getMass()[i][j];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        System.out.print("Максимальное значение в матрице: ");
        return max;
    }

    public double minimum() {
        double min = Double.MAX_VALUE;
        double tmp;
        for (int i = 0; i < getMass().length; i++) {
            for (int j = 0; j < getMass()[i].length; j++) {
                tmp = getMass()[i][j];
                if (tmp < min) {
                    min = tmp;
                }
            }
        }
        return min;
    }

    public double avg() {
        double avg = Double.MIN_VALUE;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < getMass().length; i++) {
            for (int j = 0; j < getMass()[i].length; j++) {
                sum += getMass()[i][j];
                count++;
            }
        }
        avg = sum / count;
        if (avg % 1 == 0) {
            avg = (int) avg;

        }
        return avg;
    }

    public double[][] multp(int num) {
        try {
            for (int i = 0; i < getMass().length; i++) {
                for (int j = 0; j < getMass()[i].length; j++) {
                    mass[i][j] = mass[i][j] * num;
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Не допустимый размер матрицы");
        }
        return getMass();
    }

    public double[][] div(int num) {
        try {
            for (int i = 0; i < getMass().length; i++) {
                for (int j = 0; j < getMass()[i].length; j++) {
                    mass[i][j] = mass[i][j] / num;
                }
            }
        } catch (ArithmeticException ex) {
            System.out.println("Деление на 0 не выполняется");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Не допустимый размер матрицы");
        }
        return getMass();
    }

    public double[][] sumMatrix(double[][] m1, double[][] m2) {
        try {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    this.mass[i][j] = m1[i][j] + m2[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Не допустимый размер матрицы");
        }
        return this.mass;
    }

    public double[][] difMatrix(double[][] m1, double[][] m2) {
        try {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[i].length; j++) {
                    this.mass[i][j] = m1[i][j] - m2[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Не допустимый размер матрицы");
        }

        return this.mass;
    }
}