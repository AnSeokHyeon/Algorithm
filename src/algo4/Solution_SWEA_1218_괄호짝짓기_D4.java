package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = 1;
		StringBuilder sb = new StringBuilder();
		while (T < 11) {
			int N = Integer.parseInt(br.readLine());
			String S = br.readLine();
			Stack<Character> st = new Stack<>();
			boolean chk = true;
			for (int i = 0; i < N; i++) {
				char c = S.charAt(i);
				//System.out.println(c + " / " + (c-'0'));
				if (c == '[' || c == '{' || c == '(' || c == '<') {
					//System.out.println("추가");
					st.add(c);
				} else {
					if (Math.abs(st.peek()-c) < 3) {
						//System.out.println("삭제");
						st.pop();

					} else {
						//System.out.println("**************틀려***************");
						chk = false;

					}

				}

				if (!chk)
					break;

			}
			sb.append("#").append(T++).append(" ").append(((chk)?1:0)).append("\n");
			
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
