// 오큰수

package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>(); // 입력받은 수들을 뒤에서부터 꺼내보려고 스택에 담아보았습니다.
		Stack<Integer> max = new Stack<>(); // 입력받을때마다 max의 값을 스택에 담아보았습니다.

		StringTokenizer s = new StringTokenizer(br.readLine(), " ");

		while (s.hasMoreTokens()) {

			int n = Integer.parseInt(s.nextToken());
			st.add(n);
		}

		int p = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		while (st.size() > 0) {
			int now = st.peek();
			st.pop();
			if (now < p) {
				max.add(p);
				arr.add(p);
			} else if (!max.isEmpty() && now > p && now < max.peek()) {

				arr.add(max.peek());

			} else {
				boolean chk = false;
				while (!max.isEmpty()) {
					if (now >= max.peek()) {
						max.pop();
					} else {

						arr.add(max.peek());
						chk = true;
						break;

					}
				}

				if (!chk) {
					max.add(p);
					arr.add(-1);
				}

			}

			p = now;

		}

		StringBuilder sb = new StringBuilder();

		for (

				int i = arr.size(); i > 0; i--) {
			sb.append(arr.get(i - 1) + " ");
		}

		bw.write(sb.toString());

		bw.close();
		br.close();
	}

}
