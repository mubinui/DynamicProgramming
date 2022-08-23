package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class CanSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int [] a = {7,14};
        Boolean [] memory = new Boolean[target+1];
        System.out.println("Memoization "+canSumMem(target,a,memory));
        System.out.println("Without Memoization "+canSum(target,a));

    }
    public static boolean canSum(int target, int [] a){
      if (target==0) return true;
      if (target<0) return false;

      for(int i:a){
          int rem = target-i;
          if(canSum(rem,a)==true && rem>0){
              return true;
          }

      }
      return false;

    }
    public static boolean canSumMem(int target,int [] a, Boolean [] memory){
        if (target==0) return true;
        if (target<0) return false;
        for (int i = 0; i <a.length ; i++) {
            int rem = target-a[i];

            if(rem>=0 && memory[rem]==null ){
                memory[rem] = canSumMem(rem,a,memory);
                if(memory[rem]==true){
                    return true;
                }
            }


        }
        memory[target]=false;
        return false;
    }
}
