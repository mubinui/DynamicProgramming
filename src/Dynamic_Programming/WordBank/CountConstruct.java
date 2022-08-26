package Dynamic_Programming.WordBank;
import java.util.HashMap;
import java.util.Scanner;

public class CountConstruct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String [] wordBank = {"ab","abc","cd","def","abcd"};
        String [] wordBank1 = {"e","ee","eee","eeee"};
        //Memoization
        HashMap<String,Integer> memory = new HashMap<>();
        System.out.println(countConstructMemo(target,wordBank,memory));
        //Without memoization
        System.out.println(countConstruct(target,wordBank));


    }
    //Without memoization
    public static int countConstruct (String target, String [] wordBank){
        if (target.length()==0) return 1;
        int counter = 0;

        for (int i = 0; i <wordBank.length ; i++) {
            if(target.length()>=wordBank[i].length() && target.startsWith(wordBank[i])){
                String tempTarget = target.substring(wordBank[i].length());
                if((countConstruct(tempTarget,wordBank)==1)){
                    counter++;
                }

            }

        }
        return counter;

    }

    //With memoization
    public static int countConstructMemo(String target, String [] wordBank, HashMap<String,Integer> memory){
        int counter = 0;
        if(memory.containsKey(target)){
            if (memory.get(target)>0){
                return memory.get(target);
            }
            else{
                return counter;
            }
        }
        if (target.length()==0) return 1;

        for (int i = 0; i <wordBank.length ; i++) {
            if(target.length()>=wordBank[i].length() && target.startsWith(wordBank[i])){
                String tempTarget = target.substring(wordBank[i].length());

                if (countConstructMemo(tempTarget,wordBank,memory)==1){
                    memory.put(tempTarget,1);
                    counter++;
                }
            }

        }
        memory.put(target,counter);
        return counter;
    }

}
