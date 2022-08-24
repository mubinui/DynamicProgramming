package Necessary_Concepts;

import java.util.ArrayList;
import java.util.Scanner;

public class NecessaryConcepts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
        ArrayList<Integer> ListA = new ArrayList<>();
        ArrayList<Integer> ListB = new ArrayList<>();

        for (int i = 0; i <100 ; i++) {
            ListA.add(i*10);
            ListB.add(i*20);

        }
        System.out.println(ListA);
        System.out.println(ListB);

        listOfList.add(ListA);
        listOfList.add(ListB);

        System.out.println(listOfList.get(0));
        System.out.println(listOfList.get(1));
        System.out.println(listOfList);
    }
}
