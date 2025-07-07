package arrays.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return Collections.singletonList(Collections.singletonList(strs[0]));
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String currentString : strs) {
            int[] count = new int[26];
            for (Character currentChar : currentString.toCharArray()) {
                count[currentChar - 'a'] += 1;
            }

            List<String> existingList = map.getOrDefault(Arrays.toString(count), new ArrayList<>());
            existingList.add(currentString);
            map.put(Arrays.toString(count), existingList);
        }

        return map.values().stream().toList();
    }
}
