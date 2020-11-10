#pragma once

#include <iostream>
#include <vector>
#include <random>
#include <algorithm>
#include <functional>
#include <ctime>

namespace randNumber
{
   #ifndef FUNC_RAND
   #define FUNC_RAND	
	int rand(int upperBorder, int lowerBorder);
   #endif
}
std::vector<std::vector <int>> createMatrix(int sizeLines, int sizeRows);
void printMatrix(std::vector<std::vector <int>>sourceVector);
std::vector<std::vector <int>> deletePositiveOdd(std::vector<std::vector <int>> sourceVector, int sizeLines, int sizeRows);