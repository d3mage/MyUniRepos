package com.company;

public class List
{
  private class ListNode
  {
     Integer data;
     ListNode next;

     ListNode(Integer data)
     {
       this.data = data;
     }
  }

  private ListNode firstNode;
  private  int size = -1;

  public int GetSize()
  {
    return size;
  }

  public boolean isEmpty()
  {
    return firstNode == null;
  }

  public boolean addFirst(int value)
  {
    ListNode node = new ListNode(value);
    node.next = firstNode;
    firstNode = node;
    size++;
    return true;
  }
  public boolean addLast(int value)
  {
    ListNode node = new ListNode(value);
    ListNode currentNode = firstNode;
    if(isEmpty())
    {
        firstNode = node;
    }
    else
    {
      while (currentNode.next != null)
        currentNode = currentNode.next;
      currentNode.next = node;
    }
    size++;
    return true;
  }
  public boolean addIndex(int value, int index)
  {
    if (index < 0 || index > size) return false;
    if (index == 0) addFirst(value);
    if (index == size) addLast(value);

    ListNode node = new ListNode(value);
    ListNode current = firstNode;

    for (int i = 1; i < index; ++i)
    {
      current = current.next;
    }
    node.next = current.next;
    current.next = node;
    size++;
    return  true;
  }

  public Integer deleteFirst()
  {
    if(isEmpty()) return null;

    int temp = firstNode.data;
    firstNode = firstNode.next;
    size--;
    return temp;
  }
  public Integer deleteLast()
  {
    if(isEmpty()) return null;
    if(firstNode.next == null) deleteFirst();

    ListNode current = firstNode;
    while (current.next.next != null)
      current = current.next;
    int temp = current.next.data;
    current.next = null;
    size--;
    return  temp;
  }
  public Integer deleteIndex(int index)
  {
    if(index < 0 || index >= size) return null;
    if(index == 0) deleteFirst();
    if(index == size)  deleteLast();

    ListNode current = firstNode;
    for(int i = 1; i < index; ++i)
    {
      current = current.next;
    }

    int temp = current.next.data;
    current.next = current.next.next;
    size--;
    return temp;
  }

  public Integer getIndex(int index)
  {
    if(index < 0 || index >= size) return null;

    ListNode current = firstNode;
    for(int i = 0; i < index; ++i)
    {
      current = current.next;
    }
    return current.data;
  }

  public void Show()
  {
    ListNode currentNode = firstNode;
    for (int i = 0; i <= size; ++i)
    {
      System.out.printf("%d ", currentNode.data);
      currentNode = currentNode.next;
    }
    System.out.println();
  }
}
