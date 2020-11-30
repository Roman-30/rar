package rar;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int a = 3;
        int b = 4;
        int[][] arr = new int[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = rnd.nextInt(10);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
           for (int j = 0; j < arr[i].length;j++) {
               System.out.print(arr[i][j] + " ");

           }
            System.out.print("]\n");
           // System.out.println(Arrays.toString(arr[i]));
             }
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            int sum1 = 0;
            for (int k = 0; k < b; k++) {
                sum += arr[i][k];
                sum1 += arr[i + 1][k];
            }
            System.out.println(sum + " " + sum1);
            if (sum < sum1) {
                for (int k = 0; k < b; k++) {
                    int tm = arr[i + 1][k];
                    arr[i + 1][k] = arr[i][k];
                    arr[i][k] = tm;
                }
                    System.out.println(Arrays.toString(arr[0]));
                System.out.println(Arrays.toString(arr[1]));
                System.out.println(Arrays.toString(arr[2]));
            }
        }
    }
}

