import java.util.Random;
import java.util.Scanner;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = fillArray();
        arr = sortIncArray(arr);
        sortDecArray(arr);
    }

    public static int sizeArray() {
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        return N;
    }

    public static int[] fillArray() {
        int N = sizeArray();
        System.out.print("Массив случайных чисел: ");
        Random random = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }

    public static int[] sortIncArray(int[] A) {
        for (int i = 0; i < (A.length - 1); i++) {
            for (int j = 0; j < (A.length - 1); j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }
            }
        }
        System.out.print("Массив, отсортированный по возрастанию: ");
        for (int i = 0; i < (A.length); i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        return A;
    }

    public static int[] sortDecArray(int[] A) {
        int[] B = new int[A.length];
        System.out.print("Массив, отсортированный по убыванию: ");
        for (int i = 0; i < (A.length); i++) {
            B[i] = A[A.length - i - 1];
            System.out.print(B[i] + " ");
        }
        return B;
    }
}
