//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
        //code here
        int dp[][] = new int[N][4];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return f(N-1,3,points,dp);
    }
    static int f(int day , int last , int points[][] ,int dp[][]){
        
        if(day==0){
            int max =0;
            for(int i=0;i<3;i++){
               if(i!=last){
                   max = Math.max(max,points[0][i]);
               }
            }
            return max;
        }
        
        if(dp[day][last]!=-1) return dp[day][last];
        int max =0;
        int point=0;
        for(int i=0;i<3;i++){
            if(i!=last){
                point = points[day][i] + f(day-1, i, points,dp);
                max = Math.max(max,point);
            }
            
        }
        return dp[day][last]= max;
    }
}