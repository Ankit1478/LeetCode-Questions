//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean f(int arr[],int mid,int k){
        int sum=0;
        int cnt=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>=mid){
                 cnt++;
                 sum = 0;
                 
            }
        }
        if(cnt<k) return true;
        return false;
    }
	int maxSweetness(int [] arr, int n, int k) {
	    // Write your code here.' 
	    
        int sum = 0;
        int min =0;
        for(int i=0;i<n;i++){
            sum+= arr[i]; 
            min = Math.min(arr[i],min);
        }
        
        int low = min;
        int high = sum;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(f(arr,mid,k+1)){
                high=mid-1;
            }
            else{
               low=mid+1;
            }
        }
        return high;
	}
}