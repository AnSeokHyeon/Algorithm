// 바이러스
package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606 {
	static int board[][];
	static boolean chk[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new int[N + 1][N + 1];
		chk = new boolean[N + 1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = board[b][a] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		int start = 1;
		q.add(start);
		chk[start] = true;
		int result = 0;
		while (!q.isEmpty()) {
			Integer top = q.poll();
			for (int i = 1; i <= N; i++) {
				if (board[top][i] == 0 || chk[i])
					continue;
				q.add(i);
				chk[i] = true;
				result++;

			}
		}
		bw.write(result + "");
		br.close();
		bw.close();
	}

}