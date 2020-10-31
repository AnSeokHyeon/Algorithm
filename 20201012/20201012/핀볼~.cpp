#include <iostream>

using namespace std;

struct pos {
	int x1;
	int y1;
	int x2;
	int y2;

	pos() {
		this->x1 = 0;
		this->x2 = 0;
		this->y1 = 0;
		this->y2 = 0;
	}
};
pos black[10];
int N;
int map[102][102];
int dx[] = { -1,0,1,0 };
int dy[] = { 0,1,0,-1 };
int wall[6][4] = { {0,0,0,0},{0,0,1,1},{1,0,0,1},{1,1,0,0},{0,1,1,0},{1,1,1,1} };
int result = 0;

void pinball(int a, int b, int c) {
	int x = a;
	int y = b;
	int d = c;
	int pt = 0;
	while (1) {
		/*
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (x == i && y == j) cout << "# ";
				else cout << map[i][j] << " ";
			}
			cout << endl;
		}*/

		//cout << x << " , " << y << " / " << d << " pt : " << pt << endl;
		x = x + dx[d];
		y = y + dy[d];

		if (x > N || y > N || x < 1 || y < 1) {
			d = (d + 2) % 4;
			pt++;
		}
		else if (map[x][y] > 5) {
			int temp = map[x][y] - 5;
			if (black[temp].x1 == x && black[temp].y1 == y) {
				x = black[temp].x2;
				y = black[temp].y2;
			}
			else {
				x = black[temp].x1;
				y = black[temp].y1;
			}
		}
		else if (map[x][y] > 0) {
			int temp = map[x][y];
			int w = (d + 2) % 4;

			if (wall[temp][w] == 1) {
				pt++;
				d = w;
			}
			else {
				for (int i = 0; i < 4; i++) {
					if (i == w) continue;
					if (wall[temp][i] == 1) continue;
					d = i;
					pt++;
				}
			}
		}
		else if ( map[x][y] == -1)
		{
			break;
		}
		if (x == a && y == b) break;
	}
	if (pt > result) result = pt;
}

int main(void) {
	int T;
	cin >> T;
	int Tcnt = 1;
	while (T--) {
		cin >> N;
		result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] > 5) {
					int num = map[i][j] - 5;
					if (black[num].x1 == 0) {
						black[num].x1 = i;
						black[num].y1 = j;
					}
					else {
						black[num].x2 = i;
						black[num].y2 = j;
					}
				}
			}
		}


		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) continue;
				for (int k = 0; k < 4; k++) {
					pinball(i, j, k);
				}
			}
		}

		cout << "#" << Tcnt++ << " " << result << endl;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 0;
			}
		}
		for (int i = 1; i <= 10; i++) {
			black[i].x1 = 0;
			black[i].x2 = 0;
			black[i].y1 = 0;
			black[i].y2 = 0;

		}
	}
}