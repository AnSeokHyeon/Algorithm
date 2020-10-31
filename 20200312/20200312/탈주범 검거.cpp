#include <iostream>
#include <queue>
#include <cstdio>

using namespace std;

struct pos {
	int x;
	int y;
	int n;
	pos() {
		this->x = 0;
		this->y = 0;
		this->n = 0;
	};

	pos(int x, int y, int n) {
		this->x = x;
		this->y = y;
		this->n = n;
	};
};
pos mxy[2500];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int map[50][50];
int chk[50][50];
int line[4][7][7] = { {{1,1,0,1,0,0,1},{1,1,0,1,0,0,1},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{1,1,0,1,0,0,1},{1,1,0,1,0,0,1},{0,0,0,0,0,0,0}},
					  {{1,1,0,0,1,1,0},{1,1,0,0,1,1,0},{0,0,0,0,0,0,0},{1,1,0,0,1,1,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{1,1,0,0,1,1,0}},
					  {{1,0,1,0,0,1,1},{0,0,0,0,0,0,0},{1,0,1,0,0,1,1},{1,0,1,0,0,1,1},{1,0,1,0,0,1,1},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}},
					  {{1,0,1,1,1,0,0},{0,0,0,0,0,0,0},{1,0,1,1,1,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{1,0,1,1,1,0,0},{1,0,1,1,1,0,0}}
};

int N, M, L, cnt;

void find(int n, int m) {
	queue<pos> q;
	cnt = 1;
	chk[n][m] = 1;
	q.push(pos(n, m, 1));
	while (!q.empty()) {
		pos f = q.front();
		q.pop();
		int x = f.x;
		int y = f.y;
		int n = f.n;
		if (n == L) break;
		for (int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			int mn = n + 1;
			if (mx > N-1 || my > M-1 || mx < 0 || my < 0) continue;
			if (map[mx][my] == 0) continue;
			if (chk[mx][my] != 0) continue;
			if (line[i][map[x][y] - 1][map[mx][my] - 1] == 0) continue;
			//cout<< "Çª½Ã ÁÂÇ¥ : " << mx << " , " << my<< " , " << mn <<" , " << map[x][y] - 1 << " , " << map[mx][my] - 1 << " , " <<  line[i][map[x][y] - 1][map[mx][my] - 1] << endl;
			q.push(pos(mx, my, mn));
			chk[mx][my] = mn;
			cnt++;
		}
	}
	//if(cnt > 20){
	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < M; j++) {
	//		if (i == n && j == m) cout << "* ";
	//		else cout << chk[i][j] << " ";
	//	}
	//	cout << endl;
	//}
	//}
	while (!q.empty()) q.pop();
}

int main(void) {
	int T;

	//freopen("input.txt", "r", stdin);
	cin >> T;
	int Tcnt = 0;
	while (T--) {
		Tcnt++;
		int R, C;
		cin >> N >> M >> R >> C >> L;
		//cout << N << " " << M << " " << R << " " << C << " " << L << " " << endl;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cin >> map[i][j];
			}
		}
		find(R, C);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				chk[i][j] = 0;
				map[i][j] = 0;
			}
		}

		cout << "#" << Tcnt << " " << cnt << endl;
	}
}