//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int f(int arr[],int mid,int m){
        long pages =0;
        int student=1;
        
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]<=mid){
                pages+=arr[i];
            }
            else{
                student++;
                pages = arr[i];
            }
        }
        return student;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int M)
    {
        if(M>n)return -1;
        int sum = 0;
        int max =0;
        for(int i=0;i<n;i++){
            sum+= arr[i]; 
            max = Math.max(arr[i],max);
        }
        
        int low = max;
        int high =sum;
        while(low<=high){
            int mid = (low+high)/2;
            int noOfStudent = f(arr,mid,M);
            
            if(noOfStudent>M){
                low =mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return low;
    }
};