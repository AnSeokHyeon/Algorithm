package algo11;

// 2252 줄 세우기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> c[] = new ArrayList[N+1];
		for(int i= 1; i<N+1; i++) {
			c[i] = new ArrayList<>();
		}
		int chk[] = new int[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			c[parent].add(child);
			chk[child]++;
		}
		
		for(int i = 1; i<N+1; i++) {
			if(chk[i] > 0) continue;
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			Integer num = q.poll();
			
			sb.append(num + " ");
			int size = c[num].size();
			
			for(int i = 0 ;i<size; i++) {
				chk[c[num].get(i)]--;
				if(chk[c[num].get(i)] == 0) {
					q.add(c[num].get(i));
				}
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}