// Longest Repeating Character Replacement leetcode
// https://leetcode.com/problems/longest-repeating-character-replacement/
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
        }
        else{
            //2.4. Update the max length of the substring
            max = Math.max(max,total);
        }
    }
    //3. Return the max length of the substring
    return max;
}