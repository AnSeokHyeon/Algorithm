#include <iostream>

using namespace std;
struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};

pos Hpoint[5];
int N, K;
int map[9][9];
int chk[9][9];
int chk2[9][9];
int dx[] = { 1,-1,0,0 };
int dy[] = { 0,0,1,-1 };
int road[64];
int tempRoad[64];
int maxRoad;
void mt(int x, int y, int z) {

	chk[x][y] = 1; 
	tempRoad[z - 1] = map[x][y];
	//cout << " 현재 값 및 위치 "<< map[x][y] << " : " << x << " "<< y  << " "<< z << endl;
	for (int i = 0; i < 4; i++) {
		int mx = x + dx[i];
		int my = y + dy[i];
		if (mx > N || my > N) continue;
		if (mx < 1 || my < 1) continue;
		if (chk[mx][my] == 1) continue;
		if (map[mx][my] >= map[x][y]) continue;

		mt(mx, my, z + 1);

	}
	if (z > maxRoad) {
		maxRoad = z;
	}

	//cout << "이거 종료 " << map[x][y] << " : " << x << " " << y << " " << z << endl;
	chk[x][y] = 0;
}

int main(void) {
	int T;
	cin >> T;

	int Tcnt = 0;
	while (T--) {
		cin >> N >> K;
		maxRoad = 0;
		int tempmax = 0;
		int tempcnt = 0;
		Tcnt++;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] > tempmax) tempmax = map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == tempmax) {
					Hpoint[tempcnt].x = i;
					Hpoint[tempcnt].y = j;
					tempcnt++;
				}
			}
		}

		for (int i = 0; i < tempcnt; i++) {
			int x = Hpoint[i].x;
			int y = Hpoint[i].y;

			for (int k = 1; k <= N; k++) {
				for (int l = 1; l <= N; l++) {
					if (x== k && y == l) continue;
					for (int j = 1; j <= K; j++) {
						map[k][l] -= j;
						mt(x, y, 1);
						map[k][l] += j;
					}
				}
			}

		}

		//for (int i = 0; i < maxRoad; i++) {
		//	cout << road[i] << " ";
		//}
		cout << "#" << Tcnt << " " << maxRoad << endl;
	}
}