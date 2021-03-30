package algo12;

// 1766 문제집

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		int num[] = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) {
			arr[i]= new ArrayList<>();
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			num[b]++;
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 1; i<N+1; i++) {
			if(num[i] > 0) continue;
			q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			Integer now = q.poll();
			sb.append(now + " ");
			int size = arr[now].size();
			for(int i = 0; i<size; i++) {
				int next= arr[now].get(i);
				num[next]--;
				if(num[next] == 0) q.add(next);
				
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();

	}
}