package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class GridTraveler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int [][] a = new int[x+1][y+1];
        for(int [] row:a){
            Arrays.fill(row,-1);
        }
        System.out.println("The number of ways [With Dynamic] "+gridTraveller(x,y,a));
        System.out.println("The number of ways [Without Dynamic] "+gridTraveller(x,y));


    }

    public static int gridTraveller(int x, int y) {
        if (x==0||y==0){
            return 0;
        }
        if (x==1 && y ==1){
            return 1;
        }
        return gridTraveller(x-1,y) + gridTraveller(x,y-1);

    }

    public static int gridTraveller(int x,int y,int [][] a){
        int down,right;
        if (x==0||y==0){
            return 0;
        }
        if (x==1 && y==1){
            return 1;
        }
        if(a[x-1][y]==-1){
            a[x-1][y] = gridTraveller(x-1,y,a);
        }
        down = a[x-1][y];
        if(a[x][y-1]==-1){
            a[x][y-1] = gridTraveller(x,y-1,a);
        }
        right = a[x][y-1];
        return down+right;

    }
}
