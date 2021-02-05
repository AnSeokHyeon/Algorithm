package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_SWEA_1223_계산기2_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = 1;
		StringBuilder sb = new StringBuilder();
		while (T < 11) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			Stack<Character> st = new Stack<>();
			StringBuilder sb2 = new StringBuilder();
			int n = 0;
			while (n < N) {
				char c = s.charAt(n++);
				if (c == '+' || c == '*') {

					if (st.isEmpty())
						st.push(c);
					else {
						if (c == st.peek()) {
							sb2.append(st.peek());
							st.pop();
						} else if (c == '*' && st.peek() == '+') {
						} else {
							while (!st.isEmpty()) {
								sb2.append(st.peek());
								st.pop();

							}
						}
						st.push(c);
					}
				} else {
					sb2.append(c);
				}
			}
			while (!st.isEmpty()) {
				sb2.append(st.peek());
				st.pop();

			}
			Stack<Integer> cal = new Stack<>();
			int A = 0;
			int B = 0;
			for (int i = 0; i < N; i++) {
				char c = sb2.charAt(i);
				if (!(c == '*' || c == '+')) {
					cal.push((sb2.charAt(i) - '0'));

				} else {
					A = cal.peek();
					cal.pop();
					B = cal.peek();
					cal.pop();
					int C = 0;
					if (c == '*') {
						C = A * B;
					} else {
						C = A + B;
					}
					cal.push(C);

				}
			}
			sb.append("#").append(T++).append(" ").append(cal.peek() + "\n");
			cal.pop();
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
