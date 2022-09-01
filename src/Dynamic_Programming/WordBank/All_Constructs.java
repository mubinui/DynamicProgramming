package Dynamic_Programming.WordBank;

import java.util.ArrayList;
import java.util.Scanner;

public class All_Constructs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String [] wordBank = {"ab","abc","cd","def","abcd"};
        String [] wordBank1 = {"e","ee","eee","eeee"};
        ArrayList<ArrayList<String>>allCon = new ArrayList<>();
        ArrayList<ArrayList<String>> constructs = allConstructs(target,wordBank,allCon);
        System.out.println(constructs);

    }

    public static ArrayList<ArrayList<String>> allConstructs(String target, String [] wordBank,ArrayList<ArrayList<String>>allCon) {
        if (target.length()==0) return new ArrayList<>();
        ArrayList<String> construction = new ArrayList<>();
        for (int i = 0; i <wordBank.length; i++) {
            if(target.length()>=wordBank[i].length() && target.startsWith(wordBank[i])){
                String tempTarget = target.substring(wordBank[i].length());
                if( allConstructs(tempTarget,wordBank,allCon)!=null){
                    System.out.println(wordBank[i]);

                }
            }

        }
        return allCon;
    }


}
