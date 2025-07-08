package arrays.topkfrequentelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        List<Set<Integer>> sortedFrequency = new ArrayList<>(nums.length + 1);

        for (int i = 0; i < nums.length + 1; i++) {
            sortedFrequency.add(new HashSet<>());
        }

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        frequencyMap.forEach((key, value) -> sortedFrequency.get(value).add(key));

        int[] result = sortedFrequency.stream()
            .filter(set -> !set.isEmpty())
            .flatMap(Set::stream)
            .mapToInt(Integer::intValue)
            .toArray();

        return Arrays.copyOfRange(result, result.length - k, result.length);
    }
}


