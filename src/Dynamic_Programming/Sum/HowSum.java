package Dynamic_Programming.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int [] numbers = {14,7};
        int [] memory = new int[target];
        Arrays.fill(memory,-100);
        List<Integer>answer2 = new ArrayList<>();
        List<Integer> memo_out = howSumMem(target,numbers,answer2,memory);
        System.out.println("Dynamic "+memo_out);
        List<Integer>answer = new ArrayList<>();
        List<Integer> output = howSum(target,numbers,answer);
        System.out.println("Non-Dynamic "+output);


    }
    public static List<Integer> howSum(int target, int [] numbers,List<Integer>elements){
        if(target==0) return new ArrayList<>(); ;
        if(target<0) return null;

        for(int i =0; i<numbers.length; i++){
            int rem = target - numbers[i];
            if (rem>=0 && howSum(rem,numbers,elements)!=null){
                elements.add(numbers[i]);
                return elements;

            }
        }
        return null;
    }
    public static List<Integer> howSumMem(int target, int [] numbers,List<Integer>elements,int [] memory){
        if(target==0) return elements ;
        if(target<0) return null;

        for(int i =0; i<numbers.length; i++){
            int rem = target - numbers[i];
            if (rem>=0 && memory[rem]!=-100){
                elements.add(numbers[i]);
                return elements;

            } else if (rem>=0 && memory[rem]==100 && howSumMem(rem,numbers,elements,memory)!=null) {
                memory[rem] = numbers[i];
                elements.add(numbers[i]);
                return elements;

            }

        }

        return null;
    }
}
