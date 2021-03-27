package algo11;

//10816 숫자 카드2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		boolean chk[] = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, Integer> arr = new HashMap<>();
		while (M-- > 0) {
			int searchNum = Integer.parseInt(st.nextToken());

			int Point = Arrays.binarySearch(num, 0, N, searchNum);
			if (Point < 0) {
				sb.append("0 ");
			} 
			else {
				if(!arr.containsKey(searchNum)) {
					q.add(Point);
					chk[Point] = true;
					int cnt = 1;
					while (!q.isEmpty()) {
						Integer next = q.poll();

						if (next - 1 > -1 && num[next - 1] == searchNum && !chk[next - 1]) {
							cnt++;
							q.add(next - 1);
							chk[next - 1] = true;
						}

						if (next + 1 < N && num[next + 1] == searchNum && !chk[next + 1]) {
							cnt++;
							q.add(next + 1);
							chk[next + 1] = true;
						}

					}
					sb.append(cnt + " ");
					arr.put(searchNum, cnt);
					
				}
				else {

					sb.append(arr.get(searchNum) + " ");
				}
				
				
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}