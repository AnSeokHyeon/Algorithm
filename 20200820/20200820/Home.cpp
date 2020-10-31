#include <iostream>
#include <math.h>
using namespace std;

struct pos {
	int x;
	int y;
	pos() {
		this->x = 0;
		this->y = 0;
	}
};
pos home[400];
int map[21][21];
int N, M;
int Hcnt;
int result;
void service(int n, int m, int k) {
	int securityMoney = k * k + (k - 1) * (k - 1);
	int homeMoney = 0;
	int securityHome = 0;
	for (int i = 0; i < Hcnt; i++) {
		int x = home[i].x;
		int y = home[i].y;
		int d = abs(n - x) + abs(m - y);
		if (k > d) {
			homeMoney += M;
			securityHome++;
		}
	}
	int totalMoney = homeMoney - securityMoney;
	if ((totalMoney >= 0) && (securityHome > result)) result = securityHome;
}

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N >> M;
		Hcnt = 0;
		result = -978654321;
		for (int i = 1; i <=N; i++) {
			for (int j = 1;j <= N; j++) {
				cin >> map[i][j];
				if (map[i][j] == 1) {
					home[Hcnt].x = i;
					home[Hcnt].y = j;
					Hcnt ++;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= 2*N; k++) {
					service(i, j, k);
				}
			}
		}
		cout << "#" << Tcnt++ << " " << result << endl;
	}
}