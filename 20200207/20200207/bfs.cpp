#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	int ck;
	pos(int x, int y, int ck) {
		this->x = x;
		this->y = y;
		this->ck = ck;
	};
};

int map[102][102] = { 0 };
int c[102][102] = { 0 };
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
int N, M, temp;

void bfs(int x, int y, int n) {
	queue<pos> q; // 큐 선언 
	q.push(pos(x, y, n)); // 시작값 푸시 
	while (!q.empty()) {
		pos f = q.front(); //q.front 값을 f에 생성 
		int x = f.x; // f의 첫번째 좌표, x에 저장 
		int y = f.y; // f의 두번째 좌표, y에 저장 
		int ck = f.ck;
		temp = ck;
		if (x == N && y == M) break;
		q.pop(); // q하나 제거 
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i]; // 이동할 새로운 x 좌표  mx 
			int my = y + dy[i]; // 이동할 새로운 y 좌표  my 
			int mz = ck + 1;

			if (mx < 0 || my < 0) continue; // x축보다 작거나  y축보다 작으면 for문 out 
			if (mx > N || my > M) continue; // N보다 크거나  M보다 크면 for 문 out 
			if (c[mx][my] == 1) continue; // 이미 지나온 지점이면 for문 out 
			if (map[mx][my] == 1) { //벽이 아닐경우 실행  
				q.push(pos(mx, my, mz)); //이동좌표 푸쉬 
				c[mx][my] = 1;
			}
		}
	}
	cout << temp;
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			int num;
			scanf("%1d", &num);
			map[i][j] = num;
		}
	}
	bfs(1, 1, 1);
	return 0;
}