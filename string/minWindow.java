// Minimum Window Substring leetcode
// https://leetcode.com/problems/minimum-window-substring/
public String minWindow(String s, String t) {
    int[] map = new int[128];
    for (char c : t.toCharArray()) {
        map[c]++;
    }
    int counter = t.length();
    int begin = 0, end = 0;
    int head = 0, tail = 0;
    int min = Integer.MAX_VALUE;
    while (end < s.length()) {

        if (map[s.charAt(end++)]-- > 0) {
            counter--;
        }
        
        
        while (counter == 0) {
            if (end - begin < min) {
                min = end - begin;
                head = begin;
                tail = end;
            }
            if (map[s.charAt(begin++)]++ == 0) {
                counter++;
            }
        }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(head, tail);
}
