#include <iostream>
#include <stdio.h> 

using namespace std;
int sale[1000001];

int main(void) {
	int T, Tcnt = 0;
	freopen("input.txt", "r", stdin);
	cin >> T;
	cout<< " #" << T << endl;
	int N;
	while (T--) {
		Tcnt++;
		if (Tcnt > 4) break;
		cin >> N;
		cout << "#" << Tcnt << " : " << N << endl;
		for (int i = 0; i < N; i++) {
			cin >> sale[i];
			cout << sale[i] << " ";
		}
		cout << endl;
		//cout << "#" << Tcnt << " " << endl;
	}    
	cout << " Á¾·á " << endl;
	return 0;
}