//큐
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Boj18258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> q = new LinkedList<Integer>();

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N > 0) {
			String[] S = br.readLine().split(" ");
			if (S[0].equals("push")) {
				int n = Integer.parseInt(S[1]);
				q.add(n);

			} else if (S[0].equals("pop")) {
				if (!q.isEmpty()) {
					sb.append(q.poll() + "\n");
				} else {
					sb.append(-1 + "\n");
				}

			} else if (S[0].equals("empty")) {
				if (!q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(1 + "\n");
				}

			} else if (S[0].equals("size")) {
				sb.append(q.size() + "\n");

			} else if (S[0].equals("front")) {
				if (!q.isEmpty()) {
					sb.append(q.peekFirst() + "\n");
				} else {
					sb.append(-1 + "\n");
				}

			} else if (S[0].equals("back")) {
				if (!q.isEmpty()) {
					sb.append(q.peekLast() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
			}
			N--;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
