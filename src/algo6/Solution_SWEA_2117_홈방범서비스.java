package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_2117_홈방범서비스 {
	static int N;
	static int M, result;

	static int board[][];
	static boolean boardChk[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static class Safe {
		int x;
		int y;
		int d;

		public Safe() {
			super();
		}

		public Safe(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());

			M = Integer.parseInt(st.nextToken());

			board = new int[N + 1][N + 1];
			boardChk = new boolean[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j < N + 1; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			for(int i = 1; i<N+1;i++) {
				for(int j = 1; j<N+1; j++) {
					for(int k = 1; k<=N+1; k++) {
						bfs(i, j, k);
					}
				}
			}

			sb.append("#" + (Tcnt++) + " " + result + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void bfs(int n, int m, int k) {
		int cnt = 0;
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(boardChk[i], false);
		}
		Queue<Safe> q = new LinkedList<>();
		q.add(new Safe(n, m, 1));
		if(board[n][m] > 0) cnt++;
		boardChk[n][m] = true;
		
		while(!q.isEmpty()) {
			Safe first = q.poll();
			int x = first.x;
			int y = first.y;
			int d = first.d;
			
			for(int i = 0; i<4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				int md = d + 1;				

				if(mx < 1 || my < 1 || mx > N || my > N) continue;
				if(boardChk[mx][my]) continue;
				if(md > k) continue;
				q.add(new Safe(mx, my, md));
				boardChk[mx][my] = true;
				if(board[mx][my] > 0) cnt++;
				
			}
			
		}
		int income = cnt * M;
		int outcome = k*k +(k-1)*(k-1);
		if(income >= outcome) result = Math.max(cnt, result); 

	}
}