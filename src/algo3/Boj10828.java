// 스택
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		while (N > 0) {
			String[] S = br.readLine().split(" ");
			if (S[0].equals("push")) {
				int n = Integer.parseInt(S[1]);
				s.push(n);
			} else if (S[0].equals("top")) {
				if (!s.isEmpty())
					System.out.println(s.peek());
				else
					System.out.println(-1);
			} else if (S[0].equals("empty")) {
				if (s.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");

			} else if (S[0].equals("size")) {
				System.out.println(s.size());
			} else if (S[0].equals("pop")) {
				if (!s.isEmpty()) {
					System.out.println(s.peek());
					s.pop();

				} else
					System.out.println(-1);

			}
			N--;

		}
		br.close();
		bw.close();

	}
}
