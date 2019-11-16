#define MULTIPLY(x,y) x*y
#include <math.h>
#include <iostream>
using namespace std;


void createMatrix(int** myArray, int size)
{
	for (int i = 0; i < size; ++i)
		myArray[i] = new int[size];	
}
void fillMatrix(int** myArray, int size)
{
	for (int i = 0; i < size; ++i)
	{
		for (int j = 0; j < size; ++j)
			myArray[i][j] = rand() % 50;
	}
}
void findMinPostions(int** myArray, int size, int& minX, int& minY)
{
	int minimal = myArray[0][0];
	for (int i = 0; i < size; ++i)
	{
		for (int j = 0; j < size; ++j)
		{
			if (myArray[i][j] < minimal)
			{
				minimal = myArray[i][j];
				minX = i;
				minY = j;
			}
		}
	}
}
void swapPositions(int** myArray, int X, int Y)
{
	swap(myArray[0][0], myArray[X][Y]);
}
void randomFunction(int** myArray, int size)
{
	int minX, minY;
	findMinPostions(myArray, size, minX, minY);
	swapPositions(myArray, minX, minY);
}

string randomFunction(char source[])
{
	int k = 0;
	char buffer[200];
	for (int i = 0; i < strlen(source); ++i)
	{
		buffer[k++] = source[i];
		buffer[k++] = source[i];
	}
	buffer[k++] = '\0';
	
	return buffer;
}

template <typename T> 
T function(T number1, T number2)
{
	T result = MULTIPLY(number1, number1) + MULTIPLY(2, MULTIPLY(number2, number2)) - MULTIPLY(3, number1);
	return result;
}
void callFunction()
{
	long lNum1 = 5, lNum2 = 3;
	float sNum1 = 2.4, sNum2 = 3.1;
	function(lNum1, lNum2);
	function(sNum1, sNum2);
}

void main()
{
	
}