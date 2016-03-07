class Solution {
public:
	int lengthOfLongestSubstring(string s) {
		int m[256];
		fill(m, m + 256, -1);
		int maxLen = 0, lastRepeatPos = -1;
		for (int i = 0; i<s.size(); i++) {
			if (m[s[i]] != -1 && lastRepeatPos < m[s[i]]) lastRepeatPos = m[s[i]];
			if (i - lastRepeatPos > maxLen) maxLen = i - lastRepeatPos;
			m[s[i]] = i;
		}
		return maxLen;
	}
};