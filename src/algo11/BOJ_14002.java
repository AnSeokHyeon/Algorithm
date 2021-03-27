package algo11;

// 14002 가장 긴 증가하는 부분 수열4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;  i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int c[] = new int[N];
		int cIdx[] = new int[N];
		int p[] = new int[N];
		int size = 0;
		
		for(int i= 0; i<N; i++) {
			
			int point = Arrays.binarySearch(c, 0, size, num[i]);
			if(point >= 0) continue;
			
			point = Math.abs(point)-1;
			c[point] = num[i];
			cIdx[point] = i;
			p[i] = (point == 0)? i : cIdx[point-1];
			
			
			if(point == size) size++;
		}
		int key = cIdx[size-1];
		Deque<Integer> q = new LinkedList<>();
		while(true) {
			q.addFirst(num[key]);
			int nextKey = p[key];
			if(nextKey == key) break;
			key = nextKey;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(size+"\n");
		while(!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}