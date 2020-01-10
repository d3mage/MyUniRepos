#include <iostream>
#include <fstream>
using namespace std; 
int calculateFuel(int &num)
{
	num /= 3;
	num -= 2;
	return num; 
}
int calculateALLFuel(int num)
{
	if (num/3-2 < 0)
	{
		return num;
	}		
	return num+calculateALLFuel(num / 3 - 2);
}
int findAmmountOfFuel()
{
	int sum = 0;
	ifstream file("Day1.txt");
	for (int num; file>>num;)
	{
		sum += calculateFuel(num)-num;
	}	
	file.close();
	return sum;
}
int findAmmountOfALLFuel()
{
	int sum = 0;
	ifstream file("Day1.txt");
	for (int num; file >> num;)
	{
		sum += calculateALLFuel(num)-num;
	}
	file.close();
	return sum;
}


