#include <iostream>
#include <cstdio>

using namespace std;
int num[101];
int main(void) {
	int T, Tcnt = 0;
	freopen("input.txt", "r", stdin);
	while (T--) {
		cin >> Tcnt;
		int temp = 0;
		int ans = 0;
		for (int i = 0; i < 1000; i++) {
			int n;
			cin >> n;
			num[n]++;
		}
		for (int i = 100; i > -1; i--) {
			if (num[i] > temp) {
				temp = num[i];
				ans = i;
			}
			num[i] = 0;
		}
		cout << "#" << Tcnt << " " << ans << endl;
	}
}
