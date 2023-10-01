//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,n,grid,dp);
    }
    static int f(int i ,int j, int n,ArrayList<ArrayList<Integer> >grid,int dp[][]){
        if(i==n-1){
            return grid.get(n-1).get(j);
        }
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        int up= grid.get(i).get(j) + f(i+1,j,n,grid,dp);
        int down =grid.get(i).get(j) + f(i+1,j+1,n,grid,dp);
        
        return dp[i][j] = Math.min(up,down);
    }
}