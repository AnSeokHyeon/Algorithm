package algo12;

// 2623 음악프로그램

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int num[] = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer> arr[] = new ArrayList[N+1];
		for(int i = 1; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		while(M--  > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int order = Integer.parseInt(st.nextToken())-1;
			int a = Integer.parseInt(st.nextToken());
			while(order-- > 0) {
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				num[b]++;
				a = b;
			}
			
		}
		Queue<Integer> q = new LinkedList<Integer>();
		ArrayList<Integer> number = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i= 1; i<N+1; i++) {
			if(num[i] > 0) continue;
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			Integer now = q.poll();
			number.add(now);
			int size = arr[now].size();
			for(int i = 0; i<size; i++) {
				int next = arr[now].get(i);
				num[next]--;
				if(num[next] == 0) {
					q.add(next);
				}
			}
		}
		
		int size = number.size();
		if(size == N) {
			for(int i = 0; i<size; i++) {
				sb.append(number.get(i)+"\n");
			}
		}
		else {
			sb.append("0");
		}
		
		bw.write(sb.toString());	
		bw.close();
		br.close();

	}
}