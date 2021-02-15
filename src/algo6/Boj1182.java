
//  부분 수열의 합
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1182 {
	static int arr[];
	static int N, S, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			comb(i, 0, 0, 0);
		}
		bw.write(result + "");
		br.close();
		bw.close();

	}

	static void comb(int n, int m, int flag, int sum) {
		if (n == 0) {
			if (sum == S)
				result++;
			return;
		}

		for (int i = m; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			comb(n - 1, i + 1, flag | 1 << i, sum + arr[i]);
		}
	}
}