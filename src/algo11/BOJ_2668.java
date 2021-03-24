package algo11;

// 2668 숫자 고르기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2668 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int next[] = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> set = new ArrayList<>();
		
		for (int i = 1; i < N + 1; i++) {
			boolean chk[] = new boolean[N + 1];
			
			q.clear();
			q.add(i);
			
			while (!q.isEmpty()) {
				Integer now = q.poll();

				int nextN = next[now];
				if (chk[nextN])	continue;
				
				chk[nextN] = true;
				q.add(nextN);
				
				if (nextN == i) {
					set.add(i);
					break;
				}

			}

		}

		int size = set.size();
		sb.append(size + "\n");
		for (int i = 0; i < set.size(); i++) {
			sb.append(set.get(i) + "\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}