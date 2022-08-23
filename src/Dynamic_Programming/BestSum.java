package Dynamic_Programming;

import java.util.*;

public class BestSum {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int target = sc.nextInt();
        int [] numbers = {3,4,5,1,8,9,7};
        //Dynamic
        int [] memory = new int[target+1 * 100];
        Arrays.fill(memory,-100);
        List<Integer> memo_out = bestSumMemo(target,numbers,memory);
        System.out.println(memo_out);
        //Not Dynamic
        List<Integer> output = bestSum(target,numbers);
        System.out.println(output);


    }


    // without Dynamic programming
    public static List<Integer> bestSum(int target, int [] numbers){
        if(target==0) return new ArrayList<>();
        if(target<0) return null;
        ArrayList<Integer>minLength = null;
        for (int i = 0; i <numbers.length ; i++) {
            int reminder= target - numbers[i];
            List<Integer> current = bestSum(reminder,numbers);
            if (current != null){
                current.add(numbers[i]);
                if (minLength==null || current.size()<minLength.size()){
                    minLength = new ArrayList<>();
                    minLength.addAll(current);

                }

            }

        }
        return minLength;
    }
    // Memoization
    public static List<Integer> bestSumMemo (int target, int [] numbers, int [] memory){
        if (target==0) return new ArrayList<>();//base case
        if (target<0) return null; // base case
        List<Integer> minLength = null;
        for (int i = 0; i <numbers.length ; i++) {
            int reminder = target - numbers[i];
            List <Integer> current = new ArrayList<>();
            if(reminder>=0 && memory[reminder]!=-100){
                List<Integer> temp = bestSumMemo(reminder,numbers,memory);
                if (temp!=null){
                    memory[reminder] = numbers[i];
                    current.add(numbers[i]);
                    if (minLength==null || current.size()<minLength.size()){
                        minLength = new ArrayList<>();
                        minLength.addAll(current);

                    }
                }
            }
            if (reminder>=0 && memory[reminder]!=-100){
                current.add(numbers[i]);
                if (minLength==null || current.size()<minLength.size()){
                    minLength = new ArrayList<>();
                    minLength.addAll(current);

                }


            }


        }
        return minLength;


    }
}
