package Dynamic_Programming.WordBank;

import java.util.Scanner;

public class canConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String [] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(canConstruct(target,wordBank));

    }
    public static boolean canConstruct (String target,String [] wordBank) {
        if (target.length()==0) return true;

        for (int i = 0; i <wordBank.length ; i++) {
            if(target.length()>=wordBank[i].length() && target.startsWith(wordBank[i])){
                if (canConstruct(target.substring(wordBank[i].length()),wordBank)){
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean canConstructMemo(String target, String [] wordBank){

      return false;
    }
}
