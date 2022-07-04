//Valid Anagram leetcode
//https://leetcode.com/problems/valid-anagram/
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