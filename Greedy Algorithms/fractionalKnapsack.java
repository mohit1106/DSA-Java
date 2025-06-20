/*
Fractional Knapsack Problem
Given weights and values of N items, fill a knapsack of capacity W with these items to achieve the maximum total value. 
Items can be broken into fractions (unlike 0/1 Knapsack).

value = [60, 100, 120]
weight = [10, 20, 30]
W = 50

Answer:
Maximum value = 240
*/
// find ratio 0f value/weight then higher ratios are to be selected. because we want val inc and weight dec, ratio will inc in both case
// iterate on ratio in decreasing order

import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {

    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int w = 50;

        double[][] ratio = new double[val.length][2]; //to sort (0th col - idx, 1st col - ratio)
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i]; 
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); // in ascending on basis of 2nd col i.e ratio

        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length-1; i >= 0; i--) { // to iterate in descending
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){ // include full item
                capacity -= weight[idx];
                finalVal += val[idx];
            } else{                        // to include only remaining fraction or remainng capacity
                finalVal += ratio[i][1] * capacity;  // value will be only for capacity remaining
                capacity = 0;
                break;
            }
        }
        System.out.println(finalVal);
    }
}