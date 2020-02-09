#include "header.h" 


void main()
{
	std::vector<std::vector <int>> firstVector;
	std::vector<std::vector <int>> destVector;
	int ammountLines = 2, ammountRows = 3;
	firstVector = createMatrix(ammountLines, ammountRows);
	printMatrix(firstVector);
	destVector = deletePositiveOdd(firstVector, ammountLines, ammountRows);
	printMatrix(destVector);
	
	
}