package algo8;


//2565 전깃줄
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2565 { // 클래스명

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성
		
		int N = Integer.parseInt(br.readLine()); // 전기줄의 갯수
		int arr[] = new int[N];
		int max[] = new int[N];
		int result = 0;
		Arrays.fill(max, 1);
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
		});
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new Point(x, y));
		}
		int idx = 0;
		while(!q.isEmpty())
		{
			Point first = q.poll();
			arr[idx++] = first.x;
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					max[i] = Math.max(max[i], max[j]+1);
				}
			}
			result = Math.max(result, max[i]);
		}
		
		bw.write((N-result) + "");
		bw.close(); // 출력 종료
		
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
