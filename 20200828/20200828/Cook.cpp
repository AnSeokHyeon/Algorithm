#include <iostream>
#include <math.h>

using namespace std;
struct pos {
	int idx;
	int x;
	int y;
	int n;
	pos() {
		this->idx = 0;
		this->x = 0;
		this->y = 0;
		this->n = 0;
	}
};
pos cook[150];
int map[17][17];
int chk[9];
int N, cnt = 0;
int temp[20];
int temp2[20];
int result = 978654321;
void dfs(int n, int m, int l) {
	if (n == l) {
		int tempcnt = 0;
		for (int i = 1; i <= N; i++) {
			if (chk[i] != 0) continue;
			
			temp2[tempcnt] = i;
			tempcnt++;
		}

		int sum = 0;
		for (int i = 0; i < l; i++) {
			cout << temp[i] << " ";
		}
		cout << endl;
		for (int i = 0; i < l; i++) {
			if(i == l-1)
				if(N > 5)
					sum = sum + map[temp[i]][temp[0]] + map[temp[0]][temp[i]];
				else
				{ }
			else
				sum = sum + map[temp[i]][temp[i + 1]] + map[temp[i + 1]][temp[i]];
		}
		int sum2 = 0;
		for (int i = 0; i < l; i++) {
			cout << temp2[i] << " ";
		}
		cout << endl;
		for (int i = 0; i < l; i++) {
			if (i == l - 1)
				if (N > 5)
					sum2 = sum2 + map[temp2[i]][temp2[0]] + map[temp2[0]][temp2[i]];
				else {}
			else
				sum2 = sum2 + map[temp2[i]][temp2[i+1]] + map[temp2[i + 1]][temp2[i]];
		}

		int gap = abs(sum - sum2);
		cout << sum << " , " << sum2 << " / " << gap << endl;
		if (result > gap) result = gap;
		
		return;
	}

	for (int i = 1; i <=N; i++) {
		if (chk[i] == 1) continue;
		temp[n] = i;
		chk[i] = 1;
		dfs(n + 1, i + 1, l);
		chk[i] = 0;
	}
}

int main(void) {
	int T, Tcnt = 1;
	cin >> T;
	while (T--) {
		cin >> N;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cin >> map[i][j];
			}
		}
		cnt = 0;
		result = 978654321;

		dfs(0, 1, N/2);
		cout << "#" << Tcnt++ << " " << result << endl;
	}
}