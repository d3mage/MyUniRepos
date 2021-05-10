package com.company;

import java.time.LocalDate;

public class BSTR
{
    class Node
    {
        Student student;
        Node left;
        Node right;
        int countNodes;

        Node(Student student)
        {
            this.student = student;
        }
    }
    private Node root;

    public void insert(Student newElem)
    {
        root = insertTree(root, newElem);
    }
    private Node insertTree(Node current, Student newElem)
    {
        if(current == null)
        {
            Node newNode = new Node(newElem);
            newNode.countNodes = 1;
            return newNode;
        }
        if(Math.random()*current.countNodes<1.0)
        {
            current = insR(current, newElem);
        }
        else if(newElem.ExpirationDate.isBefore(current.student.ExpirationDate))
        {
            current.left = insertTree(current.left, newElem);
        }
        else{
            current.right = insertTree(current.right, newElem);
        }
        current.countNodes++;
        return current;
    }

    private Node insR(Node current, Student newElem)
    {
        current = insertRoot(current, newElem);
        current.countNodes = current.countNodes - 1;
        return current;
    }
    private Node insertRoot(Node current, Student newElem)
    {
        if (current == null)
        {
            Node node = new Node(newElem);
            node.countNodes = 1;
            return node;
        }
        if(newElem.ExpirationDate.isBefore(current.student.ExpirationDate)){
            current.left = insertRoot(current.left, newElem);
            current.countNodes = current.countNodes - current.left.countNodes;
            current = rotationR(current);
            current.right.countNodes = count(current.right);
        }
        else
        {
            current.right = insertRoot(current.right, newElem);
            current.countNodes = current.countNodes - current.right.countNodes;
            current = rotationL(current);
            current.left.countNodes = count(current.left);
        }
        current.countNodes = count(current);
        return current;
    }

    private int count(Node current)
    {
        if (current.left!= null)
        {
            if(current.right != null)
                current.countNodes = current.left.countNodes + current.right.countNodes;
            else
                current.countNodes = current.left.countNodes;
        }
        else if(current.right != null)
            current.countNodes = current.right.countNodes;
        return ++current.countNodes;
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
        if(current == null){ return null; }
        if(current.student.ExpirationDate.isEqual(key)) return current;
        if(current.left != null)
        {
            current = findNode(current.left, key);
        }
        else if(current.right != null)
        {
            current = findNode(current.right, key);
        }
        return current;
    }

}