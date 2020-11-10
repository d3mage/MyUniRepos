#include "header.h"

std::mt19937 number(time(0));

int randNumber::rand(int lowerBorder, int upperBorder)
{	
	std::uniform_int_distribution<> generator(lowerBorder, upperBorder);
	return generator(number);
}

std::vector<std::vector <int>> createMatrix(int sizeLines, int sizeRows)
{
	
	std::vector<std::vector<int>> toReturnVector;
	for (int i = 0; i < sizeLines; ++i)
	{
		std::vector <int> tempVector;
		for (int j = 0; j < sizeRows; ++j)
		{
			tempVector.push_back(randNumber::rand(1,40));
		}
		toReturnVector.push_back(tempVector);
	}
	return toReturnVector;
}


void printMatrix(std::vector<std::vector <int>>sourceVector)
{
	for (int i = 0; i < sourceVector.size(); ++i)
	{
		for (int j = 0; j < sourceVector[i].size(); ++j)
		{
			std::cout << sourceVector[i][j]<<" ";
		}
		std::cout << std::endl;
		std::cout << std::endl;
	}
}

std::vector<std::vector <int>> deletePositiveOdd(std::vector<std::vector <int>> sourceVector, int sizeLines, int sizeRows)
{
	std::vector <int> indexVector; 
	std::vector<std::vector <int>> toReturn; 
	for (int i = 0; i < sizeLines; ++i)
	{
		std::vector <int> tempVector;
		for (int j = 0; j < sizeRows; ++j)
		{
			if (sourceVector[i][j] > 0 && sourceVector[i][j] % 2 == 0)
			{
				indexVector.push_back(i);
				indexVector.push_back(j);
				tempVector.push_back(0);
			}
			else
			{
				tempVector.push_back(sourceVector[i][j]);
			}
		}
		toReturn.push_back(tempVector);
	}
	std::cout<<std::endl;
	for (int i = 0; i < indexVector.size(); ++i)
	{
		std::cout << indexVector[i] << " ";
	}
	std::cout << std::endl;
	return toReturn;
}
