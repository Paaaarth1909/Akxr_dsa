package GFG.Medium;

/* class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] freq = new int[26];

        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        return Math.min(
                Math.min(freq['b' - 'a'], freq['a' - 'a']),
                Math.min(
                    freq['n' - 'a'],
                    Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2)
                )
        );
    }
} 
*/

import java.util.List;

class Solution {
    public int maxArea(List<Integer> height) {
        
        int left = 0;
        int right = height.size() - 1;
        
        int maxArea = 0;
        
        while (left < right) {
            
            int h = Math.min(height.get(left), height.get(right));
            int width = right - left - 1;
            
            maxArea = Math.max(maxArea, h * width);
            
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}