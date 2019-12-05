#define SizeOfStack 15
#include <iostream>
#include <string>
#include<time.h>
using namespace std;

struct Stack
{
	float Element[SizeOfStack];
	int TopOfStack = 0;
};

void push(Stack &MyStack)
{
	int ammOfIterations = rand() % 9 + 1;
	for (int i = 0; i < ammOfIterations; ++i)
		if (MyStack.TopOfStack < SizeOfStack)
		{
			MyStack.Element[MyStack.TopOfStack] = rand() % 100 / 10.;
			MyStack.TopOfStack++;
		}
}

void pop(Stack &MyStack)
{
	int ammOfIterations = rand() % 9+1;
	while (ammOfIterations>MyStack.TopOfStack)
	{
		ammOfIterations = rand() % 9 + 1;
	}
	float* arrayToDelete = new float[ammOfIterations];
	for (int i = 0; i < ammOfIterations; i++)
	{
		if (MyStack.TopOfStack != 0)
		{
			 arrayToDelete[i]= MyStack.Element[MyStack.TopOfStack];
			MyStack.TopOfStack--;
		}

	}
	delete[] arrayToDelete;
		
}

struct Queu
{
	int data;
	Queu* pnext;
};
struct queue
{
  Queu* new_element;
  Queu* head = 0;
  Queu* current;
  Queu* del_element;
  int ammountOfIterations = rand() % 9 + 1;
  void push()
  {	  
	  for (int i = 0; i < ammountOfIterations; i++)
	  {
		  new_element = new Queu;
		  new_element->data = rand() % 15;
		  new_element->pnext = 0;
		  if (head == 0)
			  head = new_element;
		  else
		  {
			  current = head;
			  while (current->pnext != 0)
				  current = current->pnext;
			  current->pnext = new_element;
		  }
	  }
  }

  void pop()
  {
	  for (int i = 0; i < ammountOfIterations / 2; i++)
	  { 
		  if (head->pnext != 0)
		  {
			  del_element = head;
			  head = head->pnext;
			  delete del_element;
		  }
	  }		 
  }
};

struct Node
{             
	float value;          
	Node* next, * prev;     
};

struct deque
{
	Node* head = nullptr;    
	Node* tail = nullptr;


	void push_back(float num)
	{
		Node* element = new Node; 
		element->value = num;
		if (!head)
		{         
			head = element;      
			tail = head;     
		}
		else
		{
			element->prev = tail; 
			tail->next = element;
			tail = element;      
		}
	}

	void push_front(float num) {
		Node* element = new Node;
		element->value = num;
		if (!head)
		{
			head = element;
			tail = head;
		}
		else 
		{
			element->next = head;    
			head->prev = element;      
			head = element;          
		}

	}
	void pop_back()
	{
		if (head)
		{  
			Node* element = tail;     
			tail = tail->prev;
			tail->next = nullptr;     
			delete element;          
		}
		else if (head == tail)
		{
			head->next = nullptr;
			head = nullptr;
			delete head;
		}
	}
	void pop_front()
	{
		if (head)
		{
			if (head->next)
			{         
				Node* element = head; 
				head = head->next;
				head->prev = nullptr; 
				delete element;          
			}
			else if (head == tail)
			{  
				head->next = nullptr;
				head = nullptr;       
				delete head;               
			}
		}
	}	
};

void main()
{
	srand(time(NULL));
	
} 