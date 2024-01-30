class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                map.putIfAbsent(j-i,new ArrayList<>());
                map.get(j-i).add(mat[i][j]);
            }
        }
        
       
       for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        
        int ans[][]= new int[n][m];
        
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                int k = j-i;
                
                ans[i][j] = map.get(j-i).remove(0);
            }
        }
        
        return ans;
    }
}