package stack.histogram;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for (int k = 0; k < heights.length; k++) {
            int area = 0;
            int i = k, j = k + 1;

            while (i >= 0) {
                if (heights[i] >= heights[k]) {
                    area += heights[k];
                    i--;
                } else {
                    break;
                }
            }

            while (j < heights.length) {
                if (heights[j] >= heights[k]) {
                    area += heights[k];
                    j++;
                } else {
                    break;
                }
            }

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}