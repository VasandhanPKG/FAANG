class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        if(n==1) return new int [queries.length];
        int[] color=new int[n];
        int findpair=0;
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int index=queries[i][0];
            int assign_color=queries[i][1];
            int l_color=(index-1)>=0?color[index-1]:0;
            int r_color=(index+1)<n?color[index+1]:0;

            if(color[index]!=0 && l_color==color[index]) findpair--;
            if(color[index]!=0 && r_color==color[index]) findpair--;

            color[index]=assign_color;
            if(l_color!=0 && color[index]==l_color) findpair++;
            if(r_color!=0 && color[index]==r_color) findpair++;

            result[i]=findpair;
            
           
        }
        return result;
        
    }
}
    