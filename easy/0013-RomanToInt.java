import java.util.HashMap;

/* 
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3

Example 2:
Input: s = "IV"
Output: 4

Example 3:
Input: s = "IX"
Output: 9

Example 4:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

// Time Complexity: Linear - O(n) - O of n where n is the length of string
// Space Complexity: Constant - O(10) - O of 10

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        int sum = map.get(s.charAt(s.length() - 1));
        
        for (int i = s.length() - 2; i >= 0; i--) {
            char first = s.charAt(i); 
            char second = s.charAt(i + 1);
            
            if (map.get(first) < map.get(second)) {
                sum -= map.get(first);
            } else {
                sum += map.get(first);
            }
        }
        
        return sum;
    }
}

// another solution to avoid using a HashMap is to use a switch case inline:
// Time Complexity: Linear - O(n) - O of n where n is the length of string
// Space Complexity: Constant - O(3) - O of 3

class Solution2 {
    private int getNumericValue(Character ch) {
        switch(ch) {
            case 'I': 
                return 1;
            case 'V': 
                return 5;
            case 'X': 
                return 10;
            case 'L': 
                return 50;
            case 'C': 
                return 100;
            case 'D': 
                return 500;
            case 'M': 
                return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int sum = getNumericValue(s.charAt(s.length() - 1));
        
        for (int i = s.length() - 2; i >= 0; i--) {
            char first = s.charAt(i); 
            char second = s.charAt(i + 1);
            
            if (getNumericValue(first) < getNumericValue(second)) {
                sum -= getNumericValue(first);
            } else {
                sum += getNumericValue(first);
            }
        }
        
        return sum;
    }
}