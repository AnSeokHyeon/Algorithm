package algo10;

// 4195 친구 네트워크
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {

	static int parent[];
	static int size[];

	static int findSet(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findSet(parent[a]);
	}

	static int unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return Math.max(size[aRoot], size[bRoot]);
		if (aRoot > bRoot) {
			parent[bRoot] = aRoot;
			size[aRoot] += size[bRoot];
		} else {
			parent[aRoot] = bRoot;
			size[bRoot] += size[aRoot];
		}
		return Math.max(size[aRoot], size[bRoot]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			parent = new int[200001];
			size = new int[200001];
			HashMap<String, Integer> map = new HashMap<>();
			Arrays.fill(size, 1);
			for (int i = 0; i < 200001; i++) {
				parent[i] = i;
			}
			int M = Integer.parseInt(br.readLine());
			int index = 0;
			while (M-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String first = st.nextToken();
				String second = st.nextToken();

				int a = 0;
				int b = 0;
				
				if(!map.containsKey(first)) map.put(first, index++);
				if(!map.containsKey(second))map.put(second, index++);
				
				a = map.get(first);
				b = map.get(second);
				sb.append(unionSet(a, b)+ "\n");
			} // while문
			
		}
		bw.write(sb.toString());

		br.close();
		bw.close();
	}

}