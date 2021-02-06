// 회전하는 큐

package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			q.add(i);

		}
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		while (M-- > 0) {
			int pick = Integer.parseInt(st.nextToken());
			int size = q.size();
			int cnt = 0;
			while (!q.isEmpty()) {
				int a = q.poll();

				if (a != pick) {
					q.add(a);
					cnt++;
				} else
					break;

			}
			sum += Math.min(cnt, size - cnt);

		}

		bw.write(String.valueOf(sum));
		bw.close();
		br.close();

	}

}
