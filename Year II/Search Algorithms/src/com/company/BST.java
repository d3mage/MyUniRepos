package com.company;

import java.time.LocalDate;

public class BST
{
    class Node
    {
        Student student;
        Node left;
        Node right;

        Node(Student student)
        {
            this.student = student;
        }
    }

    private Node root;
    public void insert(Student newElem)
    {
        root = insertNode(root, newElem);
    }
    private Node insertNode(Node current, Student newElem)
    {
        if (current == null)
        {
            return new Node(newElem);
        }
        if(newElem.ExpirationDate.isBefore(current.student.ExpirationDate))
        {
            current.left = insertNode(current.left, newElem);
            current = rotationR(current);
        }
        else
        {
            current.right = insertNode(current.right, newElem);
            current = rotationL(current);
        }
        return current;
    }

    private Node rotationR(Node current)
    {
        Node temp = current.left;
        current.left = temp.right;
        temp.right = current;
        current = temp;
        return current;
    }

    private Node rotationL(Node current)
    {
        Node temp = current.right;
        current.right = temp.left;
        temp.left = current;
        current = temp;
        return current;
    }
    public void find(LocalDate key)
    {
        System.out.println("Element with key "+key);
        Node findN = findNode(root, key);
        if(findN == null){
            System.out.println("No elements with such key!");
        }
        else
        {
            System.out.println(findN.student.toString());
        }
    }
    private Node findNode(Node current, LocalDate key)
    {
        if (current == null)
        {
            return null;
        }
        if (current.student.ExpirationDate.isBefore(key))
        {
            current = findNode(current.left, key);
        }
        else if (current.student.ExpirationDate.isAfter(key))
        {
            current = findNode(current.right, key);
        }
        else return current;
        return current;
    }
}


