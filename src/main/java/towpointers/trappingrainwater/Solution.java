package towpointers.trappingrainwater;

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int totalWaterTrapped = 0;

        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                totalWaterTrapped += maxLeft - height[l];
            }
            else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                totalWaterTrapped += maxRight - height[r];
            }
        }

        return totalWaterTrapped;
    }
}