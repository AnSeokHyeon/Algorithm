package algo12;

// 3665 최종순위

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3665 {
	static int parent[];

	static int findSet(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findSet(parent[a]);
	}

	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		if (aRoot > bRoot)
			parent[bRoot] = aRoot;
		else
			parent[aRoot] = bRoot;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {

			int N = Integer.parseInt(br.readLine());

			int num[] = new int[N + 1];
			int rank[] = new int[N + 1];
			boolean chk[] = new boolean[N + 1];

			@SuppressWarnings("unchecked")
			ArrayList<Integer> arr[] = new ArrayList[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N + 1; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList<>();
			}

			for (int i = 1; i < N; i++) {
				int a = rank[i];
				for (int j = i + 1; j < N + 1; j++) {
					int b = rank[j];
					arr[a].add(b);
					num[b]++;
				}
			}

			int M = Integer.parseInt(br.readLine());
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int pt = arr[b].indexOf(a);
				int pt2 = arr[a].indexOf(b);
				if (pt > -1) {
					arr[b].remove(pt);
					arr[a].add(b);
					num[a]--;
					num[b]++;

				}
				if (pt2 > -1) {
					arr[a].remove(pt2);
					arr[b].add(a);
					num[b]--;
					num[a]++;

				}

			}
			boolean resultChk = true;
			ArrayList<Integer> result = new ArrayList<>();
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i < N + 1; i++) {
				if (num[i] > 0) {
					if (chk[num[i]]) {
						resultChk = false;
					} else {
						chk[num[i]] = true;
					}
				} else {
					q.add(i);

				}
			}

			while (!q.isEmpty()) {
				Integer now = q.poll();
				result.add(now);
				int size = arr[now].size();

				for (int i = 0; i < size; i++) {
					int next = arr[now].get(i);
					num[next]--;
					if (num[next] == 0) {
						q.add(next);
					}
				}

			}
			if (resultChk) {
				int size = result.size();
				for (int i = 0; i < size; i++) {
					sb.append(result.get(i) + " ");
				}
				sb.append("\n");
			} else {

				sb.append("IMPOSSIBLE\n");

			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}