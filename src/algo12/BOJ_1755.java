package algo12;
// 1755 숫자놀이 
import java.io.BufferedReader; // 입력을 위한  import
import java.io.InputStreamReader; // 입력을 위한  import
import java.io.BufferedWriter; // 출력을 위한 import
import java.io.OutputStreamWriter; // 출력을 위한 import
import java.io.IOException; // 입출력 예외처리 import
import java.util.Comparator; // 우선순위큐 비교기 사용을 위해 import
import java.util.HashMap; // 숫자와 문자를 매칭시키기 위해 map을 사용
import java.util.PriorityQueue; // 우선순위 출력을 위해 우선순위 큐사용
import java.util.StringTokenizer; // 쪼개셔 입력 받기 위해 사용

public class BOJ_1755 { //클래스명
	
	static HashMap<Integer, String> number = new HashMap<>(); // 0 : zero / 1 : one  으로 매칭 시키기 위해 맵 사용
	static class English{ // 숫자와 영어단어를 큐에 넣기 위해   English 클래스 선언
		int num; // 숫자
		String eng; // 영어
		public English(int num, String eng) { // 생성자 
			this.num = num; 
			this.eng = eng;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		init(); // 먼저 맵에 다 넣고 시작
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백을 기준으로 짤라서 토큰화 
		
		int M = Integer.parseInt(st.nextToken()); // M 입력
		int N = Integer.parseInt(st.nextToken()); // N 입력
		
		PriorityQueue<English> q= new PriorityQueue<>(new Comparator<English>() { // 문자열을 비교해 정렬후 출력하기 위해 사용
			@Override
			public int compare(English o1, English o2) {
				// TODO Auto-generated method stub
				return o1.eng.compareTo(o2.eng); // 영어단어끼리 비교하여 우선순위를 정함
			}
		});
		
		
		for(int i = M; i<=N; i++) {
			String S = "";
			int first = i / 10; //최대 99까지 이기때문에 10의 자리를 담음
			int second = i % 10; // 1 의 자리를 담음
			if(first> 0) { // first가 0이면 zero를 넣으면 안되므로
				S += number.get(first) + " "; // first 에 대응되는 영어단어를 찾아서 S에 넣는다.
				 
			}
			S += number.get(second); // 1의 자리 숫자에 대응되는 영어단어를 찾아서  S에 더한다.
			q.add(new English(i, S)); // 큐에 넣는다.
		}
		
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(!q.isEmpty()) {
			sb.append(q.poll().num + " ");
			cnt++;
			if(cnt % 10 == 0) sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		
		bw.close();
	}
	private static void init() { // 0~9까지 대응 되는 영어를  map 에 담아 두었다.
		number.put(0, "zero");
		number.put(1, "one");
		number.put(2, "two");
		number.put(3, "three");
		number.put(4, "four");
		number.put(5, "five");
		number.put(6, "six");
		number.put(7, "seven");
		number.put(8, "eight");
		number.put(9, "nine");
	}
}
