//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 


// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
        ArrayList<Integer>pol=new ArrayList<>();
        ArrayList<Integer>thi=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]=='P'){
                pol.add(i);
            }
            else{
                thi.add(i);
            }
        }
        int i=0;
        int j=0;
        int res=0;
        
        int l = 0, r = 0;
        while (l < thi.size() && r < pol.size()) {
            // can be caught
            if (Math.abs(thi.get(l) - pol.get(r)) <= k) {
                res++;
                l++;
                r++;
            }
            
            else if (thi.get(l) < pol.get(r))
                l++;
            else
                r++;
        }
        return res;
	} 
} 



//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}       
// } Driver Code Ends