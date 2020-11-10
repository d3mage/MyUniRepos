#include <iostream>
#include <string>
using namespace std;

string getLine()
{
	char buf[500];
	cout << "Enter you line: ";
	cin.getline(buf, 500);
	string line = _strdup(buf);
	return line;
}

bool isBeginningCorrect(string& line)
{
	if (line[0] == '_')
		return true;
	else return false;
}

bool isSecondSymbolCorrect(string& line)
{
	if (line[1] == '+' || line[1] == '-')
		return true;
	return false;
}

bool isSequenceCorrect(string& line, int& state)
{
	char alphabet[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
	char numbers[]{ 48, 49, 50, 51, 52, 53 };
	for (int i = 0; i < 11; i++)
	{
		if (line[2] == alphabet[i])
		{
			state = 0;
			return true;
		}
	}
	for (int i = 0; i < 6; i++)
	{
		if (line[2] == numbers[i])
		{
			state = 1;
			return true;
		}
	}
}

bool isCompletelyCorrectNumbers(string& line, char numbers[]) {
	for (int i = 3; i < line.length(); i++) {
		for (int j = 0; j < 6; j++)
		{
			if (line[i] == numbers[j])
			{
				break;
			}
			else if (j == 5)
				return false;
		}
	}
	return true;
}

bool isCompletelyCorrectLetters(string& line, char letters[]) {
	for (int i = 3; i < line.length(); i++) {
		for (int j = 0; j < 11; j++)
		{
			if (line[i] == letters[j])
			{
				break;
			}
			else if (j == 10)
				return false;
		}
	}
	return true;
}

int scannerOfLine()
{
	char alphabet[]{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
	char numbers[]{ 48, 49, 50, 51, 52, 53 };
	int state;
	string line = getLine();
	if (isBeginningCorrect(line) != true
		|| isSecondSymbolCorrect(line) != true
		|| isSequenceCorrect(line, state) != true)
		return -1;
	if (state == 0)
		return isCompletelyCorrectLetters(line, alphabet);
	if (state == 1)
		return isCompletelyCorrectNumbers(line, numbers);
	else return -1;
}

void printAnswer()
{
	int result = scannerOfLine();
	if (result == 1)
		cout << "This string is OK";
	else cout << "String is mistaken";
}

void main()
{
	printAnswer();
}
