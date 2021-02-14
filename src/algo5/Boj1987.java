

// 알파벳
package algo5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1987 {
	static char[][] board;
	static boolean[][] boardChk;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int R, C, result;
	static boolean alpha[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R + 1][C + 1];
		boardChk = new boolean[R + 1][C + 1];
		alpha = new boolean[26];
		for (int i = 1; i < R + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < C + 1; j++) {
				board[i][j] = s.charAt(j - 1);
			}
		}

		result = 1;
		alpha[board[1][1] - 'A'] = true;
		boardChk[1][1] = true;
		bfs(1, 1, result);
		bw.write(result + "");
		br.close();
		bw.close();
	}

	static void bfs(int x, int y, int cnt) {
		result = Math.max(result, cnt);
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx < 1 || my < 1 || mx > R || my > C)
				continue;
			int num = board[mx][my] - 'A';
			if (alpha[num])
				continue;
			if (boardChk[mx][my])
				continue;
			alpha[num] = true;
			boardChk[mx][my] = true;
			bfs(mx, my, cnt + 1);
			alpha[num] = false;
			boardChk[mx][my] = false;

		}

	}

}