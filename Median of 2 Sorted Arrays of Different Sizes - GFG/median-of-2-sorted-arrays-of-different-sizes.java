//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int z, int m, int nums1[], int nums2[]) 
    {
        // Your Code Here
         int i=0;
        int j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k=0;
        int arr[] = new int[n1+n2];
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else{
                arr[k] = nums2[j];
                k++;
                j++;
            }
        }
        while(i<n1){
             arr[k] = nums1[i];
                i++;
                k++;
        }
        while(j<n2){
            arr[k] = nums2[j];
             k++;
             j++; 
        }

        int n = n1+n2;
        if(n%2==1)return (double)arr[n/2];
        else return  (arr[n / 2] + arr[n / 2 - 1]) / 2.0;
    }
}