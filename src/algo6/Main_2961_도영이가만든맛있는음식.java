// 도영이가 만든 맛있는 음식
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	static int N, result;
	static int[] S;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		result = 987654312;
		for (int i = 1; i < N + 1; i++) {
			cooking(0, 0, i, 0, 1, 0);
		}
		bw.write(result + "");
		br.close();
		bw.close();

	}

	static void cooking(int n, int now, int m, int flag, int ssum, int bsum) {
		if (n == m) {
			int gap = Math.abs(ssum - bsum);
			result = Math.min(gap, result);
			return;
		}

		for (int i = now; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			cooking(n + 1, i + 1, m, flag | 1 << i, ssum * S[i], bsum + B[i]);

		}
	}

}