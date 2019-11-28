#include <iostream>

const int SizeOfStack = 7;
struct Stack
{
	int elements[SizeOfStack];
	int TopOfStack;
};

struct sviazniyStack
{
	int nValue;
	sviazniyStack* pPointer;
};


int main()
{


	int mas[SizeOfStack]{ 1,2,3,45,241,-1, 10 };

	Stack MyStack;
	MyStack.TopOfStack = 0;
	for (int i = 0; i < SizeOfStack; i++)
	{
		if (MyStack.TopOfStack < SizeOfStack)
		{
			MyStack.elements[MyStack.TopOfStack] = mas[i];
			MyStack.TopOfStack++;
		}

	}



	sviazniyStack* top = 0, * element;
	for (int i = 0; i < SizeOfStack; ++i)
	{
		element = new sviazniyStack;
		element->nValue = mas[i];
		element->pPointer = top;
		top = element;
	}
	for (int i = 0; i < 3; i++)
	{
		element = top;
		top = element->pPointer;
		delete element;
	}
}

