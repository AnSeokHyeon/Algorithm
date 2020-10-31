#include <iostream>

using namespace std;
int person[9];
bool chk[9];
int seven[7];

void princess(int n) {
	if (n == 7) {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += seven[i];
		}
		if (sum == 100) {
			
			for (int i = 0; i < 7; i++) {
				cout << seven[i] << " ";
			}
			cout << endl;
		}
		return;
	}

	for (int i = 0; i < 9; i++) {
		if (chk[i] == true) continue;

			seven[n] = person[i];
			chk[i] = true;
			princess(n + 1);
			chk[i] = false;		
	}
}

int main(void) {
	for (int i = 0; i < 9; i++) {
		cin >> person[i];
	}
	for (int i = 0; i < 9; i++) {
		cout << person[i] << " ";
	}
	cout << endl;
	for (int a = 0; a < 9; a++) {
		for (int b = 0; b < 8 - a; b++) {
			if (person[b] > person[b + 1]) {
				int temp = person[b + 1];
				person[b + 1] = person[b];
				person[b] = temp;
			}
		}
	}
	for (int i = 0; i < 9; i++) {
		cout << person[i] << " ";
	}
	cout << endl;
	princess(0);

}