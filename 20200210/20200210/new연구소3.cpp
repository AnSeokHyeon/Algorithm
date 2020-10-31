#include <iostream>
#include <queue>

using namespace std;
struct pos {
	int x;
	int y;
	int time;
	pos() {
		this->x = 0;
		this->y = 0;
		this->time = 0;
	}

	pos(int x, int y, int time) {

		this->x = x;
		this->y = y;
		this->time = time;
	}
};


pos vPos[10];
pos onPos[3];
int vN=0;
int map[51][51];
int ck[51][51];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int minVirus[1000000];
int N, M, bfsn = 0;
int cnt = -1;
int minSec = 10000;
int wall;

void bfs() {

	cnt++;

	for (int a = 1; a <= N; a++) {
		for (int b = 1; b <= N; b++) {
			if (map[a][b] == 1) ck[a][b] = -3;
			else ck[a][b] = -1;
		}
	}
	queue<pos> q;

	for (int i = 0; i < vN; i++) {
		int x = vPos[i].x;
		int y = vPos[i].y;
		ck[x][y] = -2;
	}

	for (int i = 0; i < M; i++) {
		int x = onPos[i].x;
		int y = onPos[i].y;
		ck[x][y] = 0;
		q.push(pos(x, y, 0));
	}
	int temp = 0;
	int size = N * N - vN-wall;
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int time = f.time;
		if (time > temp) temp = time;
		if (size == 0) break;
		if (cnt == 143) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 2 && ck[i][j] == 0)  cout << 0;
					else if (map[i][j] == 1 && ck[i][j] == -3)  cout << "-";
					else if (ck[i][j] == -2) cout << "*";
					else cout << ck[i][j];
				}
				cout << endl;
			}
			cout << x << ", " << y << ", " << time << endl;
			cout << "@@@@@@@@@@@@@@@@@@@@@@@@@@@" << endl;
			cout << endl;
		}
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mtime = time + 1;
			if (mx > N || my > N) continue;
			if (mx < 1 || my < 1) continue;
			if (ck[mx][my] > 0) continue;
			if (map[mx][my] == 0 && ck[mx][my] == -1 ) {
				q.push(pos(mx, my, mtime));
				ck[mx][my] = mtime;
				size--;
			}
			if (ck[mx][my] == -2 && map[mx][my] == 2) {
				q.push(pos(mx, my, mtime));
				ck[mx][my] = 0;
			}
		}
	}

	minVirus[cnt] = temp;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (ck[i][j] == 0 && map[i][j] == 0) {
				minVirus[cnt] = -1;
				break;
			}
		}
	}

	cout << cnt + 1 << "¹øÂ° bfs :  " << minVirus[cnt] << endl;
}
void position(int x, int y) {
	if (y == M) {
		bfs();
		return;
	}
	for (int i = x; i < vN; i++) {
		onPos[y].x = vPos[i].x;
		onPos[y].y = vPos[i].y;
		position(i + 1, y + 1);
	}
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				vPos[vN].x = i;
				vPos[vN].y = j;
				vN++;
			}
			if (map[i][j] == 1) wall++;
		}
	}

	position(0, 0);

	for (int i = 0; i < cnt; i++) {
		if (minVirus[i] > -1 && minSec > minVirus[i]) minSec = minVirus[i];
		cout << i << " " << minSec << endl;
	}
	if (minSec == 10000) cout << -1;
	else cout << minSec << endl;
}