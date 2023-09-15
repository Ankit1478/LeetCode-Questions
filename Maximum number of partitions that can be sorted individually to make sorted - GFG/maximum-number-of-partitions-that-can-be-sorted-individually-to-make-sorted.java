//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Complete obj = new Complete();
		    int ans = obj.maxPartitions(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maxPartitions (int arr[], int n) {
        //Complete the function
      
        int prefixMax[]=new int[n];
        int suffixmin[]=new int[n];

        prefixMax[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],arr[i]);
        }


        suffixmin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
             suffixmin[i]=Math.min(suffixmin[i+1],arr[i]);
        }

        int ans=1;
        for(int i=0;i<n-1;i++){
            if(prefixMax[i]<=suffixmin[i+1]){
                ans++;
            }
        }
        return ans;
    }
    
    
}


