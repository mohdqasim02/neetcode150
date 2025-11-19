package slidingwindows.permutationinstring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> strFrequency = new HashMap();
        Map<Character, Integer> windowFrequency = new HashMap();

        for(int i = 0; i < s1.length(); i++) {
            strFrequency.put(s1.charAt(i), strFrequency.getOrDefault(s1.charAt(i), 0) + 1);
            windowFrequency.put(s2.charAt(i), windowFrequency.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (strFrequency.equals(windowFrequency)) return true;

        int l = 0;
        int r = s1.length();

        while (r < s2.length()) {
            int leftCharFreq = windowFrequency.get(s2.charAt(l));
            if (leftCharFreq > 1) {
                windowFrequency.put(s2.charAt(l), leftCharFreq - 1);
            } else {
                windowFrequency.remove(s2.charAt(l));
            }

            char rightChar = s2.charAt(r);
            int charFrequency = windowFrequency.getOrDefault(rightChar, 0);
            windowFrequency.put(rightChar, charFrequency + 1);
            l++; r++;
            if (strFrequency.equals(windowFrequency)) return true;
        }

        return false;
    }
}


