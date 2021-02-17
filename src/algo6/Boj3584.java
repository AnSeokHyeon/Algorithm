
// 3584. 가장 가까운 공통 조상

package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3584 {
	static int p[];
	static boolean chk[];
	static int N, result, A, B;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while (T-- > 0) {

			N = Integer.parseInt(br.readLine());
			chk = new boolean[N + 1]; // 노드 체크
			p = new int[N + 1]; // 자식노드가 인덱스이고 배열값이 부모노드
			result = 0;

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				p[b] = a;
			}

			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			if (A == B) { //노드가 같을 경우 굳이 탐색할 필요 x
				sb.append(A + "\n");
			} else {
				bfs(A, B);
			}

		}
		bw.write(sb.toString());

		bw.close();
		br.close();
	}

	static void bfs(int n, int m) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(m);
		q.add(n);
		chk[n] = true;
		chk[m] = true;
		while (!q.isEmpty()) {
			Integer cnum = q.poll();

			int pnum = p[cnum];
			if (pnum == 0)
				continue;
			if (chk[pnum]) {
				result = pnum;
				sb.append(result + "\n");
				break;
			}

			chk[pnum] = true;
			q.add(pnum);

		}

	}

}
