package algo11;

// 2568 전깃줄-2
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2568 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int LIS[] = new int[N];
		int idx[] = new int[N];
		int p[] = new int[N];
		Arrays.fill(p, -1);
		boolean chk[] = new boolean[N];
		ArrayList<Point> arr = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Point(x, y));
		}
		
		Collections.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
		});
		
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int point = Arrays.binarySearch(LIS, 0, size, arr.get(i).y);
			point = Math.abs(point) - 1;
			LIS[point] = arr.get(i).y;
			idx[point] = i;
			p[i] = (point == 0)? i : idx[point-1];
			if (point == size) {
				size++;
			}

		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((N-size)+ "\n");
		int ad = idx[size -1 ];
		
		while(true) {
			chk[ad] = true;
			int next = p[ad];
			if(next == ad) break;
			ad = next;
		}
		
		for(int i = 0; i<N; i++) {
			if(chk[i]) continue;
			sb.append(arr.get(i).x+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();

	}

}
