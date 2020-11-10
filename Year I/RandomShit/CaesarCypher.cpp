#include <iostream>
#include <cstring>
#include <time.h>

using namespace std;

string getString()
{
	cout << "------------------------------------" << endl;
	cout << "|   What's your string?            |" << endl;
	cout << "------------------------------------" << endl;
	string myString;
	cin >> myString;
	cin.ignore();
	return myString;
}

void printResult(string source, string destination, bool isEncryption)
{
	if (isEncryption)
	{
		cout << "------------------------------------" << endl;
		cout << "|   Your line: " << source << endl;
		cout << "|   Encrypted line: " << destination << endl;
		cout << "------------------------------------" << endl;
		cout << "\n\n\n";
	}
	else
	{
		cout << "------------------------------------" << endl;
		cout << "|   Your encrypted line: " << source << endl;
		cout << "|   Decrypted line: " << destination << endl;
		cout << "------------------------------------" << endl;
		cout << "\n\n\n";
	}
}

int getStepCaesar()
{
	cout << "------------------------------------" << endl;
	cout << "|   Enter step of encryption: " << endl;
	cout << "------------------------------------" << endl;
	int step; 
	cin >> step;
	cin.ignore();
	return step;
}
string mainEncryptionCaesar(string source)
{
	int step = getStepCaesar();
	char buf[50];
	for (int i = 0; i < source.size(); ++i)
	{
		if (int(source[i] + step > 122))
		{
			buf[i] = 96 + (step-(122 - source[i]));
		}
		else
		{
			buf[i] = source[i] + step;
		}
		buf[i + 1] = '\0';
	}
	return buf;
}
void encryptMessageCaesar()
{
	string myString = getString();
	string encryptedString = mainEncryptionCaesar(myString);
	printResult(myString, encryptedString, true);
}
string mainDecryptionCaesar(string source)
{
	int step = getStepCaesar();
	char buf[50];
	for (int i = 0; i < source.size(); ++i)
	{
		if (int(source[i] - step < 97))
		{
			buf[i] = 123 - (step - (source[i]-97));
		}
		else
		{
			buf[i] = source[i] - step;
		}
		buf[i + 1] = '\0';
	}
	return buf;
}
void decryptMessageCaesar()
{
	string myString = getString();
	string decryptedString = mainDecryptionCaesar(myString);
	printResult(myString, decryptedString, false);
}
void menuCaesar()
{
	bool exit = false; 
	while (exit != true)
	{
		cout << "------------------------------------" << endl;
		cout << "|   Welcome to Caesar Encryptor.   |" << endl;
		cout << "------------------------------------" << endl;
		cout << "|   Available options:             |" << endl;
		cout << "|   Encrypt message                |" << endl;
		cout << "|   Decrypt message                |" << endl;
		cout << "|   Exit                           |" << endl;
		cout << "------------------------------------" << endl;
		char buf[50];
		cin.getline(buf, 50);
		if (strcmp(buf, "encrypt") == 0)
		{
			encryptMessageCaesar();
		}
		else if (strcmp(buf, "decrypt") == 0)
		{
			decryptMessageCaesar();
		}
		else if (strcmp(buf, "exit") == 0)
		{
			exit = true;
		}
	}
}


int main()
{
	srand(time(NULL));
	menuCaesar();
}
