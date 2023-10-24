//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int nums[], int N)
    {
        // your code here
         int n = nums.length;
         if (n == 1) return nums[0];
         if (nums[0] != nums[1]) return nums[0];
         if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low=1;
        int high = n-2;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

           else if( (mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0  && nums[mid]==nums[mid+1] )){
                low= mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}