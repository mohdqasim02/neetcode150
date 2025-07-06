package arrays.twosum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (valueIndexMap.containsKey(diff)) {
                return new int[] { valueIndexMap.get(diff), i };
            }

            valueIndexMap.put(num, i);
        }

        return new int[] {};
    }
}

