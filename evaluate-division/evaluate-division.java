class Solution {
    public double dfs(String src,String dest,HashSet<String>vis,HashMap<String,Map<String,Double>>map)
    {
        if(!map.containsKey(src) ||  !map.containsKey(dest)){
            return -1.0;
        }

       if(src.equals(dest))return 1.0;

        vis.add(src);

        for(Map.Entry<String,Double>it:map.get(src).entrySet()){
            if(!vis.contains(it.getKey())){
                double wt = dfs(it.getKey(),dest,vis,map);  // tell valid path 

                if(wt!=-1.0){
                return it.getValue()*wt; // a->b -> c  c return 1.0 , b = 1.0*3.0 , a = 3.0 * 2.0 =6;
            }
           
            }
            
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Map<String,Double>>map = new HashMap<>();
        int n =equations.size();
        for(int i=0;i<n;i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            map.putIfAbsent(u,new HashMap<>());
            map.putIfAbsent(v,new HashMap<>());

            map.get(u).put(v,values[i]);
            map.get(v).put(u,1/values[i]);

        }

        double ans[] = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            HashSet<String>vis = new HashSet<>();
            
            ans[i] = dfs(src,dest,vis,map);
        }
        return ans;
    }
}