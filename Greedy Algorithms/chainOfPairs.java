/*
Max Length Chain of Pairs
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
A pair (c, d) can come after pair (a, b) if b < c.
Find the longest chain which can be formed from a given set of pairs.

pairs =    ans = 3
(5, 24)
(39, 60)
(5, 28)
(27, 40)
(50, 90)
*/
// sort on basis of second number (same question a sactivity selection)

import java.util.*;

public class chainOfPairs {

    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int cnt = 1;
        int lastEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > lastEnd){
                cnt++;
                lastEnd = pairs[i][1];
            }
        }
        System.out.println(cnt);
    }
}