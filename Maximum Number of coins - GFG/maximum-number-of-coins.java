//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
	
		ArrayList<Integer>temp = new ArrayList<>();
		temp.add(1);
		for(int i=0;i<N;i++){
		    temp.add(arr.get(i));
		}
	    temp.add(1);
	    int n = temp.size();
	    
	    int dp[][] = new int[n+2][n+2];
	    for(int row[]:dp)Arrays.fill(row,-1);
	    return f(1,arr.size(),temp,dp);
	    
	}
	static int f(int i ,int j,  ArrayList<Integer> arr,int dp[][]){
	    if(i>j)return 0;
	     if(dp[i][j]!=-1) return dp[i][j];
	    int max =Integer.MIN_VALUE;
	    
	    
	    for(int k=i;k<=j;k++){
	        int cost = arr.get(i-1)*arr.get(k)*arr.get(j+1)+f(i,k-1,arr,dp) + f(k+1,j,arr,dp);
	        max = Math.max(cost,max);
	    }
	    return dp[i][j]=max;
	}
}