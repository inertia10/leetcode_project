public class leetcode_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n];
        for(Object x:dp)
            x=0;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<n;i++)
            dp[i] = dp[i-1]+dp[i-2];
        return dp[n-1];
    }
}
