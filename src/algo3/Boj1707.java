// 이분 그래프
package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1707 {
	static int N, M;
	static boolean result;
	static ArrayList<Integer>[] map;
	static int[] chk;

	static void bfs(int num) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		chk[num] = 1;

		while (!q.isEmpty()) {
			int n = q.poll();
			int size = map[n].size();
			for (int i = 0; i < size; i++) {
				int next = map[n].get(i);
				
				if (chk[next] == 0) {
					q.add(next);
					chk[next] = chk[n] + 1;
					if (chk[next] > 2)
						chk[next] = 1;
				} else if (chk[next] == chk[n]) {
					result = false;
				}

			}

			if (!result)
				break;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			map = new ArrayList[N + 1];
			chk = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				map[i] = new ArrayList<>();
			}
			result = true;
			for (int i = 0; i < M; i++) {
				String[] input2 = br.readLine().split(" ");
				int a = Integer.parseInt(input2[0]);
				int b = Integer.parseInt(input2[1]);
				map[a].add(b);
				map[b].add(a);
			}
			for (int i = 1; i <= N; i++) {
				if (chk[i] > 0)
					continue;
				bfs(i);
				if(!result) break;
			}
			if (result)
				bw.write("YES\n");

			else
				bw.write("NO\n");
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
