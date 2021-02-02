
// ABCDE

package algo3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Boj13023 {
	static int N, M;
	static boolean result;
	static ArrayList<Integer>[] map;
	static boolean[] chk;

	static void dfs(int n, int d) {
		if (d == 4) {
			result = true;
			return;
		}
		chk[n] = true;

		for (int i = 0; i < map[n].size(); i++) {
			if(chk[map[n].get(i)]) continue;
			System.out.println(n + " " + i + " " +map[n].get(i));
			dfs(map[n].get(i), d+1);

		}
		chk[n] = false;
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new ArrayList[N];
		for(int i = 0; i<N;i++) {
			map[i] = new ArrayList<>();
		}
		result = false;
		for (int i = 0; i < M; i++) {
			String[] input2 = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]);
			int b = Integer.parseInt(input2[1]);
			map[a].add(b);
			map[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			chk = new boolean[N];
			chk[i] = true;
			dfs(i, 0);
			if (result)
				break;
		}
		if (result)
			bw.write("1");

		else
			bw.write("0");
		br.close();
		bw.close();

	}

}
