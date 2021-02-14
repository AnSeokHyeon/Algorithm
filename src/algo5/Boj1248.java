
// 맞춰봐
package algo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1248 {
	static int N;
	static boolean result;
	static int[] pick;
	static int[] tot;
	static String[] S;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		pick = new int[N];
		tot = new int[N];
		S = new String[N];
		int size = N * (N + 1) / 2;
		int num = N;
		int pt = 0;
		String s = br.readLine();
		while (pt < size) {
			S[N - num] = "";
			for (int i = pt; i < pt + num; i++) {
				S[N - num] += s.charAt(i);
			}
			pt = pt + num;
			num--;
		}

		dfs(0);

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	static void dfs(int n) {
		if (n == N) {
			for (int i = 0; i < N; i++) {
				sb.append(pick[i] + " ");

			}
			sb.append("\n");
			result = true;
			return;
		}

		for (int i = -10; i < 11; i++) {
			boolean chk = true;
			for (int j = 0; j < n + 1; j++) {
				int sum = tot[j] + i;
				if (((S[j].charAt(n - j) == '+' && sum <= 0)) || ((S[j].charAt(n - j) == '-' && sum >= 0))
						|| ((S[j].charAt(n - j) == '0' && sum != 0))) {
					chk = false;
					break;

				}
			}
			if (!chk)
				continue;

			pick[n] = i;
			for (int j = 0; j < n + 1; j++) {
				tot[j] += i;

			}
			dfs(n + 1);
			if (result)
				break;

			for (int j = 0; j < n + 1; j++) {
				tot[j] -= i;

			}

		}

	}

}