package knapsack;

public class Solution {

    public static int knapsack(int[] weights, int[] values, int si, int n, int maxWeight) {
        if (si == n || maxWeight == 0) { // reached end or empty array
            return 0;
        }

        if (weights[si] > maxWeight) {
            return knapsack(weights, values, si + 1, n, maxWeight);
        }

        int op1 = values[si] + knapsack(weights, values, si + 1, n, maxWeight - weights[si]);
        int op2 = knapsack(weights, values, si + 1, n, maxWeight);

        return Math.max(op1, op2);

    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {

        return knapsack(weights, values, 0, n, maxWeight);
    }

    public static int knapsack2(int[] weights, int[] values, int n, int maxWeight) {
        if (n == 0 || maxWeight == 0) {
            return 0;
        }

        int[][] ans=new int[n + 1][maxWeight + 1];
        for(int i=0;i<=n;++i){
            ans[i][0]=0;
        }

        for(int i=0;i<=maxWeight;++i){
            ans[0][i]=0;
        }

        for(int i=1;i<=n;++i){
            for(int j=1;j<=maxWeight;++j){
                if(weights[i-1]<=j){
                    ans[i][j]=Math.max(ans[i-1][j], values[i-1] + ans[i-1][j-weights[i-1]]);
                }
                else{
                    ans[i][j]=ans[i-1][j];
                }
            }
        }

        return ans[n][maxWeight];
    }

}