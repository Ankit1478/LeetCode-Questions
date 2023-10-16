//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    //storing the names of islands
    static HashMap<Integer, Integer> map = new HashMap<>();
    
    static int dfs(int i, int j, int[][]grid, boolean[][] visited, int name, int n) {
        //checking if index is invalid to return 0
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        //giving name to the cell in the grid
        grid[i][j] = name;
        //finding the 1's connected to the current cell
        int count = 1 + dfs(i + 1, j, grid, visited, name, n) + dfs(i, j + 1, grid, visited, name, n) + 
            dfs(i - 1, j, grid, visited, name, n) + dfs(i, j - 1, grid, visited, name, n);
        return count;
    }
    
    public int largestIsland(int n,int[][] grid) {
        //starting from 2 as 1 is already an element in the matrix
        int name = 2;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //checking if cell is 1 and is not already visited
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j, grid, visited, name, n);
                    map.put(name, count);
                    name++;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    //fetching the name of the island adjacent to the current cell
                    int down = (i + 1 < n) ? grid[i + 1][j] : 0;
                    int up = (i - 1 >= 0) ? grid[i - 1][j] : 0;
                    int left = (j + 1 < n) ? grid[i][j + 1] : 0;
                    int right = (j - 1 >= 0) ? grid[i][j - 1] : 0;
                    //set is used to store different islands connected to current cell
                    Set<Integer> set = new HashSet<>();
                    //storing names of adjacent islands
                    set.add(down);
                    set.add(up);
                    set.add(right);
                    set.add(left);
                    //result is initialized from 1 as the island count increases by 1 if a 0 is changed to 1
                    int result = 1;
                    for(int val : set) {
                        result += map.getOrDefault(val, 0);
                    }
                    answer = Math.max(answer, result);
                }
            }
        }
        //when all the cells were already 1
        if(answer == 0) return n * n;
        return answer;
    }
}
