#include <iostream>

using namespace std;

int box[51][51];

int main(void) {

	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> box[i][j];
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cout << box[i][j] << " ";
		}
		cout << endl;
	}
}