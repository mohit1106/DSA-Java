/*
We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].  
Find min no. of coins/notes to make change for a value V.

V = 121  
ans = 3 (100+20+1)  

V = 590  
ans = 4 (500+50+20+20)
*/ 

import java.util.*;
public class indianCoins {

    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(coins, Comparator.reverseOrder());

        int val = 590, cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= val){
                while(coins[i] <= val){
                    cnt++;
                    ans.add(coins[i]);
                    val = val - coins[i];
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
}