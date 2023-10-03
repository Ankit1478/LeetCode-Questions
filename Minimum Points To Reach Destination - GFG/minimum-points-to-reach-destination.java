//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    int points[][] = new int[m][n];
                    for(int i = 0;i<m;i++)
                    for(int j = 0;j<n;j++)
                    points[i][j] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minPoints(points,m,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minPoints(int arr[][],int n,int m) 
	{ 
	    // Your code goes here
	    int dp[][] = new int [n][m];
	    for(int row[]:dp){
	        Arrays.fill(row,-1);
	    }
	    return f(arr,0,0,dp);
	} 
	 public int f(int[][] dungeon, int n, int m,int dp[][]) {
        if (n >= dungeon.length || m >= dungeon[0].length)
            return Integer.MAX_VALUE;
        
        if (n == dungeon.length - 1 && m == dungeon[0].length - 1)
            return Math.max(1, 1 - dungeon[n][m]);
        
        if (dp[n][m] != -1)
            return dp[n][m];
        
        int res = Math.min(f(dungeon, n + 1, m,dp), f(dungeon, n, m + 1,dp)) - dungeon[n][m];
        res = Math.max(1, res);
        
        return dp[n][m] = res;
	 }
}