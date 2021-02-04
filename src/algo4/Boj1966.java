package algo4;
// 프린터 큐

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] size; // 중요도 갯수 체크를 위한 배열
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int now = 0; // 현재 제일 높은 중요도 저장
			int result = 0; // 중요도가 같은걸 만날때마다 증가

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Point> q = new LinkedList<>();
			// Point 클래스 Point(int x, int y)

			String[] s = br.readLine().split(" ");
			size = new int[10];

			for (int i = 0; i < N; i++) {
				int n = s[i].charAt(0) - '0';
				size[n]++;
				q.add(new Point(i, n));
			}
			// 위에 for문에 if(n > now) now = n;으로 now를 체크 할수 있었지만 연산이 늘어날거 같아서 따로 FOR문 생성
			for (int i = 9; i > 0; i--) {
				if (size[i] == 0)
					continue;
				now = i;
				break;
			}

			boolean chk = false;
			while (!q.isEmpty()) {
				Point a = q.poll();

				int x = a.x;
				int y = a.y;

				// 현재 제일 높은 중요도보다 낮으면 다시 큐에 add
				if (now > y) {
					q.add(new Point(x, y));
				}

				else {
					result++; // now와 같으므로 하나 출력 되었다고 가정
					size[y]--; // 고로 now == y 이므로 중요도 y의 사이즈 축소
					if (x == M) {
						chk = true;
					}
					if (size[y] == 0) {
						for (int i = y - 1; i > 0; i--) {
							if (size[i] == 0)
								continue;
							now = i;
							break;

						}
					}

				}
				if (chk)
					break;

			}
			sb.append(result + "\n");
		}
		bw.write(sb.toString());

		bw.close();
		br.close();

	}

}
