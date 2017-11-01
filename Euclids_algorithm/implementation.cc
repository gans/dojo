// Implementation of Euclid's Algorithm
#include<iostream>
using namespace std;

int main() {

    int m = 544;
    int n = 119;
    int r = 0;
    int rtemp = 0;

    while (1) {
        rtemp = m % n;
        if (rtemp == 0) break;
        r = rtemp;
        m = n;
        n = r;
        if (m <= n) break;
    }
    cout << "The greatest common divisor is " << r << endl;
    return 0;
}
