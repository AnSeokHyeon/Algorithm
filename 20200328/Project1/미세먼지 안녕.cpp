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
	pos(int x, int y) {
		this->x = x;
		this->y = y;
		this->t = t;
	}
};
pos virus[2500];
pos vac[2];
int map[51][51];
int temp[51][51];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };

int main(void) {
	int R, C, T, sum = 0;
	cin >> R >> C >> T;
	int cnt = 0;
	int cnt2 = 0;
	for (int i = 1; i < R + 1; i++) {
		for (int j = 1; j < C + 1; j++) {
			cin >> map[i][j];
			if (map[i][j] > 0) {
				virus[cnt].x = i;
				virus[cnt].y = j;
				cnt++;
			}
			if (map[i][j] == -1 ) {
				vac[cnt2].x = i;
				vac[cnt2].y = j;
				temp[i][j] = -1;
				cnt2++;
			}
		}
	}
	int vacx = vac[0].x;
	int vacy = vac[0].y;
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < cnt; j++) {
			int x = virus[j].x;
			int y = virus[j].y;
			int t = virus[j].t;
			int virusN = map[x][y];
			int virusM = virusN / 5;
			for (int k = 0; k < 4; k++) {
				int mx = x + dx[k];
				int my = y + dy[k];
				int mt = t + 1;

				if (mx <1 || my < 1 || mx > R || my >C) continue;
				if (map[mx][my] == -1) continue;
				temp[mx][my] = virusM + temp[mx][my];
				virusN = virusN - virusM;
			}
			temp[x][y] = virusN + temp[x][y];
		}
		//cout << i + 1 << "¹øÂ° @@@@@@@@@@@ " << endl;
		//for (int j = 1; j < R + 1; j++) {
		//	for (int k = 1; k < C + 1; k++) {
		//		printf("%2d ", temp[j][k]);
		//	}
		//	cout << endl;
		//}
		//cout << endl;
		for (int j = vacx -1; j > 1; j--) {
			temp[j][1] = temp[j - 1][1];
		}
		for (int j = vacx+2; j <R; j++) {
			temp[j][1] = temp[j+1][1];
		}
		for (int j = 1; j < C; j++) {
			temp[1][j] = temp[1][j + 1];
			temp[R][j] = temp[R][j + 1];
		}
		for (int j = R; j > vacx + 1; j--) {
			temp[j][C] = temp[j - 1][C];
		}
		for (int j = 1; j < vacx; j++) {
			temp[j][C] = temp[j + 1][C];
		}
		for (int j = C; j > vacy; j--) {
			if (j == 2) {
				temp[vacx][j] = 0;
				temp[vacx + 1][j] = 0;
			}
			else {
				temp[vacx][j] = temp[vacx][j - 1];
				temp[vacx + 1][j] = temp[vacx+1][j-1];
			}
		}
		cnt = 0;
		sum = 2;
		for (int j = 1; j < R + 1; j++) {
			for (int k = 1; k < C + 1; k++) {
				//printf("%2d ", temp[j][k]);
				sum += temp[j][k];
				map[j][k] = temp[j][k];
				temp[j][k] = 0;
				if (map[j][k] > 0) {
					virus[cnt].x = j;
					virus[cnt].y = k;
					cnt++;
				}
			}
			//cout << endl;
		}
		//cout << endl;
		for (int j = 0; j < 2; j++) {
			int tempx = vac[j].x;
			int tempy = vac[j].y;
			temp[tempx][tempy] = -1;
		}
	}
	cout << sum;
}