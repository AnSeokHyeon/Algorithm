// 스택 수열

package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		StringBuilder sb = new StringBuilder();

		Stack<Integer> s = new Stack<>();
		int cnt = 0;

		boolean result = false;
		while (cnt < N) {
			int n = Integer.parseInt(br.readLine());
			result = false;
			while (idx <= n) {
				s.add(idx++);
				sb.append("+\n");
			}

			if (s.peek() == n) {
				s.pop();
				sb.append("-\n");
				result = true;
			}
			if (!result)
				break;
			cnt++;
		}

		if (result) {

			bw.write(sb.toString());

		} else {
			sb.delete(0, sb.length());
			sb.append("NO");
			bw.write(sb.toString());
		}
		br.close();
		bw.close();

	}

}
