#include <bits/stdc++.h>
using namespace std;
int a, b;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	while(cin >> a >> b) {
        if ((a == 0) && (b == 0)) break;
        cout << a + b << "\n";
    }
}