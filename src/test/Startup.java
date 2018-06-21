package test;

import java.util.Random;

public class Startup {

    public static void main(String[] args) {

      /*  int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Заданный массив: ");
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();

        Random r = new Random();

        int[] array2 = new int[10];
        System.out.print("Случайный массив: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(r.nextInt(100) + " ");
        }

        for (int i = 0; i <= 100; i++) {
            int b = i % 2;
            if (b == 0) {
                System.out.println("Число " + i + "  - четное");
            } else {
                System.out.println("Число " + i + "  - нечетное");
            }
        }
        System.out.print("введите размер массива:");
        Scanner n = new Scanner(System.in);
        int N = n.nextInt();
        double[] array4 = new double[N];
        for (int i=0;i<array4.length;i++) {
            double a = n.nextDouble();
        }


        double[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double sum = 0;
        for (int i=0;i<array3.length;i++){
            sum = sum + array3[i];
        }
        System.out.print(sum/array3.length);


        int[][] array5 = new int[10][10];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                array5[i][j] = i * j;
                System.out.print(array5[i][j] + "\t");
            }
            System.out.println();
        } */


        int[] array6 = new int[20];
        Random r = new Random();
        for (int i = 0; i < array6.length; i++) {
            array6[i] = r.nextInt(100);
            System.out.print(array6[i] + " ");
        }
        int max = array6[0];
        int min = array6[0];
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] > max) {
                max = array6[i];
            }
            if (array6[i] < min) {
                min = array6[i];
            }
        }
        System.out.println();
        System.out.println("Максимальное число массива = " + max);
        System.out.println("Минимальное число массива = " + min);
    }

}
