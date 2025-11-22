package slidingwindows.minimumwindowsubstring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> strFrequency = new HashMap<>();
        Map<Character, Integer> windowFrequency = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            strFrequency.put(c, strFrequency.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int have = 0;
        int need = strFrequency.size();
        int maxLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (r < s.length()) {
            if (have < need) {
                char c = s.charAt(r);
                if (strFrequency.containsKey(c)) {
                    windowFrequency.put(c, windowFrequency.getOrDefault(c, 0) + 1);
                    if (windowFrequency.get(c).equals(strFrequency.get(c))) have++;
                }
                r++;
            }

            while (have == need) {
                if (maxLength > r - l) {
                    start = l;
                    end = r;
                    maxLength = end - start;
                }
                char c = s.charAt(l);
                if (strFrequency.containsKey(c)) {
                    if (windowFrequency.get(c).equals(strFrequency.get(c))) have--;
                    windowFrequency.put(c, windowFrequency.get(c) - 1);
                }
                l++;
            }
        }

        return s.substring(start, end);
    }
}


