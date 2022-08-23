package Recursion;

public class BubbleSort {
    public static void main(String[] args) {
        int a [] = {10,6,5,8,3,7,4};
        bubbleSortRecursion(0,a);
        for(int i:a){
            System.out.print(i+" ");
        }

    }
    public static void bubbleSort(int [] a){
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = 0; j <a.length-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int temp= a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }

            }

        }

    }

    public static void bubbleSortRecursion(int i,int [] a){
        if(i<a.length-1){ // base case
            int j = 0;
            int stop = a.length -i-1; // the second loops stopping point
            bubbleSortHelper(j,a,stop);
            bubbleSortRecursion(i+1,a);
        }
    }

    public static void bubbleSortHelper(int j, int []a, int stop){
        if(j<stop){ // base case of the helper function
            if (a[j]>a[j+1]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
            bubbleSortHelper(j+1,a,stop);
        }
    }
}
