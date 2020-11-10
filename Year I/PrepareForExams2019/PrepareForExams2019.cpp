#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <time.h>
#include <Windows.h>
#include <conio.h>
using namespace std; 
 
vector <string> openFile(string name)
{
	vector <string> toReturn; 
	ifstream file(name, ios::binary);
	string myString;
	while (getline(file, myString))
	{
		if (myString.size() > 0)
		{
			toReturn.push_back(myString);
		}
	}
	return toReturn;
}
void prepareExam(string name, int subject)
{
	int size = 0;
	vector <string> values = openFile(name);
	bool back = false; 
	while (back != true)
	{
		system("cls");
		cout << "-------------------------------------" << endl;
		cout << "| 1. �������� �������               |" << endl;
		cout << "| 2. ������ �������                |" << endl;
		cout << "| 3. ������� �� �������             |" << endl;
		cout << "| 4. �����������                    |" << endl;
		cout << "-------------------------------------" << endl;
		int number; 
		cin >> number;
		cin.ignore();
		if (number == 1)
		{
			int defaultValue; 
			if (subject == 0)
			{
				defaultValue = rand() % 55;
				cout << values[defaultValue] << endl;
			}
			else
			{
				if (subject == 1)
				{
					defaultValue = rand() % 90;
					cout << values[defaultValue] << endl;
				}
			}				
			_getch();
		}
		else if (number == 2)
		{
			int defaultValue;
			cout << "������ �����: ";
			cin >> defaultValue; 
			if (subject == 0)
			{
				cout << values[rand() % defaultValue] << endl;
			}
			else
			{
				if (subject == 1)
				{
					cout << values[rand() % defaultValue] << endl;
				}
			}
			_getch();
		}
		else if (number == 3)
		{
			cout << "����� �������?" << endl;
			int question;
			cin >> question;
			cin.ignore();
			cout << values[question-1]<<endl;
			_getch();
		}
		else if (number == 4)
		{
			back = true;
		}
	}	
}

void menu()
{
	bool exit = false; 
	while (exit != true)
	{
		cout << "-------------------------------------" << endl;
		cout << "| �� ���� �� ��������?            |"<<endl;
		cout << "| 1. ���                           |"<<endl;
		cout << "| 2. ������                       |" << endl;
		cout << "| �����                            |" << endl;
		cout << "-------------------------------------" << endl;
		int number;
		cin >> number; 
		cin.ignore();
		switch (number)
		{
		case 1: 
			prepareExam("c:/����������.txt", 0);
			break;
		case 2: 
			prepareExam("c:/�������������.txt", 1);
			break;
		default:
			exit = true;
			break;
		}
	}
}

int main()
{
	srand(time(NULL));
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	menu();
	
}


