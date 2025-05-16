// problem - https://leetcode.com/problems/beautiful-array/description/

class Solution {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        int[] odd = beautifulArray((n + 1) / 2); // build odd part
        int[] even = beautifulArray(n / 2);      // build even part
        
        int[] result = new int[n];
        int index = 0;
        
        // Map odd part to odd numbers: 2*x - 1
        for (int x : odd) {
            result[index++] = 2 * x - 1;
        }
        // Map even part to even numbers: 2*x
        for (int x : even) {
            result[index++] = 2 * x;
        }
        
        return result;
    }
}
