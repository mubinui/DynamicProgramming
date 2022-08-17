import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("The nubmer "+n);
        int [] a = new int[n+1];
        Arrays.fill(a,-1);
        System.out.println("Fib_mem "+fibo_mem(n,a));
        System.out.println("Fib "+fib(n));

    }
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
    public static int fibo_mem(int n , int a []){
        int first, second ;
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if(a[n-1]==-1){
            a[n-1] = fibo_mem(n-1,a);
            first = a[n-1];


        }
        else {
            first = a[n-1];
        }
        if(a[n-2]==-1){
            a[n-2] = fibo_mem(n-2,a);
            second = a[n-2];

        }
        else{
            second = a[n-2];
        }
        return first+second;

    }
}
