package algo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj6064 {
	static int N, M, x, y;
	static long size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			size = N * M;
			int A, B;
			if (M > N) {
				A = N;
				B = M;
			} else {
				A = M;
				B = N;
			}
			while (B != 0) {
				int r = A % B;
				A = B;
				B = r;
			}
			if (N == y)
				y = 0;
			if (M == x)
				x = 0;

			size = size / A;
			int cnt = 0;
			int num = 0;
			boolean chk = false;
			while (num <= size) {
				num = x + M * cnt;
				if (num > 0 && num % N == y) {
					chk = true;
					break;
				}

				cnt++;
			}
			if (chk) {
				bw.write(num + "\n");
			} else {
				bw.write(-1 + "\n");
			}

		}

		br.close();
		bw.close();
	}
}