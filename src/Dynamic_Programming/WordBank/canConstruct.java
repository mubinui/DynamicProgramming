package Dynamic_Programming.WordBank;

import java.util.HashMap;
import java.util.Scanner;

public class canConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String [] wordBank = {"e","ee","eee","eeee","eeeeee"};
        //Dynamic Programming
        HashMap<String,Boolean> memory = new HashMap<>();
        System.out.println(canConstructMemo(target,wordBank,memory));

        // Without memoization
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

    public static boolean canConstructMemo(String target, String [] wordBank, HashMap<String,Boolean>memory){
        if (memory.containsKey(target)){
            if(memory.get(target)){
                System.out.println("->>>>>>");
                return true;
            }
            else {
                return false;
            }
        }
        if (target.length()==0) return true;

        for (int i = 0; i <wordBank.length ; i++) {

            if(target.length()>=wordBank[i].length() && target.startsWith(wordBank[i])){
                String tempTarget = target.substring(wordBank[i].length());
                if(canConstructMemo(tempTarget,wordBank,memory)){
                    memory.put(tempTarget,true);
                    return true;
                }
            }
        }
      memory.put(target,false);
      return false;
    }
}
