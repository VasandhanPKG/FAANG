class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int no_of_ele=heights.length;
        int[] result=new int[no_of_ele];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<no_of_ele;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()]<=heights[i])
            {
                result[stack.pop()]++;
            }
            if(!stack.isEmpty()) result[stack.peek()]++;
            stack.add(i);
        }
        return result;
        
    }
}