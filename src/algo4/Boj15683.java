// 감시
package algo4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15683 {
	static char map[][];
	static int N, M, result;
	static int pick[];
	static ArrayList<CCTV> cctv;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static class CCTV {
		int x;
		int y;
		int v;

		public CCTV() {
			super();
		}

		public CCTV(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

	}

	static void dfs(int n) {
		if (n == cctv.size()) {
			cal();
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cctv.get(n).v == 2 && i > 1)
				continue;
			if (cctv.get(n).v == 5 && i > 0)
				continue;
			pick[n] = i;
			dfs(n + 1);

		}

	}

	static void cal() {
		char copy[][] = new char[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, map[i].length);

		}
		boolean dchk[];
		for (int i = 0; i < cctv.size(); i++) {
			dchk = new boolean[4];
			int x = cctv.get(i).x;
			int y = cctv.get(i).y;
			int v = cctv.get(i).v;
			int d = pick[i];
			dchk[d] = true;
			if (v == 2) {
				dchk[(d + 2) % 4] = true;
			} else if (v == 3) {
				dchk[(d + 1) % 4] = true;
			} else if (v == 4) {
				dchk[(d + 1) % 4] = true;
				dchk[(d + 2) % 4] = true;

			} else if (v == 5) {
				dchk[(d + 1) % 4] = true;
				dchk[(d + 2) % 4] = true;
				dchk[(d + 3) % 4] = true;

			}
			for (int j = 0; j < 4; j++) {
				if (!dchk[j])
					continue;
				int num = 1;

				while (true) {
					int mx = x + dx[j] * num;
					int my = y + dy[j] * num;

					if (mx < 1 || my < 1 || mx > N || my > M)
						break;
					if (map[mx][my] == '6')
						break;
					num++;
					if (map[mx][my] == '0')
						copy[mx][my] = '#';

				}
			}

		}
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {

			for (int j = 1; j < M + 1; j++) {
				if (copy[i][j] == '0')
					cnt++;
			}

		}
		if (result > cnt)
			result = cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N + 1][M + 1];
		cctv = new ArrayList<>();
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < M + 1; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] != '0' && map[i][j] != '6') {
					cctv.add(new CCTV(i, j, map[i][j] - '0'));

				}
			}

		}
		pick = new int[cctv.size()];
		result = 987654312;
		dfs(0);
		bw.write(result + "");
		br.close();
		bw.close();
	}

}
