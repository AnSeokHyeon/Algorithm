#include <iostream>
using namespace std;

int map[101][101];
int cnt[101];
int maxR, maxC, maxN, tempR, tempC;
void solve() {
	//cout << " 들어옴 " << endl;
	if (maxR >= maxC) {
		tempR = maxR;
		tempC = 0;
		for (int i = 1; i <= maxR; i++) {
			for (int j = 1; j <= maxC; j++) {
				int x = map[i][j];
				if (x > 0) cnt[x]++;
				map[i][j] = 0;
			}
			int temp = 1;
			for (int j = 1; j <= 101; j++) {
				for (int k = 1; k < 101; k++) {
					if (cnt[k] == j) {
						map[i][temp++] = k;
						map[i][temp++] = cnt[k];
						//cout << i << " " << k << " " << cnt[k] << " " << temp << endl;
					}
				}
			}
			if (temp - 1 > tempC) tempC = temp - 1;
			for (int j = 1; j < 101; j++) {
				cnt[j] = 0;
			}
			//cout << " 한줄 끝남 " << endl;
		}
	}
	else {
		tempC = maxC;
		tempR = 0;
		for (int j = 1; j <= maxC; j++) {
			for (int i = 1; i <= maxR; i++) {
				int x = map[i][j];
				if (x > 0) cnt[x]++;
				map[i][j] = 0;
			}
			int temp = 1;
			for (int i = 1; i < 101; i++) {
				for (int k = 1; k < 101; k++) {
					if (cnt[k] == i) {
						map[temp++][j] = k;
						map[temp++][j] = cnt[k];
						//cout << j << " " << k << " " << cnt[k] << " " << temp << endl;
					}
				}
			}
			if (temp - 1 > tempR) tempR = temp - 1;
			for (int i = 1; i < 101; i++) {
				cnt[i] = 0;
			}
		}
	}
}

int main(void) {
	int r, c, k;
	cin >> r >> c >> k;
	for (int i = 1; i <= 3; i++) {
		for (int j = 1; j <= 3; j++) {
			cin >> map[i][j];
		}
	}
	maxR = 3;
	maxC = 3;
	int ans = 0;
	while (1) {
		if (map[r][c] == k) {
			cout << ans << endl;
			break;
		}
		if (ans > 100) {
			ans = -1;
			cout << ans << endl;
			break;
		}
		solve();
		ans++;
		//cout << tempR << " " << tempC << endl;
		maxR = tempR;
		maxC = tempC;
		/*cout << " 현재 상황 @@@@@@@@@@@@" << endl;
		for (int i = 1; i <= maxR; i++) {
			for (int j = 1; j <= maxC; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}*/
	}
}