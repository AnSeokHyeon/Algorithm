#include <iostream>

using namespace std;

struct pos {
	int x;
	int y;
	int d;
	int t;
	pos() {
		this->x = 0;
		this->y = 0;
		this->d = 0;
	}
};
struct pos2 {
	int n;
	int k;
	pos2() {
		this->n = 0;
		this->k = 0;
	}
};
pos s[401];
pos2 chk[21][21];
int p[401][5][5];
int N;
int M;
int k;
int map[21][21];
int mv[21][21];
int dx[] = { 0,-1,1,0,0 };
int dy[] = { 0,0,0,-1,1 };

int main(void) {
	cin >> N >> M >> k;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] > 0) {
				s[map[i][j]].x = i;
				s[map[i][j]].y = j;
			}
		}
	}

	for (int i = 1; i <= M; i++) {
		int temp;
		cin >> temp;
		s[i].d = temp;
	}
	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= 4; j++) {
			for (int k = 1; k <= 4; k++) {
				cin >> p[i][j][k];
			}
		}
	}
	int t = 1;
	int size = M;
	while (t < 1001) {
		//cout << t << "초 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" << endl;
		for (int i = 1; i <= M; i++) {
			int x = s[i].x;
			int y = s[i].y;
			chk[x][y].n = i;
			chk[x][y].k = k;

		}
		for (int i = 1; i <= M; i++) {
			if (s[i].d == 0) continue;
			int x = s[i].x;
			int y = s[i].y;
			int d = s[i].d;

			for (int j = 1; j < 5; j++) {
				int mx = x + dx[p[i][d][j]];
				int my = y + dy[p[i][d][j]];
				int dir = p[i][d][j];

				if (mx < 1 || my < 1 || mx > N || my > N) continue;
				if (chk[mx][my].n > 0) continue;
				if (mv[mx][my] > 0) {
					s[i].x = 0;
					s[i].y = 0;
					s[i].d = 0;
					size--;

				}
				else {

					s[i].x = mx;
					s[i].y = my;
					s[i].d = dir;
					mv[mx][my] = i;
				}
				break;
			}
			if (!(x == s[i].x && y == s[i].y)) continue;
			for (int j = 1; j < 5; j++) {
				int mx = x + dx[p[i][d][j]];
				int my = y + dy[p[i][d][j]];
				int dir = p[i][d][j];

				if (mx < 1 || my < 1 || mx > N || my > N) continue;
				if (chk[mx][my].n != i) continue;

				s[i].x = mx;
				s[i].y = my;
				s[i].d = dir;
				mv[mx][my] = i;
				break;
			}


		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = mv[i][j];
				mv[i][j] = 0;
				if (chk[i][j].k > 0) {
					chk[i][j].k--;
					if (chk[i][j].k == 0) {
						chk[i][j].n = 0;
					}
				}
			}
		}
		if (size == 1)break;
		t++;

		//cout << " 상어 위치 " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << map[i][j] << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		//cout << " 냄새 현황 " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << chk[i][j].n << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

		//cout << " 냄새 현황 " << endl;
		//for (int i = 1; i <= N; i++) {
		//	for (int j = 1; j <= N; j++) {
		//		cout << chk[i][j].k << " ";
		//	}
		//	cout << endl;
		//}
		//cout << endl;

	}
	if (size > 1) t = -1;
	cout << t;
}
