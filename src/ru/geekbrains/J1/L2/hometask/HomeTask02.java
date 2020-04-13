package ru.geekbrains.J1.L2.hometask;

import java.util.Arrays;

public class HomeTask02 {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr1));
        methodOne(arr1);
        System.out.println(Arrays.toString(arr1));


        int[] arr2 = new int[8];
        System.out.println(Arrays.toString(arr2));
        methodTwo(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        methodThree(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 0, 3, 2, 0, -1, 22, 0, 105, -99, 2, 0, 203, 26, -126, 0, 57};
        System.out.println(Arrays.toString(arr4));
        methodFour(arr4);

        int[][] arr5 = new int[10][10];
        methodFive(arr5);

        for (int i = 0; i < arr5.length; i++) {
            for (int j = 0; j < arr5[i].length; j++) {
                System.out.print(arr5[i][j] + "\t");
            }
            System.out.println();
        }

        int[] arr6_1 = {2, 1, 1}, arr6_2 = {1, 2, 3, 4, 5}, arr6_3 = {10, 1, 2, 3, 4}, arr6_4 = {2, 1, 1, 3, 1};
        System.out.println(methodSix(arr6_1));
        System.out.println(methodSix(arr6_2));
        System.out.println(methodSix(arr6_3));
        System.out.println(methodSix(arr6_4));

        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        methodSeven(arr7, -4);
        System.out.println(Arrays.toString(arr7));
        methodSeven(arr7, 4);
        System.out.println(Arrays.toString(arr7));


        int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(methodEight(arr8, -4)));
        System.out.println(Arrays.toString(methodEight(arr8, 4)));
    }

    public static void methodOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void methodTwo(int[] arr) {
        int x = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = x;
            x += 3;
        }
    }

    public static void methodThree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    public static void methodFour(int[] arr) {
        int max = 0, min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("min = " + min + ", max = " + max);
    }

    public static void methodFive(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (i == arr.length - j - 1) {
                    arr[i][j] = 1;
                }
            }
            System.out.println();
        }
    }

    public static boolean methodSix(int[] arr) {
        int sumI = 0, sumJ;
        for (int i = 0; i < arr.length; i++) {
            sumJ = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumJ += arr[j];
            }
            sumI += arr[i];
//            System.out.println("sum I = " + sumI + ", sum J = " + sumJ);
            if (sumI == sumJ) {
                return true;
            }
        }
        return false;
    }

    public static void methodSeven(int[] arr, int n) {
//        System.out.println(Arrays.toString(arr));
//        int[] arrTemp= new int[arr.length];
//        int m = 0;
//        for (int i = n; i < arr.length; i++){
//            arrTemp[m] = arr[i];
//            m++;
//        }
//        for (int i = 0; i < n; i++){
//            arrTemp[m] = arr[i];
//            m++;
//        }
//        System.arraycopy( arrTemp, 0, arr, 0, arrTemp.length);
//        System.out.println(Arrays.toString(arrTemp));

        int[] arrTemp = new int[arr.length];
        if (n >= 0) {
            System.arraycopy(arr, 0, arrTemp, 0, arr.length);
            System.arraycopy(arrTemp, n, arr, 0, arrTemp.length - n);
            System.arraycopy(arrTemp, 0, arr, arr.length - n, n);
        }
        else {
            int  nTemp;
            nTemp = arr.length + n;
            System.out.println(nTemp);
            System.arraycopy(arr, 0, arrTemp, 0, arr.length);
            System.arraycopy(arrTemp, nTemp, arr, 0, arrTemp.length - nTemp);
            System.arraycopy(arrTemp, 0, arr, arr.length - nTemp, nTemp);
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static int[] methodEight(int[] arr, int shift) {
        if (shift != 0) {
            if (shift > arr.length) {
                shift = Math.abs(shift % arr.length);
            }

            if (shift > 0) {
                for (int n = 0; n < shift; n++) {
//                    System.out.println("tik");
                    int buffer = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[0];

                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[j - 1] = arr[j];
                    }

                    arr[arr.length - 2] = buffer;
                }

            } else if (shift < 0) {
                for (int i = 0; i > shift; i--) {
//                    System.out.println("tik");
                    int buffer = arr[0];
                    arr[0] = arr[arr.length - 1];

                    for (int j = 1; j < arr.length - 1; j++) {
                        arr[arr.length - j] = arr[arr.length - j - 1];
                    }

                    arr[1] = buffer;
                }
            }
        }

        return arr;
    }
}