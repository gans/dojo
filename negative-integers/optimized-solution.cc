#include <iostream>

int main()
{
    int m[3][4] = {
        {-3, -2, -1, 1},
        {-2, 2, 3, 4},
        {4, 5, 7, 8}
    };
    int c = 0;
    int i = 0;
    int j = 3;

    while (j >= 0 && i < 3)
    {
        if (m[i][j] < 0)
        {
            c += j + 1;
            i += 1;
        } else {
            j -= 1;
        }
    }

    std::cout << "negative integers: " << c << std::endl; 
    return 0;
}

