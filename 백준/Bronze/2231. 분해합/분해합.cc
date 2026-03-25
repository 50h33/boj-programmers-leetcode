#include <bits/stdc++.h>
using namespace std;
int n;

int go(int x) {
    int num = 0;
    while(x > 0) {
        num += x % 10;
        x /= 10;
    }
    return num;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    for (int i = 1; i < n; i++) {
        if(i + go(i) == n) {
            cout << i << "\n";
            return 0;
        }
    }

    cout << 0 << "\n";
}