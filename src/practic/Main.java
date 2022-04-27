package practic;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {


    public static void main(String[] args) throws IOException {
/*
Задание 1
Напишите общий метод, который возвращает максимальное значение из
трех переданных параметров.
 */
        String s = "asdfg";
        String a = "a";
        String h = "ljh;ojhasdfg";
        String[] mass = {"asdfg", "alj", "ljh;ojhasdfg"};
        double q = 5.5;
        double w = 12.8;
        double r = 78.4;

        //     String max = (String) maxVal(s, a, h);
        //      System.out.println(maxValueMass(mass));


        /*
        Задача 2
Напишите общий метод, который возвращает минимальное значение из
трех переданных параметров.
         */
        //     System.out.println((int) minVal(s, a, h));

        /*
        Задача 3
Напишите общий метод для нахождения среднего арифметического в
массиве.
         */


        //  System.out.println(avgMass(creatMass(5)));

  /*
Задача 4
Реализуйте общий метод для поиска максимального значение в массиве.
 */


//        Double[] mass = {56.0, 78.0, 1.87, 99.8, 63.9, -10.12};
//        System.out.println(maxValueMass(mass));


 /*
        Задача 8

        Создайте общий класс Matrix. Реализуйте следующее:
■ заполнение матрицы с клавиатуры;
■ заполнение матрицы случайными числами;
■ арифметические операции +, -, *, / по правилам
        работа с матрицами;
■ поиск максимального и минимального элемента;
■ расчет среднего значения
  */


        Matrix matrix = new Matrix(3,3);
        Matrix matrix2 = new Matrix(3,3);
        matrix.pst();
        matrix.print();
//        matrix.div(10);
        System.out.println();
        matrix2.pst();
        matrix2.print();
        System.out.println();

        Matrix matrix4 = new Matrix(2,3);
        matrix4.print();
        System.out.println();
        matrix4.difMatrix(matrix.getMass(), matrix2.getMass());
        matrix4.print();

////        System.out.println(Arrays.deepToString(matrix.getMass()));
        //    System.out.println(matrix.maximum());
        //    matrix.print();
        //  System.out.println("Среднее значение чисел матрицы: "+ matrix.avg());
        //     matrix.multp(10);


    }


    public static <E> E maxValueMass(E[] mass) {
        E max = null;
        if (mass instanceof Integer[] || mass instanceof Double[] || mass instanceof Character[]) {
            Arrays.sort(mass);
            max = mass[mass.length - 1];
            System.out.print("Максимальное значение массива: ");
        }
        if (mass instanceof String[]) {
            Arrays.sort(mass);
//            Arrays.sort(mass, new Comparator<E>() {
//                @Override
//                public int compare(E o1, E o2) {
//                    if (((String) o1).length() > ((String) o2).length()) {
//                        return 1;
//                    }
//                    if (((String) o1).length() < ((String) o2).length()) {
//                        return -1;
//                    }
//                    return 0;
//                }
//            });
            int length = ((String) mass[mass.length - 1]).length();
            System.out.print("Самая длинная строка длиной " + length + " символов ");
            max = mass[mass.length - 1];
        }
        return max;
    }



        /*
        Задача 5
Реализуйте общий метод для поиска минимума
значение в массиве.
         */


    public static OptionalDouble avgMass(double[] mass) {
        return Arrays.stream(mass).average();
    }


    /*
    создание массива
     */
    public static double[] creatMass(int size) {
        double[] mass = new double[size];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = Math.random() * 30;
        }
        return mass;
    }

    /*
    нахождение максимального значения
     */
    public static <E> Object maxVal(E t1, E t2, E t3) {
        Object o = null;
        if (t1 instanceof Integer) {
            o = new Integer(Math.max(Math.max((Integer) t1, (Integer) t2), (Integer) t3));
        }
        if (t1 instanceof Double) {
            o = new Double(Math.max(Math.max((Double) t1, (Double) t2), (Double) t3));
        }
        if ((t1 instanceof Character)) {
            int a = ((Character) t1);
            int b = ((Character) t2);
            int c = ((Character) t3);
            o = new Character((char) Math.max(Math.max(a, b), c));

//            if (((Character) t1).compareTo(((Character) t2)) > 0 && ((Character) t1).compareTo(((Character) t3)) > 0) {
//                o = new Character(((Character) t1));
//            }
//            if (((Character) t2).compareTo(((Character) t1)) > 0 && ((Character) t2).compareTo(((Character) t3)) > 0) {
//                o = new Character(((Character) t2));
//            }
//            if (((Character) t3).compareTo(((Character) t2)) > 0 && ((Character) t3).compareTo(((Character) t1)) > 0) {
//                o = new Character(((Character) t3));
//            }

            if (t1 instanceof String) {
                if (((String) t1).length() > ((String) t2).length() && ((String) t1).length() > ((String) t3).length()) {
                    System.out.print("Самая длинная строка \"" + t1 + "\" длинной ");
                    o = ((String) t1).length();
                } else if (((String) t2).length() > ((String) t1).length() && ((String) t2).length() > ((String) t3).length()) {
                    System.out.print("Самая длинная строка \"" + t2 + "\" длинной ");
                    o = ((String) t2).length();
                } else if (((String) t3).length() > ((String) t1).length() && ((String) t3).length() > ((String) t2).length()) {
                    System.out.print("Самая длинная строка \"" + t3 + "\" длинной ");
                    o = ((String) t3).length();
                } else if (((String) t2).length() == ((String) t1).length() && ((String) t2).length() == ((String) t3).length()) {
                    System.out.println("Строки равны");
                    o = ((String) t1).length();
                }
            }
        }
        return o;
    }

    /*
    нахождение минимального значения
     */
    public static <E> Object minVal(E t1, E t2, E t3) {
        Object min = null;
        try {
            if (t1 instanceof Integer) {
                //       System.out.println(Math.max(Math.max((Integer) t1, (Integer) t2), (Integer) t3));
                min = Math.min(Math.min((Integer) t1, (Integer) t2), (Integer) t3);

            }
            if (t1 instanceof Double) {
                //       System.out.println(Math.max(Math.max((Double) t1, (Double) t2), (Double) t3));
                min = Math.min(Math.min((Double) t1, (Double) t2), (Double) t3);

            }
            if (t1 instanceof String) {
                if (((String) t1).length() < ((String) t2).length() && ((String) t1).length() < ((String) t3).length()) {
                    System.out.print("Самая короткая строка \"" + t1 + "\" длинной ");
                    min = ((String) t1).length();
                } else if (((String) t2).length() < ((String) t1).length() && ((String) t2).length() < ((String) t3).length()) {
                    System.out.print("Самая короткая строка \"" + t2 + "\" длинной ");
                    min = ((String) t2).length();
                } else if (((String) t3).length() < ((String) t1).length() && ((String) t3).length() < ((String) t2).length()) {
                    System.out.print("Самая короткая строка \"" + t3 + "\" длинной ");
                    min = ((String) t3).length();
                } else if (((String) t2).length() == ((String) t1).length() && ((String) t2).length() == ((String) t3).length()) {
                    System.out.print("Строки равны");
                    min = ((String) t1).length();
                }
            }

        } catch (ClassCastException ex) {
            System.out.println("Не соответсвтие формата ввода ");
        }
        return min;
    }

