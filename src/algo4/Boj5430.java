package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String S = br.readLine();
			boolean result = true;
			Deque<Integer> dq = new LinkedList<Integer>();
			// 함수 입력 받는 코드

			int size = S.length();
			char[] p = new char[size];
			for (int i = 0; i < size; i++) {
				p[i] = S.charAt(i);
			}
			// 배열 크기 입력 받는 함수 & 입력 받기
			int N = Integer.parseInt(br.readLine());
			S = br.readLine();
			S = S.replace("[", "").replace(",", " ").replace("]", "");
			StringTokenizer st = new StringTokenizer(S, " ");
			for (int i = 0; i < N; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = 0;
			int cntR = 0;
			while (cnt < size) {
				if (p[cnt] == 'D') {
					if (dq.isEmpty()) {
						result = false;
					} else {
						if (cntR % 2 == 0) {

							dq.poll();

						} else {
							dq.pollLast();
						}
					}
				} else {
					cntR++;
				}

				if (!result)
					break;
				cnt++;

			}
			if (result) {
				sb.append("[");

				while (!dq.isEmpty()) {
					if (cntR % 2 == 0) {

						sb.append(dq.poll());
					} else {
						sb.append(dq.pollLast());
					}
					if (dq.isEmpty())
						break;
					sb.append(",");
				}
				sb.append("]\n");

			} else {
				sb.append("error\n");

			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
