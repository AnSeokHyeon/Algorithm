// 브루트 포스 N과M 6
package algo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Boj15655 {
	static StringBuilder sb = new StringBuilder();
	static int N = 0;
	static int M = 0;
	static int[] num;
	static int[] pick;
	static boolean[] chk;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		num = new int[N];
		pick = new int[M];
		chk = new boolean[N];
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(num);
		f(0, 0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static void f(int n, int m) {
		if (M == m) {
			for (int i = 0; i < m; i++) {
				sb.append(pick[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = n; i < N; i++) {
			if (chk[i]) continue;
			pick[m] = num[i];
			chk[i] = true;
			f(i+1,m + 1);
			chk[i] = false;
		}

	}

}
