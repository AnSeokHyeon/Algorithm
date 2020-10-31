#include <iostream>
#include <queue>

using namespace std;

struct pos {
	int x;
	int y;
	int t;

	pos() {
		this->x = 0;
		this->y = 0;
		this->t = 0;

	}

	pos(int x, int y,  int t) {
		this->x = x;
		this->y = y;
		this->t = t;
	}
};
int line[8][3][3] = {
	{{0,0,0},{0,0,0},{0,0,0}},
	{{0,1,0},{1,1,1},{0,1,0}},
	{{0,1,0},{0,1,0},{0,1,0}},
	{{0,0,0},{1,1,1},{0,0,0}},
	{{0,1,0},{0,1,1},{0,0,0}},
	{{0,0,0},{0,1,1},{0,1,0}},
	{{0,0,0},{1,1,0},{0,1,0}},
	{{0,1,0},{1,1,0},{0,0,0}}
};
pos starting[5];
int map[51][51];
int chk[51][51];

queue<pos> q;

int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };
int N, M, R, C, L;
int result;

void bfs() {
	q.push(pos(R, C, 1));
	chk[R][C] = 1;
	while (!q.empty()) {
		pos first = q.front();

		int x = first.x;
		int y = first.y;
		int t = first.t;
		if (t == L) {
			break;
		}
		q.pop();
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int n = map[x][y];
			int mn = map[mx][my];
			int mt = t + 1;

			if (mx > N - 1 || my > M - 1 || mx < 0 || my < 0) continue;
			if (map[mx][my] == 0) continue;
			if (chk[mx][my] != 0) continue;
			if ((i==0) && ((line[mn][0][1] == 0) || (line[n][2][1] == 0))) continue;
			if ((i == 1)&&((line[n][1][2] == 0) || (line[mn][1][0] == 0))) continue;
			if ((i==2) && ((line[n][0][1] == 0) || (line[mn][2][1] == 0))) continue;
			if ((i==3) && ((line[mn][1][2] == 0) || (line[n][1][0] == 0))) continue;


			chk[mx][my] = mt;
			q.push(pos(mx, my, mt));
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			//cout << chk[i][j] << " ";
			if(chk[i][j] != 0) result++;
		}
		//cout << endl;
	}
}

int main (void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N >> M >> R >> C >> L;
		result = 0;
		for (int i = 0; i< N; i++) {
			for (int j = 0; j < M; j++) {
				cin >> map[i][j];
			}
		}
		bfs();
		cout << "#" << Tcnt++ << " "<<result << endl;


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 0;
				chk[i][j] = 0;
			}
		}
		while (!q.empty()) q.pop();
	}
}