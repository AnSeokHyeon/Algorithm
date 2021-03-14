package algo9;

// 2477. [모의 SW 역량테스트] 차량 정비소
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477_차량정비소 { // 클래스명

	static class Customer {
		int idx;
		int at;
		int ast;
		int aet;
		int bst;
		int bet;
		int an;
		int bn;

		public Customer(int idx, int at, int ast, int aet, int bst, int bet, int an, int bn) {
			super();
			this.idx = idx;
			this.at = at;
			this.ast = ast;
			this.aet = aet;
			this.bst = bst;
			this.bet = bet;
			this.an = an;
			this.bn = bn;
		}
	}

	public static void main(String[] args) throws IOException { // 메인함수 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		int T = Integer.parseInt(br.readLine());
		int Tcnt = 1;
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Customer> person = new ArrayList<>();
			Queue<Customer> await = new LinkedList<Solution_2477_차량정비소.Customer>();
			PriorityQueue<Customer> bwait = new PriorityQueue<>(new Comparator<Customer>() {

				@Override
				public int compare(Customer o1, Customer o2) {
					// TODO Auto-generated method stub
					if (o1.aet == o2.aet) {
						return o1.an - o2.an;
					}
					return o1.aet - o2.aet;
				}
			});
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int a[] = new int[N + 1]; // a 창구
			int b[] = new int[M + 1]; // b 창구
			int atime[] = new int[N + 1]; // a 창구 소요시간
			int btime[] = new int[M + 1]; // b 창구 소요시간

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				atime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				btime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= K; i++) {
				int arrivalTime = Integer.parseInt(st.nextToken());
				person.add(new Customer(i, arrivalTime, 0, 0, 0, 0, 0, 0));
				await.add(person.get(i-1));
			}
			int cnt = 0;
			int time = 0;
			while(cnt < K ) {
				// 먼저 창구 체크
				for(int i = 1; i<=N; i++) {
					if(a[i] == 0) continue;
					if(person.get(a[i]-1).aet == time) {
						//System.out.println((a[i] -1)+"님의 접수가 종료 되었습니다.");
						bwait.add(person.get(a[i]-1));
						a[i] = 0;

					}
				}
				
				// 창구에 손님 넣기
				for(int i = 1; i<=N; i++) {
					if(a[i] != 0) continue;
					if(await.isEmpty()) break;
					if(await.peek().at > time) break;
					Customer customer = await.poll();
					person.get(customer.idx-1).an = i;
					person.get(customer.idx-1).ast = time;
					person.get(customer.idx-1).aet = time + atime[i];
					a[i] = customer.idx;
					//System.out.println((a[i] -1)+"님의 접수가 시작 되었습니다.");
				}
				
				// 정비 창구 체크
				for(int i = 1; i<=M; i++) {
					if(b[i] == 0) continue;
					if(person.get(b[i]-1).bet == time) {
						//System.out.println((b[i] -1)+"님의 정비가 종료 되었습니다.");
						b[i] = 0;
						cnt++;
					}
				}
				// 정비 창구에 손님 넣기
				for(int i = 1; i<=M; i++) {
					if(b[i] != 0) continue;
					if(bwait.isEmpty()) break;
					if(bwait.peek().aet > time) break;
					Customer customer = bwait.poll();
					person.get(customer.idx-1).bn = i;
					person.get(customer.idx-1).bst = time;
					person.get(customer.idx-1).bet = time + btime[i];
					b[i] = customer.idx;
					//System.out.println((b[i] -1)+"님의 접수가 시작 되었습니다.");
				}
				/*System.out.println(time + "시간 창구 결과 ***************");
				for(int i = 1; i<=N; i++) {
					System.out.print(i + " ");
				}
				System.out.print("     ");
				for(int i = 1; i<=M; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
				for(int i = 1; i<=N; i++) {
					System.out.print(a[i] + " ");
				}
				System.out.print("     ");
				for(int i = 1; i<=M; i++) {
					System.out.print(b[i] + " ");
				}
				System.out.println();*/
				
				time++;
			}
			int result = 0;
			for(int i = 0; i<person.size(); i++) {
				if(person.get(i).an == A && person.get(i).bn == B) {
					
					result += person.get(i).idx;
					
				}
				
			}
			
			if(result == 0) result = -1;

			sb.append("#" + (Tcnt++) + " " + result + "\n");

		}
		bw.write(sb.toString());
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료

}// 프로그램 엔드
