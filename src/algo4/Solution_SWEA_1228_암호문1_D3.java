package algo4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 1; 
		StringBuilder sb = new StringBuilder();
		while(T<11) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreElements()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			int L = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i<L;i++) {
				char c = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int idx = n + m;
				
				while(n < idx) {
					arr.add(n++, Integer.parseInt(st.nextToken()));
					
				}
				
				
			}
			sb.append("#").append(T++).append(" ");
			for(int i= 0; i<10; i++) {
				sb.append(arr.get(i) + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
