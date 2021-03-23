package algo11;

// 2610 회의 준비
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int person[] = new int[N + 1];
		int pt[] = new int[N + 1];
		int board[][] = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(board[i], Integer.MAX_VALUE / 2);
			board[i][i] = 0;
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			board[a][b] = 1;
			board[b][a] = 1;
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}

				}
			}
		}
		int idx = 0;
		for (int i = 1; i < N + 1; i++) {
			boolean chk = true;
			if (person[i] != 0)
				chk = false;
			else
				person[i] = idx + 1;

			int sum = 0;
			for (int j = 1; j < N + 1; j++) {
				if (board[i][j] == Integer.MAX_VALUE / 2)
					continue;
				sum = Math.max(board[i][j], sum);
				if (chk) {
					person[j] = idx + 1;
				}
			}
			pt[i] = sum;
			if (chk)
				idx++;
		}
		int group[] = new int[idx + 1];
		int top[] = new int[idx + 1];
		Arrays.fill(group, Integer.MAX_VALUE);

		for (int i = 1; i < N + 1; i++) {
			if (group[person[i]] > pt[i]) {
				top[person[i]] = i;
				group[person[i]] = pt[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(idx + "\n");
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i < idx + 1; i++) {
			arr.add(top[i]);
		}
		Collections.sort(arr);
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			sb.append(arr.get(i) + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}