#include <iostream>
#include <queue>
#include <vector>
// 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳
using namespace std;
struct pos {
	int x;
	int y;
	
	pos() {
		this->x = 0;
		this->y = 0;
	}

	pos(int x, int y) {
		this->x = x;
		this->y = y;
	}
}; //위치 구조
int map[8][8]; //맵 최대 8/8 
int chk[8][8]; //맵 체크  8/8
pos virusPos[100]; //바이러스 위치 전역 변수
pos wall[3];
int virusN = 0; // 바이러스 갯수 전역 변수
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int N, M, temp, safeMax = 0;
void bfs() {
	queue<pos> q; // 큐 선언
	for (int i = 0; i < virusN; i++) {
		int x = virusPos[i].x;
		int y = virusPos[i].y;
		q.push(pos(x, y));// 바이러스 큐 쌓기 
		chk[x][y] = 1; // 바이러스 체크
	} 	

	for (int i = 0; i < 3; i++) {
		int x = wall[i].x;
		int y = wall[i].y;
		chk[x][y] = 1; // 내가 세운 벽 체크 (맵에 없으므로) 
	}
	
	while (!q.empty()) { // 큐가 비어 있지 않을때
		pos f = q.front(); // 큐 맨앞 바이러스 좌표 저장
		q.pop(); // 큐 삭제
		int x = f.x; // 바이러스 좌표 저장
		int y = f.y; // 바이러스 좌표 저장
		//cout <<"바이러스 좌표  :  "<< x << "  " << y << endl;
		for (int i = 0; i < 4; i++) { // 바이러스 상하 좌우 이동
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx > N || my > M) continue; // 맵보다 크면 무시
			if (mx < 1 || my < 1) continue; // 맵보다 작으면 무시
			if (chk[mx][my] == 1) continue; // 내가 세운 벽이거나 이미 바이러스 퍼진 곳 체크
			if (map[mx][my] == 0) {
				q.push(pos(mx, my)); //바이러스 전염 되었음
				chk[mx][my] = 1; //바이러스 전염 체크
			}
		}
	}

	int n = 0; // 안전구역 찾기

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (chk[i][j] == 0 && map[i][j]==0) {
				n++; //확인하지 않은곳이면서 지도에서 안전구역일 경우
			}
			chk[i][j] = 0; // 길을 제외한 모든 체크 포인트 초기화
		}
	}
	if (n > safeMax) safeMax = n;
}

int main(void) {
	cin >> N >> M;
	for(int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			int num;
			cin >> num;
			map[i][j] = num;
			if (num == 2) {
				virusPos[virusN].x = i;
				virusPos[virusN].y = j;
				virusN++;
				chk[i][j] = 2;
			}
		}
	}
	for (int x1 = 1; x1 <= N; x1++) {
		for (int y1 = 1; y1 <= M; y1++) {
			if (map[x1][y1] != 0) continue; // 벽일때 무시 && 바이러스 무시
			wall[0].x = x1; //벽이 아닐때 x1좌표 저장
			wall[0].y = y1; //벽이 아닐때 y1좌표 저장
			for (int x2 = 1 ; x2 <= N; x2++) {
				for (int y2 = y1; y2 <= M; y2++) {
					if (map[x2][y2] != 0) continue; // 벽일때 무시 && 바이러스 무시
					if ((y1 == y2) && (x2 <= x1)) continue; //
					wall[1].x = x2;//벽이 아닐때 x2좌표 저장
					wall[1].y = y2;//벽이 아닐때 y2좌표 저장
					for (int x3 = 1; x3 <= N; x3++) {
						for (int y3 = y2; y3 <= M; y3++) {
							if (map[x3][y3] != 0) continue; // 벽일때 무시 && 바이러스 무시
							if ((y2 == y3) && (x3 <= x2)) continue;
							wall[2].x = x3;//벽이 아닐때 x3좌표 저장
							wall[2].y = y3;//벽이 아닐때 y3좌표 저장
							bfs();
							wall[2].x = 0;//벽 초기화
							wall[2].y = 0;//벽 초기화
						}
					}
					wall[1].x = 0;//벽 초기화
					wall[1].y = 0;//벽 초기화
				}
			}
			wall[0].x = 0; //벽 초기화
			wall[0].y = 0; //벽 초기화
		}
	}
	bfs();
	cout << safeMax;
	return 0;
}