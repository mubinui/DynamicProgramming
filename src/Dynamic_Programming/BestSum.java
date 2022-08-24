package Dynamic_Programming;
import java.util.*;

public class BestSum {
    //Dynamic programming BestSum
    public static ArrayList<Integer> bestSumMemo(int target, int [] numbers, ArrayList<Integer>memoInt,ArrayList<ArrayList<Integer>>memoList){
        // memoization part
        for (int i = 0; i <memoInt.size() ; i++) {
            if(memoInt.get(i)==target){
                return memoList.get(i);
            }
        }
        // Recursive part
        if(target == 0) return new ArrayList<>();
        if(target<0) return null;

        ArrayList<Integer> shortestCombination = null;
        for (int i = 0; i <numbers.length ; i++) {
            int reminder = target - numbers[i];
            ArrayList<Integer> currentCombination = bestSumMemo(reminder,numbers,memoInt,memoList);
            if(currentCombination!=null){
                currentCombination.add(numbers[i]);
                if(shortestCombination==null || shortestCombination.size()>currentCombination.size()){
                    shortestCombination = new ArrayList<>();
                    shortestCombination.addAll(currentCombination);
                }
            }

        }
        memoInt.add(target);
        memoList.add(shortestCombination);
        return shortestCombination;
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
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int target = sc.nextInt();
        int [] numbers = {3,4,5,1,8,9,7};
        // Dynamic
        ArrayList<Integer>lst = new ArrayList<>();
        ArrayList<ArrayList<Integer>>lstOflst = new ArrayList<>();
        ArrayList<Integer> memOut = bestSumMemo(target,numbers,lst,lstOflst);
        System.out.println(memOut);
        // Non-dynamic
        List<Integer> output = bestSum(target,numbers);
        System.out.println(output);
    }

}
