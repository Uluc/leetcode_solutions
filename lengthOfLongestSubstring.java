public int lengthOfLongestSubstring(String s) {
    //1. if length of string is 0 no substring
    if (s.length()==0) return 0;
    //2. Create a hashmap to store the index of each character in the string
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    //3. Create a pointer to traverse the string
    for (int i=0, j=0; i<s.length(); ++i){
        //3.1. If the character is already in the hashmap, update the index of the character
        if (map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
        }
        //3.2. Update the hashmap with the current index of the character
        map.put(s.charAt(i),i);
        //3.3. Update the max length of the substring
        max = Math.max(max,i-j+1);
    }
    //4. Return the max length of the substring
    return max;
}


public int characterReplacement(String s, int k) {
    //1. Declare variables
    int left = 0;
    int[] count = new int[26];//used to store freq of characters
    int max = 0;
    int most_freq = 0; //count of character with highest freq
    //2. Traverse the string 
    for(int right = 0; right < s.length(); right++){
        //2.1. Update the count of the current character
        char ch = s.charAt(right);
        count[ch-'A']++;
        //2.2. Update the most_freq
        most_freq = Math.max(most_freq,count[ch-'A']);
        int total = right-left+1; //total elements in the string from left to right
        int replace_count = total-most_freq; //number of characters that needs to be replaced            
        //2.3. If the number of characters that needs to be replaced is greater than k, update the left pointer
        if(replace_count>k){
            //increment left and decrement the count of character at left pointer
            count[s.charAt(left)-'A']--;
            left++;
        }else{
            //2.4. Update the max length of the substring
            max = Math.max(max,total);
        }
    }
    //3. Return the max length of the substring
    return max;
}

// solve Minimum Window Substring from leetcode


public String minWindow(String s, String t) {
    //1. Declare variables 
    if (s == null || t == null) {
        throw new IllegalArgumentException("Input string is null");
    }
    if (s.length() < t.length() || t.length() == 0) {
        return "";
    }

    //2. Create a hashmap to store the index of each character in the string
    HashMap<Character, Integer> map = new HashMap<>();
    //3. Traverse the string and update the hashmap with index of each character
    for (int i = 0; i < t.length(); i++) {
        map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    //4. 
    int start = 0;
    int end = 0;
    int charTLeft = t.length();
    int minStart = 0;
    int minLen = Integer.MAX_VALUE;

    while (end < s.length()) {
        char eChar = s.charAt(end);
        if (map.containsKey(eChar)) {
            int count = map.get(eChar);
            if (count > 0) {
                charTLeft--;
            }
            map.put(eChar, count - 1);
        }
        end++;

        while (charTLeft == 0) {
            if (minLen > end - start) {
                minLen = end - start;
                minStart = start;
            }
            char sChar = s.charAt(start);
            if (map.containsKey(sChar)) {
                int count = map.get(sChar);
                if (count == 0) {
                    charTLeft++;
                }
                map.put(sChar, count + 1);
            }
            start++;
        }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
}


public boolean isAnagram(String s, String t) {
    //1. Declare charcaracter array to store the frequency of each character in the string
    int[] freq = new int[26];

    //2. Traverse the string and update the frequency of each character
    for (int i = 0; i < s.length(); i++) {
        freq[s.charAt(i) - 'a']++;
    }
    //3. Traverse the string and update the frequency of each character
    for (int i = 0; i < t.length(); i++) {
        freq[t.charAt(i) - 'a']--;
    }
    //4. Check if the frequency of each character is 0 
    for (int i = 0; i < freq.length; i++) {
        //4.1. If the frequency of each character is not 0, return false
        if (freq[i] != 0) {
            return false;
        }
    }
    //5. Return true if the frequency of each character is 0
    return true;
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1. Declare a list to store the list of anagrams
        List<List<String>> res = new ArrayList<>();
        //2. Declare a hashmap to store the list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        //3. Traverse the string array
        for (int i = 0; i < strs.length; i++) {
            //3.1. Create a string to store the sorted string
            String sorted = sort(strs[i]);
            //3.2. If the sorted string is already in the hashmap, add the string to the list of anagrams
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                //3.3. If the sorted string is not in the hashmap, create a new list and add the string to the list of anagrams
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }

        }
        //4. Traverse the hashmap and add the list of anagrams to the list of anagrams
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        //5. Return the list of anagrams
        return res;

    }
    //6. Sort the string
    private String sort (String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}


public boolean isValid(String s) {
    //1. Declare a stack to store the characters
    Stack<Character> stack = new Stack<Character>();
    //2. Traverse the string
    for (char c : s.toCharArray()) {
        //2.1. If the character is a left parenthesis, push ) to the stack
        if (c == '(')
            stack.push(')');
        //2.2. If the character is a left curly brace, push } to the stack
        else if (c == '{')
            stack.push('}');
        //2.3. If the character is a left square bracket, push ] to the stack
        else if (c == '[')
            stack.push(']');
        //2.4 if stack is empty or the top of the stack is not equal to the character, return false
        else if (stack.isEmpty() || stack.pop() != c)
            return false;
        else if (stack.isEmpty() || stack.pop() != c)
            return false;
    }
    return stack.isEmpty();
}

public boolean isPalindrome(String s) {
    //1.make all the characters in the string same case
    s = s.toLowerCase();
    //2. convert the string to char array
    char[] arr = s.toCharArray();
    //3. declare pointers for the left and right end of the string
    int left = 0, right = s.length() - 1;
    
    //4. while the left pointer is less than the right pointer 
    while(left < right){    
        //4.1. if the character at the left pointer is not a letter, move the left pointer to the next character
        while(left < right && !Character.isLetterOrDigit(arr[right])) 
            right--;
        //4.2. if the character at the right pointer is not a letter, move the right pointer to the next character
        while(left < right && !Character.isLetterOrDigit(arr[left])) 
            left++;
        //4.3. if the character at the left pointer is not equal to the character at the right pointer, return false
        if(arr[left++] != arr[right--]) 
            return false;
    }
    //5. return true
    return true;
}

class Solution {
    public String longestPalindrome(String s) {
        //1. If string is empty or has only one character, return the string
        if (s == null || s.length() < 1) return "";
        //2. Declare left and right pointers
        int left = 0, right = 0;
        //3. Traverse the string
        for (int i = 0; i < s.length(); i++) {
            //3.1. Find the longest palindrome with odd length
            int len1 = expandAroundCenter(s, i, i);
            //3.2. Find the longest palindrome with even length
            int len2 = expandAroundCenter(s, i, i + 1);
            //3.3. Find the longest palindrome between two found lengths
            int len = Math.max(len1, len2);
            //3.4. If the length is greater than the current length, update the left and right pointers
            if (len > right - left) {
                //3.4.1. Update the left pointer
                left = i - (len - 1) / 2;
                //3.4.2. Update the right pointer
                right = i + len / 2;
            }
        }
        //4. Return the substring between the left and right pointers
        return s.substring(left, right + 1);
    }

    //Method to expand around center until palindrome is found. 
    //Return lenght of palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

class Solution {
    public int countSubstrings(String s) {
        //1. Declare a count variable to store the number of substrings
        int count=0;
        //2. Traverse the string
        for(int i=0;i<s.length();i++){
            //2.1. Find the number of substrings with odd length add to count
            count+= expandAroundCenter(s,i,i);
            //2.2. Find the number of substrings with even length add to count
            count+= expandAroundCenter(s,i,i+1);
        }

        return count;
    }
    //Method to extract palindrome from a string
    public int expandAroundCenter(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            //There is a palindrome evertime it's expanded.
            count++;
        }
        return count;
    }
}