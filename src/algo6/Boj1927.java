// 최소 힙
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Boj1927 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {

				if (!q.isEmpty()) {
					sb.append(q.poll() + "\n");

				} else {
					sb.append(0 + "\n");
				}
			} else {
				q.add(num);

			}

		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}