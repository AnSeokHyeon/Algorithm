package algo9;

// 5014 스타트링크
import java.awt.Point;
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int df[] = new int[2];
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		df[0] = Integer.parseInt(st.nextToken());
		df[1] = Integer.parseInt(st.nextToken())*(-1);
		
		int cnt[] = new int[F+1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y - o2.y;
			}
			
		});
		q.add(new Point(S,0));
		cnt[S] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int now = p.x;
			int btn = p.y;
			
			for(int i = 0; i<2; i++) {
				int next = now + df[i];
				int nextBtn = btn + 1;
				if(next < 1 || next > F) continue;
				if(cnt[next] <= nextBtn) continue;
				cnt[next] = nextBtn;
				q.add(new Point(next, nextBtn));
			}
		}
		
		if(cnt[G] == Integer.MAX_VALUE)
			bw.write("use the stairs");
		else
			bw.write(cnt[G]+"");
		
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 종료 ㅃㅇ
