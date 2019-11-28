#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int getAmmountOfGroups(string nameOfFile)
{
	char buf[50];
	ifstream file(nameOfFile);

	while (!file.eof())
	{
		file >> buf;
		if (strcmp(buf, "groups:") == 0)
		{
			file >> buf;
			return int(buf);
		}
	}
}
bool isAmmountValid(int subject)
{
	if (subject > 0 && subject < 11)
		return true;
	return false;
}

int getDateOfSession(string nameOfFile)
{
	char buf[50];
	ifstream file(nameOfFile);
	for (file >> buf; !file.eof(); file >> buf)
	{
		if (strcmp(buf, "date:") == 0)
		{
			file >> buf;
			return int(buf);
		}
	}
}
bool isDateValid(int subject)
{
	if (subject > 0 && subject < 32)
		return true;
	return false;
}

int getTypeOfTest(string nameOfFile)
{
	char buf[50];
	ifstream file(nameOfFile);
	for (file >> buf; !file.eof(); file >> buf)
	{
		if (strcmp(buf, "testing:") == 0)
		{
			file >> buf;
			if (strcmp(buf, "Exam") == 0)
				return 0;
			else if (strcmp(buf, "Offset") == 0)
				return 1;
		}
	}
}
bool testModuleIsReal(int result)
{
	if (result == 0 || result == 1)
		return true;
	return false;
}

string getNameOfSubject(string nameOfFile)
{
	char buf[50];
	ifstream file(nameOfFile);
	for (file >> buf; !file.eof(); file >> buf)
	{
		if (strcmp(buf, "subject: ") == 0)
		{
			string nameOfSubject;
			file >> buf;
			return string(buf);
		}
	}
}

string getNameOfFile()
{
	cout << "________________________________________\n";
	cout << "Please, enter the name of your file: ";
	char buf[50];
	cin.getline(buf, 50);
	string nameOfFile = _strdup(buf);
	ifstream file(nameOfFile);
	if (!file.is_open())
		cout << "There's no such file.\n";
	else return nameOfFile;
}

void getValues(string nameOfFile, int* arrayOfIntValue)
{
	arrayOfIntValue[0] = getAmmountOfGroups(nameOfFile);
	arrayOfIntValue[1] = getDateOfSession(nameOfFile);
	arrayOfIntValue[2] = getTypeOfTest(nameOfFile);
}

void module1_1()
{
    string nameOfFile = getNameOfFile();
	int* arrayOfIntValue = new int[3];
	getValues(nameOfFile, arrayOfIntValue);
	string nameOfSubject = getNameOfSubject(nameOfFile);
}


void main()
{
	
}
