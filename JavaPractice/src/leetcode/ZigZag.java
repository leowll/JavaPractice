package leetcode;

public class ZigZag {

	public String convert(int nRows, String s) {
		StringBuffer[] sb = new StringBuffer[nRows];
		for (int i = 0; i < s.length(); i++) {
			sb[i] = new StringBuffer();
		}
		int i = 0;
		while (i < s.length()) {
			for (int idx = 0; idx < nRows; idx++) {
				sb[idx].append(s.charAt(i++));
			}
			for (int idx = nRows - 2; idx > 0; idx--) {
				sb[idx].append(s.charAt(i++));
			}
		}

		for (int idx = 1; idx < sb.length; idx++)
			sb[0].append(sb[idx]);

		return sb[0].toString();
	}
}