//    public static <E> E minVal12(E v11, E v22, E v33) {
//        E min;
//        if (v11 instanceof Integer && v22 instanceof Integer && v33 instanceof Integer) {
//            min = (E) new Integer(Math.min(Math.min((Integer) v11, (Integer) v22), (Integer) v33));
//            return min;
//        } else if (v11 instanceof String && v22 instanceof String && v33 instanceof String) {
//            int lenStr1 = String.valueOf(v11).length();
//            int lenStr2 = String.valueOf(v22).length();
//            int lenStr3 = String.valueOf(v33).length();
//            System.out.println("Длина самой короткой строки " + Math.min(Math.min(lenStr1, lenStr2), lenStr3));
//            System.out.println("Самая короткая строка при сравнении по символам: ");
//            if (((String) v11).compareTo((String) v22) < 0 && ((String) v11).compareTo((String) v33) < 0) {
//                return v11;
//            } else if (((String) v22).compareTo((String) v11) < 0 && ((String) v22).compareTo((String) v33) < 0) {
//                return v22;
//            } else {
//                return v33;
//            }
//        } else if (v11 instanceof Double && v22 instanceof Double && v33 instanceof Double) {
//            min = (E) new Double(Math.min(Math.min((double) v11, (double) v22), (double) v33));
//            return min;
//        }
//        throw new IllegalArgumentException("Error");
//    }
}

