package com.company;

import java.util.ArrayList;

public class BinaryTree
{
    static class Node
    {
        private Student data;
        private Node right;
        private Node left;
        public Node(Student data){this.data = data;}
    }

    private Node root;
    public BinaryTree(){root = null;}

    public void add(Student student)
    {
        root = insert(root, student);
    }

    private Node insert(Node current, Student student){
        if(current == null)
        {
            return new Node(student);
        }
        else
        {
            if(student.GetID() < current.data.GetID()) { current.left = insert(current.left, student);}
            else if(student.GetID()> current.data.GetID()) { current.right = insert(current.right, student);}
        }
        return current;
    }

    public void print (){
        preOrder(root);
    }
    public ArrayList<Student> find()
    {
        ArrayList<Student> list = new ArrayList<>();
        if(root == null)
        {
            System.out.println("Tree is empty");
            return null;
        }
        search(root, list);
        return  list;
    }
    public void delete(){delete(root);}

    private void preOrder (Node current)
    {
        if(current == null){return;}

        System.out.println(current.data.toString());
        preOrder(current.left);
        preOrder(current.right);
    }

    private void search(Node current, ArrayList<Student> list)
    {
        if(current == null){return;}
        if(current.data.GetYear() == 2
                && current.data.GetSex().equals("male")
                && current.data.GetAverage() > 3.5){
            list.add(current.data);
        }
        search(current.left,  list);
        search(current.right, list);
    }

    private void delete(Node current)
    {
        if(current == null) { return;}
        else if(current.data.GetYear() == 2
                && current.data.GetSex().equals("male")
                && current.data.GetAverage() > 3.3)
        {
            if(current.left == null && current.right == null) {current = null;}
            if(current.left != null && current.right != null)
            { current.right = deleteTwoChild(current, current.right);}
            else current = deleteOneChild(current);
        }
        delete(current.left);
        delete(current.right);
    }

    private Node deleteOneChild(Node current)
    {
        if(current.left == null)
        {
            current = current.right;
            return current;
        }
        else if (current.right == null)
        {
            current = current.left;
            return current;
        }
        return null;
    }

    private Node deleteTwoChild(Node deleteNode, Node current){
        if(current.left != null){current.left = deleteTwoChild(deleteNode, current.left);}
        else
        {
            deleteNode.data = current.data;
            current = current.right;
        }
        return current;
    }
}
