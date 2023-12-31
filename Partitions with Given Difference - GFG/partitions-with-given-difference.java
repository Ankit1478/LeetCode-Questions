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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
	static int mod =(int)(Math.pow(10,9)+7);

    public int countPartitions(int n, int d, int arr[]){
        // Code here
    int totSum = 0;
    for(int i=0; i<arr.length;i++){
        totSum += arr[i];
    }
    
    if(totSum-d<0) return 0;
    
    if((totSum -d)%2==1)return 0;
    
    int s2 = (totSum-d)/2;
    
    int dp[][] = new int[n][s2+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
        
     return sum(arr,s2,n);
}
    public static int sum(int arr[],int d,int n){
        
       
        int prev[] = new int[d+1];
        if(arr[0]==0) prev[0] = 2;
        else prev[0] =1;
        
        if(arr[0]!=0 && arr[0]<= d) prev[arr[0]] =1;
        
	     
		 for(int i=1;i<n;i++){
		     int curr[] = new int[d+1];
		     for(int j=0;j<=d;j++){
		         
		         int notake = prev[j];
		         int take = 0;
		         if(arr[i]<= j){
		             take = prev[j-arr[i]];
		         }
		         curr[j] = (take+notake)%mod;
		     }
		     prev = curr;
		 }
		 return prev[d];
	}
}











