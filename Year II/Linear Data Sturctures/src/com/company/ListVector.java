package com.company;

public class ListVector
{
    private Integer[] vector;
    private int last;

    public ListVector(int size)
    {
        vector = new Integer[size];
        last = -1;
    }

    public int getSize()
    {
        return  last;
    }

    public boolean isFull()
    {
        return  last == vector.length - 1;
    }
    public boolean isEmpty()
    {
        return last == -1;
    }

    public boolean addFirst(Integer value)
    {
        if(isFull()) return false;

        Integer[] temp = new Integer[vector.length];
        temp[0] = value;
        System.arraycopy(vector, 0, temp, 1, vector.length - 1);
        vector = temp;
        last++;
        return true;
    }
    public boolean addLast(int value)
    {
        if(isFull()) return false;

        vector[++last] = value;
        return true;
    }
    public boolean addIndex(int value, int index)
    {
        if(index < 0 || index > vector.length) return  false;
        if(index == 0) addFirst(value);
        if(index == vector.length) addLast(index);

        Integer[] temp = new Integer[vector.length];
        System.arraycopy(vector, 0, temp, 0, index);
        temp[index] = value;
        if (vector.length - (index + 1) >= 0)
            System.arraycopy(vector, index, temp, index + 1, vector.length - (index + 1));
        vector = temp;
        last++;
        return true;
    }
    public Integer deleteFirst()
    {
        if(isEmpty()) return  null;

        Integer[] temp = new Integer[vector.length];
        Integer toDelete = vector[0];
        System.arraycopy(vector, 1, temp, 0, vector.length - 1);
        vector = temp;
        last--;
        return toDelete;
    }

    public Integer deleteLast()
    {
        if(isEmpty()) return null;

        Integer[] temp = new Integer[vector.length];
        Integer toDelete = vector[last];
        System.arraycopy(vector, 0, temp, 0, vector.length - 1);
        vector = temp;
        last--;
        return  toDelete;
    }
    public Integer deleteIndex(int index)
    {
        if(index < 0 || index >= last) return null;
        if(index == 0) deleteFirst();
        if(index == last) deleteLast();

        Integer[] temp = new Integer[vector.length];
        Integer toDelete = vector[index];
        System.arraycopy(vector, 0, temp, 0, index);
        System.arraycopy(vector, index + 1, temp, index, vector.length - index - 1);
        vector = temp;
        last--;
        return  toDelete;
    }

    public Integer getIndex(int index)
    {
        return vector[index];
    }

    public void Show()
    {
        for (int i = 0; i <= last; ++i)
        {
            System.out.printf("%d ", vector[i]);
        }
        System.out.println();
    }
}
