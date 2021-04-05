package algo13;

//1325 효율적인 해킹
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean chk[] = new boolean[N+1];
		int size[] = new int[N+1];
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[b].add(a);
		}

		int result = 0;
		for(int i = 1;i <N+1; i++) {
			Arrays.fill(chk, false);

			q.add(i);
			chk[i] = true;
			size[i] = 1;
			
			while(!q.isEmpty()) {
				Integer now = q.poll();
				int arrSize = arr[now].size();
				for(int k = 0; k<arrSize; k++) {
					int next = arr[now].get(k);
					if(chk[next]) continue;
					size[i]++;
					chk[next] = true;
					q.add(next);
				}
			}

			result = Math.max(result, size[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<N+1; i++) {
			if(result == size[i]) sb.append(i + " ");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}


}