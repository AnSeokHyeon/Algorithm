
// 2644 촌수계산
package algo6;

import java.awt.Point; // 노드 정보를 저장하기 위해 x에는 노드를 y에는 시작 노드와의 관계를 저장하기 위해 point를 사용하고자 임포트
import java.io.BufferedReader; //버퍼 입력을 위해 임포트
import java.io.BufferedWriter; //버펴 출력을 위해 임포트
import java.io.IOException; // 예외 처리를 위한 임포트
import java.io.InputStreamReader; // 입력을 위해 임포트
import java.io.OutputStreamWriter; // 출력을 위해 임포트
import java.util.LinkedList; // 연결리스트중 하나인 큐를 사용하기 위해 임포트
import java.util.Queue; // 큐 임포트
import java.util.StringTokenizer; // 쪼개서 입력받으려고 임포트

public class Boj2644 { // 백준 2644번을 풀고 있어서 Boj2644
	static boolean chk[]; // 가족 구성원을 확인했는지 체크하기 위해 사용
	static int N; // 가족이 몇명인지 궁금해서 사용
	static int 
	family[]; // 그래서 가족 관계가 어떻게 되는지 알기 위해 사용
	static int X, Y; // 백준이 알고 싶어하는 노드

	public static void main(String[] args) throws IOException { // 가장 먼저 실행된다는 메인함수 시작

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위해 br 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위해 bw 객체 생성

		N = Integer.parseInt(br.readLine()); // 입력에서 전체 가족 구성원의 수를 먼저 입력한다고 하였습니다. 그래서 N은 가족 구성원 수입니다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 다음 촌수를 계산할 노드를 입력받아야 하므로 StringTokenizer를 이용해서
																		// 입력 받도록 하죠
		family = new int[N + 1]; // 가족 배열의 인덱스가 자식노드가 될것이고 자식이 부모노드 값을 갖게 될 것입니다.
		chk = new boolean[N + 1]; // 가족 구성원 만큼 생성
		X = Integer.parseInt(st.nextToken()); // 첫번째 토큰
		Y = Integer.parseInt(st.nextToken()); // 두번째 토큰
		int M = Integer.parseInt(br.readLine()); // 그다음 가족 구성원간의 관계의 수 즉 노드들간의 간선 갯수를 입력 받죠

		while (M-- > 0) // 간선이 줄어들어 0이 되기 전까지 while문을 돌려주고자 합니다.
		{// 즁괄호
			st = new StringTokenizer(br.readLine(), " ");// 가족 관계를 입력받아야 하므로 StringTokenizer를 이용해서 입력 받도록 하죠
			int parent = Integer.parseInt(st.nextToken()); // x는y의 부모노드라고 하였으므로 parent변수에 x를 담아줍니다.
			int child = Integer.parseInt(st.nextToken()); // y는 x의 자식노드이므로 child변수에 y를 담아주죠
			// 그다음에 연결 해줘야 겠죠?
			family[child] = parent; // 이렇게 연결해주도록 하겠습니다.
		} // 클로징 즁괄호
			// 입력이 끝났습니다. 노드를 큐에 넣고 너비우선탐색을 실시해보도록 하겠습니다.
		Queue<Point> q = new LinkedList<Point>(); // 너비 우선탐색을위해 큐를 선언해줍니다.
		q.add(new Point(X, 0)); // x 를 넣어줍시다.
		chk[X] = true; // 더이상 x는 확인하지 않아도 됩니다.
		int result = -1; // 관계가 없으면 -1이므로 -1로 초기화 하고 시작;
		while (!q.isEmpty()) // 큐가 비어있지 않는 동안 진행됨

		{ // 오프닝 여는 중괄호
			Point top = q.poll(); // 큐 헤드 값을 꺼내서 top에 저장하고 삭제
			int x = top.x; // 노드
			int d = top.y; // 촌수
			if (x == Y) { // X로 시작해서 Y까지 잘 도착했다면

				result = d; // 결과에 촌수를 저장해주고
				break; // 큐를 끝내버린다.
			} // if문 종료
				// 부모노드일수있으니 자식 탐색
			for (int i = 1; i < N + 1; i++) { // 1번 가족부터 N번 가족까지 탐색
				if (family[i] != x || chk[i]) continue; // i의 부모가 x가 아니면 거름, 걸렀는데 i가 이미 확인한 자식이여도 거름. 여기서 x도 체크로 자연스럽게 걸러질것임
				chk[i] = true; // 확인안한 자식 확인 체크
				q.add(new Point(i, d + 1)); // 자식 큐로 보내버리고 촌수 하나 늘려주기
			} // 탐색 종료
				// 자식 노드 일수 있으니 부모 탐색
			int parent = family[x]; // x 의 부모노드 값을 저장
			if (parent == 0 || chk[parent])	continue; // x가 최고 조상 노드라 부모가 없을수도 있으니 그걸 걸러내고 이미 확인한 부모여도 걸러냄
			chk[parent] = true; // 확인안한 부모 확인 체크
			q.add(new Point(parent, d + 1)); // 부모를 큐로 보내버리고 촌수 하나 늘려주기

		} // 클로징 닫는 중괄호

		bw.write(result + ""); // 결과값 출력
		bw.close(); // 출력 종료
		br.close(); // 입력 종료
	}// 메임함수 종료
}// 프로그램 종료 ㅃㅇ
