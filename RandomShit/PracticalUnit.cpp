#include <iostream>
using namespace std;

void ArrayEnterNumbers(double *myArray, int size) {
	for (int i = 0; i < size; i++) {
		cout << "Enter " << i+1 << " element: ";
		cin >> myArray[i];
	}
}
void ArrayPrintNumbers(double* myArray, int size) {
	for (int i = 0; i < size; i++) {
		cout <<"Element "<<i+1<<": "<< myArray[i]<<endl;
	}
}

bool IsSame(double *myArray) {	
	if ((myArray[0] == myArray[1]) && (myArray[1] == myArray[2]))
	   return true;
	else return false;
}
void Task11(double *myArray) {
	ArrayEnterNumbers(myArray, 3);
	if (IsSame(myArray))
		cout << "All numbers are the same." << endl;
	else cout << "Numbers are not the same." << endl;
}


bool IsLowerThanNext(double* myArray) {	
	if ((myArray[0] <= myArray[1])&&(myArray[1]<=myArray[2])&&(myArray[2]<=myArray[3]))
		return true;
	else return false;
}
void Task12(double* myArray) {
	ArrayEnterNumbers(myArray, 4);
	if (IsLowerThanNext(myArray))
		cout << "Equation is true" << endl;
	else cout << "Equation is false" << endl;
}


void MakeCorrectOrder(double *myArray) {	
	for (int i = 0; i < 3; i++) {
		bool isSorted = true;
		for (int j = 0; j < 3 - (i + 1); j++) {
			if (myArray[j] > myArray[j + 1]) {
				isSorted = false;
				swap(myArray[j], myArray[j + 1]);
			}
		}
		if (isSorted) 
		 break;
	}
}
void Task13(double *myArray) {
	ArrayEnterNumbers(myArray, 3);
	MakeCorrectOrder(myArray);
	cout << "New order: " << endl;
	ArrayPrintNumbers(myArray, 3);
}


void AllNumbersAreHigherThan0(double *myArray) {
	for (int i = 0; i < 4; i++) {
		if (myArray[i] < 0)
			myArray[i] = -(myArray[i]);
	}
}
bool IsSimiliar(double *myArray) {
	for (int i = 0; i < 3; i++) {
		for (int j = i+1; j < 4; j++) {
			if (myArray[i] == myArray[j]) {   
				break;                      
				return true;
			}
		}
	}
	return false;
}
void Task14(double *myArray) {
	ArrayEnterNumbers(myArray, 4);
	AllNumbersAreHigherThan0(myArray);
	if (IsSimiliar(myArray))
		cout << "There's equal modules";
	else cout << "There's no similiar modules";
}

bool IsAnyNegatives(double* myArray) {
	for (int i = 0; i < 3; i++) {
		if (myArray[i] < 0) {			
			return true;
			break;
		}
		else return false;
	}
}
double CountSum(double* myArray) {
	double tempSum = 0;
	for (int i = 0; i < 3; i++) 
		tempSum += myArray[i];
	return tempSum;
}
double CountMultiplication(double* myArray) {
	double tempMlpl = 1;
	for (int i = 0; i < 3; i++)
		tempMlpl *= myArray[i];
	return tempMlpl;
}
void Task15(double *myArray) {
	ArrayEnterNumbers(myArray, 3);
	double sum = CountSum(myArray);
	cout << "Sum of this numbers: " << sum << endl;
	if (IsAnyNegatives(myArray)) {
		double mltpl = CountMultiplication(myArray);
		cout << "Multiplication of this numbers: " << mltpl << endl;
	}
}


double SumOfOnlyPositive(double* myArray, int &size) {
	double tempSum = 0;
	for (int i = 0; i < 4; i++) {
		if (myArray[i] > 0) {
			tempSum += myArray[i];
			size++;
		}
	}
	return tempSum;
}
void Task16(double* myArray) {
	int size = 0;
	ArrayEnterNumbers(myArray, 4);
	double sum = SumOfOnlyPositive(myArray, size);
	double ariphmetical = sum / size;
	cout << "Sum: " << sum << "\nAriphmetical: " << ariphmetical << endl;
}

void main()
{
	double *ThreeElements = new double[3];
	double *FourElements = new double[4];

	Task16(FourElements);


}