#include <iostream>
#include <string>
using namespace std;

struct Node
{             
	float value;          
	Node* next, * prev;     
};

struct deque
{
	Node* head = nullptr;    
	Node* tail = nullptr;
	int count = 0;

	void push_back(float num)
	{
		Node* element = new Node; 
		element->value = num; 
		count++;
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
		count++;
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
		if (count != 0)
		{             
			if (count > 1)
			{        
				Node* element = tail;     
				tail = tail->prev;
				tail->next = nullptr;     
				delete element;   
				count--;        
			}
			else
			{              
				head = tail = 0;      
				count--;       
			}
		}
	}
	void pop_front()
	{
		if (count != 0)
		{
			if (head->next)
			{         
				Node* element = head; 
				head = head->next;
				head->prev = nullptr; 
				delete element;    
				count--;      
			}
			else if (head == tail)
			{  
				head->next = nullptr;
				head = nullptr;       
				delete head;        
				count = 0;        
			}
		}
	}

	void clear()
	{
		count = 0;              
		while (head)             
		{
			tail = head->next;        
			delete head;          
			head = tail;           
		}
	}
	
};

void main()
{
	
	
}



 