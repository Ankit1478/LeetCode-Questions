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
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String str, int k) {
        // your code here
        
       int n = str.length();
        return solve(str, n, k) - solve(str, n, k - 1);
        // aba
        // for k =2;
        // aba=> index = 0,1,2 sum = j-i+1 => 2+2+2 =6;
        
        // k==1
        // index = 1+1+1 = 3
        // 6-3 =3;
    }
    
     static long solve(String str, int n, int k) {
        
        int i = 0, j = 0;
        long ans = 0;
        long dist = 0;
        int[] arr = new int[26];

        while (j < n) {
            arr[str.charAt(j) - 'a']++;
            
            if (arr[str.charAt(j) - 'a'] == 1)
                dist++;

            while (dist > k) {
                arr[str.charAt(i) - 'a']--;
                if (arr[str.charAt(i) - 'a'] == 0)
                    dist--;

                i++;
            }

            ans += j - i + 1;
            j++;
        }

        return ans;
    }
}