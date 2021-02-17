// Main_정올_1828_냉장고_안석현.java

package algo6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_안석현 {
	static class Material implements Comparable<Material> {
		int low;
		int high;

		public Material(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Material o) {
			// TODO Auto-generated method stub
			int diff = this.high - o.high;
			return diff != 0 ? diff : this.low - o.low;
		}

		@Override
		public String toString() {
			return "Material [low=" + low + ", high=" + high + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Material[] m = new Material[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m[i] = new Material(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(m);

		int temperatirue = m[0].high;
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			if (temperatirue < m[i].low) {
				cnt++;
				temperatirue = m[i].high;
			}
		}

		bw.write(cnt + "");
		bw.close();
		br.close();
	}

}
