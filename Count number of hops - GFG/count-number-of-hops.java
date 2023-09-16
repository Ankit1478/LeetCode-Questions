//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
   static int mod = 1000000007;

    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n) {
        long[] dp = new long[n + 1];
        
        
        if(n==1 || n==2 )return n;
        // Base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2]=  2;

        // Calculate the number of ways for each step from 3 to N
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }

        return dp[n];
    }
    
}

