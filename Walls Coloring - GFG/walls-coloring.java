//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int[][] dp = new int[N][3];

        // Initialize the DP array with the cost of coloring the first wall.
        dp[0] = Arrays.copyOf(colors[0], 3);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                // Initialize the minimum cost with a large value.
                int minCost = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        minCost = Math.min(minCost, dp[i - 1][k]);
                    }
                }
                dp[i][j] = minCost + colors[i][j];
            }
        }

        // Find the minimum cost by coloring the last wall with any of the three colors.
        return Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));

    }
}