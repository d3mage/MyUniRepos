#include "PracticalUnit.h"
#include <iostream>
using namespace std; 

struct List
{
	Node* head = nullptr;
	Node* current;
	int ammountOfIterations = 10;
	void push(char myArray[])
	{
		for (int i = 0; i < ammountOfIterations; ++i)
		{
			Node* new_element = new Node;
			new_element->data = 'a';
			new_element->pnext = nullptr;
			if (head == 0)
			{
               head = new_element;
			   new_element->position = i; 
			}				
			else
			{
			new_element->position = i;
			current = head;
			while (current->pnext != 0)
			{
				current = current->pnext;
			}					
			current->pnext = new_element;
			}
		}
	}

	void findPositions(char myArray[])
	{
		int k = 0;
		Node* element  = head;
		for (int i = 0; i < ammountOfIterations; ++i)
		{
		if (element->pnext != 0)
		   {
			if (element->position % 2 == 0)
			{
				myArray[k++] = element->data;
			}
			element = element->pnext; 
		   }			
		}
	}



};

	





void main()
{
	List* FirstList = NULL;
	List* SecondList = NULL; 
	char elements[8]{'a', 'c', 'd', 't', 'e', 'o', 'p', 'z'};
	FirstList->push(elements);
	SecondList->findPositions(elements);
	SecondList->push(elements);
}