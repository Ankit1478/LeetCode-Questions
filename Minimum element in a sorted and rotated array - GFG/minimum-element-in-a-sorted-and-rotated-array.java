//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int nums[], int n)
    {
        //complete the function here
        int low =0;
        int high =n-1;
        int ans = Integer.MAX_VALUE;

        while(low<=high){
            
            int mid = (low+high)/2;

            if(nums[low]<=nums[mid]){ //left side sorted
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
                
        }
        return ans;
    }
}
