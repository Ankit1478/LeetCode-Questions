//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int N, int[] nums, int tar) {
        // code here
         int n = nums.length;
        int low =0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]==tar)return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                high--;
                low++;
                continue;
            }

            //left part is sorted
            else if(nums[low]<= nums[mid]){
                if(nums[low]<=tar && tar<=nums[mid]){
                    high = mid-1;
                }
                else{
                    low= mid+1;
                }
            }
            else{ 
                //right part is sorted
                if(nums[mid]<=tar && tar<= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

        }
        return false;
    }
}
        
