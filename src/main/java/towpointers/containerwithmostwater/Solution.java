package towpointers.containerwithmostwater;

class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            int width = right - left;

            maxArea = Math.max((minHeight * width), maxArea);

            if (heights[left] <= heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}