package Dynamic_Programming.Sum;
import java.util.*;

public class BestSum {
    //Dynamic programming BestSum with hashmap
    public static ArrayList<Integer> bestSumMemoHM(int target, int [] numbers, HashMap<Integer,ArrayList<Integer>>memory){
       if(memory.containsKey(target)) return memory.get(target);
       if(target == 0) return new ArrayList<>();
       if(target<0) return null;

       ArrayList<Integer> shortestCombination = null;
        for (int i = 0; i <numbers.length ; i++) {
            int reminder = target-numbers[i];
            ArrayList<Integer> combination = bestSumMemoHM(reminder,numbers,memory);
            if(combination!=null){
                ArrayList<Integer> necessaryCombination = new ArrayList<>(combination);
                necessaryCombination.add(numbers[i]);
                if(shortestCombination == null || shortestCombination.size()>necessaryCombination.size()){
                    shortestCombination = (ArrayList<Integer>) necessaryCombination.clone();
                }
            }

        }
        memory.put(target,shortestCombination);
        return shortestCombination;
    }
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
                ArrayList<Integer>tempCombination = new ArrayList<>(currentCombination);
                tempCombination.add(numbers[i]);

                if(shortestCombination==null || shortestCombination.size()>tempCombination.size()){
                    shortestCombination= (ArrayList<Integer>) tempCombination.clone();
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
        int [] numbers = {1,2,5,25};
        // Dynamic
        ArrayList<Integer>lst = new ArrayList<>();
        ArrayList<ArrayList<Integer>>lstOflst = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> memOut = bestSumMemoHM(target,numbers,hm);
        System.out.println(memOut);
        // Non-dynamic
//        List<Integer> output = bestSum(target,numbers);
//        System.out.println(output);
    }

}
