//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static Boolean isSubsetSum(int n, int arr[], int sum){
        
        boolean dp[][]= new boolean[n][sum+1];
        
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        
        if(arr[0]<=sum){
             dp[0][arr[0]]=true;
        }
        
        for(int idx=1;idx<n;idx++){
            for(int tar = 1;tar<=sum;tar++){
                boolean nottake = dp[idx-1][tar];
                boolean take = false;
                
                if(arr[idx]<= tar){
                    take = dp[idx-1][tar-arr[idx]];
                }
                
                dp[idx][tar] =  take || nottake;
            }
            
        }
        return dp[n-1][sum];
    }
 
}