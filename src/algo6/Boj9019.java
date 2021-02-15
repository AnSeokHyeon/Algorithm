// 9019 DSLR
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9019 {
	static boolean chk[];
	static int pre[];
	static char reg[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		chk = new boolean[10000];
		pre = new int[10000];
		reg = new char[10000];

		StringBuilder sb = new StringBuilder();
		ArrayList<Character> arr = new ArrayList<>();
		Queue<Integer> q = new LinkedList<Integer>();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(chk, false);
			Arrays.fill(pre, 0);
			Arrays.fill(reg, ' ');
			arr.clear();
			q.clear();

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			q.add(N);

			chk[N] = true;

			while (!q.isEmpty()) {
				Integer num = q.poll();

				int n = num;
				if (num == M) {
					break;
				}
				int d1 = n / 1000;
				n = n % 1000;
				int d2 = n / 100;
				n = n % 100;
				int d3 = n / 10;
				int d4 = n % 10;

				for (int i = 0; i < 4; i++) {
					int nextnum = 0;
					char c = ' ';
					if (i == 0) {
						nextnum = num * 2;
						if (nextnum > 9999)
							nextnum = nextnum % 10000;
						c = 'D';
					} else if (i == 1) {
						if (num == 0) {
							nextnum = 9999;
						} else {
							nextnum = num - 1;
						}
						c = 'S';
					} else if (i == 2) {
						nextnum = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
						c = 'L';
					} else if (i == 3) {
						nextnum = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
						c = 'R';

					}

					if (nextnum > 9999 || nextnum < 0)
						continue;
					if (chk[nextnum])
						continue;
					chk[nextnum] = true;
					pre[nextnum] = num;

					reg[nextnum] = c;
					q.add(nextnum);

				}

			}
			int start = M;
			while (true) {
				arr.add(reg[start]);
				int previous = pre[start];
				start = previous;
				if (start == N)
					break;
			}
			int len = arr.size();
			for (int i = len - 1; i > -1; i--) {
				sb.append(arr.get(i));
			}
			sb.append("\n");

		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}