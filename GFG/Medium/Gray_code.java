package GFG.Medium;

/* Given a number n, generate bit patterns from 0 to 2n-1 such that successive patterns differ by one bit. 
A Gray code sequence must begin with 0.
 
Examples:
Input: n = 2
Output: ["00", "01", "11", "10"]
Explanation: 
00 and 01 differ by one bit.
01 and 11 differ by one bit.
11 and 10 also differ by one bit.
Input: n = 3
Output: ["000", "001", "011", "010", "110", "111", "101", "100"]
Explanation:
000 and 001 differ by one bit.
001 and 011 differ by one bit.
011 and 010 differ by one bit.
Similarly, every successive pattern 
differs by one bit.
Constraints :
1 ≤ n ≤ 16
*/
import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        
        ArrayList<String> res = new ArrayList<>();
        res.add("0");
        res.add("1");
        
        for(int i = 2; i <= n; i++){
            
            int size = res.size();
            
            // add reversed with '1'
            for(int j = size - 1; j >= 0; j--){
                res.add("1" + res.get(j));
            }
            
            // add '0' to existing
            for(int j = 0; j < size; j++){
                res.set(j, "0" + res.get(j));
            }
        }
        
        return res;
    }
}