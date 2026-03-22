class Solution {
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]>[] adjList =new ArrayList[n];
        int[] cost =new int[n];
        for(int i=0;i<n;i++)
        {
            adjList[i]=new ArrayList<>();
        }
        for(int[] edge:edges)
        {
            adjList[edge[0]].add(new int[] {edge[1],0});
            adjList[edge[1]].add(new int[] {edge[0],1});
        }
        dfsRoot0(0,-1,adjList,cost);
        dfsRoots(0,-1,adjList,cost);
        return cost;
    }
    private void dfsRoot0(int node ,int parent,List<int[]>[] adjList, int[] cost)
    {
        for(int[] next : adjList[node])
        {
            int nei =next[0];
            int weight=next[1];

            if(nei==parent) continue;
            cost[0]+=weight;
            dfsRoot0(nei,node,adjList,cost);
        }
    }
    private void dfsRoots(int node ,int parent,List<int[]>[] adjList,int[] cost)
    {
        for(int[] next : adjList[node]) {
            int nei = next[0];
            int weight = next[1];

            if(nei == parent) {
                continue;
            }

            int value = weight == 0 ? 1 : -1;
            cost[nei] = cost[node] + value;
            dfsRoots(nei, node, adjList, cost);
        }
    }
}