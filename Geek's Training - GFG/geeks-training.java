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
        int d[] = new int[N][4];
        
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int day =1;day<N ;day++){
            for(int last =0;last<4;last++){
                
                dp[day][last] =0;
                for(int task =0;task<=2;task++){
                    if(task!=last){
                    // int max=Math.max(max, points[day][task] + dp[day-1][task]);
                    int activity=Math.max(dp[day][last], points[day][task] + dp[day-1][task]);
                     dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
            
        }
        return dp[N-1][3];
    }
}