#include <iostream>

using namespace std;
int map[32][11];
int chk[32][11];
int N, M, H;
int dx[] = { 0,0,1 };
int dy[] = { 1,-1,0 };
bool tempr = false;
void dfs(int n, int a, int b) {
	if (n == 0) {
		bool temp = true;
		for (int i = 1; i <= H+1; i++) {
			for (int j = 1; j <= N; j++) {
				chk[i][j] = 0;
			}
		}

		for (int i = 1;i <= N; i++) {
			int x = 0;
			int y = i;
			while (1) {
				for (int j = 0; j < 3; j++) {
					if (map[x][y] == 0 && j < 2) continue;
					int mx = x + dx[j];
					int my = y + dy[j];
					if (j == 0 && map[mx][my] < map[x][y]) continue;
					if (j == 1 && map[mx][my] > map[x][y]) continue;
					if (mx > H + 1 || my < 1 || my > N) continue;
					if (j <2 && map[mx][my] == 0) continue;
					if (chk[mx][my] == i) continue;

					chk[mx][my] = i;
					x = mx;
					y = my;
					break;
				}
				if (x > H) break;
				/*
				cout<< x<< " , " << y << " : "<< " 사다리 경로 확인 " << endl;
				for (int k = 1; k <= H; k++) {
					for (int j = 1; j <= N; j++) {
						cout << chk[k][j];
					}
					cout << endl;
				}*/
			}
			if (y != i) {
				temp = false;
				break;
			}
		}/*
		cout << " 사다리 설치 확인 " << endl;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				cout << map[i][j];
			}
			cout << endl;
		}
		cout << " 사다리 경로 확인 " << endl;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				cout << chk[i][j];
			}
			cout << endl;
		}*/
		if (temp == true) {
			tempr = true;
		}

		return;
	}
	for (int j = a; j < N; j++) {
		for (int i = 1; i <= H; i++) {
			if (j == a && i < b)continue;
			if (map[i][j] != 0 || map[i][j + 1] != 0) continue;
			map[i][j] = 1;
			map[i][j + 1] = 2;
			dfs(n - 1, j, i);
			map[i][j] = 0;
			map[i][j + 1] = 0;
			if (tempr == true) break;
		}

		if (tempr == true) break;
	}

}

int main(void) {
	cin >> N >> M >> H;
	bool result;
	int ans = -1;
	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		map[x][y] = 1;
		map[x][y+1] = 2;
	}

	//cout << " 스사트 " << endl;
	//for (int i = 1; i <= H; i++) {
	//	for (int j = 1; j <= N; j++) {
	//		cout << map[i][j];
	//	}
	//	cout << endl;
	//}
	for (int i = 0; i < 4; i++) {
		dfs(i, 1,1);
		if (tempr == true) {
			ans = i;
			break;
		}
	}
	cout << ans << endl;
	
}