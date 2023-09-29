//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static int smallestSumSubarray(int a[], int n)
    {
        // your code here
         if (n == 0) {
            return 0;
        }

        int minSum = a[0];
        int currentSum = a[0];

        for (int i = 1; i < n; i++) {
            // Update the current sum to be the minimum of the current element and the current sum plus the element
            currentSum = Math.min(a[i], currentSum + a[i]);
            // Update the minimum sum found so far
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }
}