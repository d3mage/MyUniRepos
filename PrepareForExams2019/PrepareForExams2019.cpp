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
		cout << "----------------------------------" << endl;
		cout << "1. �������� �������" << endl;
		cout << "2. ������� �� �������" << endl;
		cout << "3. �����������" << endl;
		cout << "----------------------------------" << endl;
		int number; 
		cin >> number;
		cin.ignore();
		if (number == 1)
		{
			if (subject == 0)
			{
				cout << values[rand() % 55] << endl;
			}
			else
			{
				if (subject == 1)
				{
					cout << values[rand() % 90] << endl;
				}
			}				
			_getch();
		}
		else if (number == 2)
		{
			cout << "����� �������?" << endl;
			int question;
			cin >> question;
			cin.ignore();
			cout << values[question-1]<<endl;
		}
		else if (number == 3)
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
		cout << "----------------------------------" << endl;
		cout << "�� ���� �� ��������?"<<endl;
		cout << "1. ���"<<endl;
		cout << "2. ������" << endl;
		cout << "�����" << endl;
		cout << "----------------------------------" << endl;
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


