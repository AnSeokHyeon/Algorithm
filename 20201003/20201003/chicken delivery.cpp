#include <iostream>
#include <math.h>

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};
pos shop[20];
pos house[200];
using namespace std;
int cnt = 1;
int Hcnt = 1;
int map[51][51];
bool chk[20];
int N, M;
int result = 987654321;

void dis() {
	int temp = 0;
	for (int i = 1; i < Hcnt; i++) {
		int x = house[i].x;
		int y = house[i].y;
		int minDis = 987654321;
		for (int j = 1; j < cnt; j++) {
			if (chk[j] == false) continue;
			int x2 = shop[j].x;
			int y2 = shop[j].y;

			int distance = abs(x - x2) + abs(y - y2);
			if (minDis > distance)minDis = distance;
		}
		temp += minDis;
	}
	if (result > temp) result = temp;

}

void dfs(int n, int m) {
	if (n == 0 ) {
		dis();
 		return;
	}

	for (int i = m; i < cnt; i++) {
		if (chk[i] == true) continue;
		chk[i] = true;
		dfs(n - 1, i + 1);
		chk[i] = false;

 	}
}

int main(void) {
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 2) {
				shop[cnt].x = i;
				shop[cnt].y = j;
				cnt++;
			}
			if (map[i][j] == 1) {
				house[Hcnt].x = i;
				house[Hcnt].y = j;
				Hcnt++;
			}
		}
	}

	dfs(M, 1);
	cout << result << endl;

}