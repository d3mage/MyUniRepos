package com.company;

import java.util.Arrays;

public class Main {

    public static void swap(int[] array, int i, int j)
    {
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    public static int[] getData(int size)
    {
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }

    public static void quickPartSort(int[] array, int left, int right)
    {
        if(left >= right) return;
        int value = array[right];
        int i = left, j = right - 1;
        int posL = left, posR = right - 1;
        while (true)
        {
            while(array[i] < value)
            {
                i++;
            }
            while (array[i] > value)
            {
                if(j == left) break;
                j--;
            }
            if(i >= j) break;

            swap(array, i, j);

            if(array[i] == value)
            {
                swap(array, i, posL);
                posL++;
            }
            if(array[j] == value)
            {
                swap(array, j, posR);
                posR--;
            }

            swap(array, i, posR);
            j = i - 1;
            i++;
            if(j < 0) break;
            for(int n = left; n < posL; ++n)
            {
                swap(array, n, j);
                j--;
            }
            for(int n = right - 1; n > posR; --n)
            {
                swap(array, n, i);
                i++;
            }
            quickPartSort(array, left, j);
            quickPartSort(array, i, right);
        }
    }

    public static int partition(int[] array, int left, int right)
    {
        int pivot = array[right];
        int i = left - 1;
        for(int j = left; j <= right - 1; ++j)
        {
            if(array[j] < pivot)
            {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, right);
        return  i + 1;
    }
    public static void quickSort(int[] array, int left, int right)
    {
        if(left >= right) return;
        int pi = partition(array, left, right);
        quickSort(array, left, pi - 1);
        quickSort(array, pi + 1, right);
    }

    public static void executeQuickPartSortAlgorithm(int size)
    {
        double average = 0;
        for(int i = 0; i < 10; ++i)
        {
            int[] data = getData(size);

            long start = System.nanoTime();
            quickPartSort(data, 0, data.length - 1);
            long end = System.nanoTime();

            double time = (double)(end - start)/1000000000;
            average+= time;

            System.out.println(time);
        }
        System.out.println("Average time for size " + size + " : " + average/10);
    }
    public static void executeQuickSortComparisonAlgorithm(int size)
    {
        double averageQPS = 0;
        double averageQS = 0;
        for(int i = 0; i < 10; ++i)
        {
            int[] dataQPS = getData(size);
            int[] dataQS = new int[size];
            System.arraycopy(dataQPS, 0, dataQS, 0, size);

            long startQPS = System.nanoTime();
            quickPartSort(dataQPS, 0, dataQPS.length - 1);
            long endQPS = System.nanoTime();

            long startQS = System.nanoTime();
            quickSort(dataQS, 0, dataQS.length - 1);
            long endQS = System.nanoTime();


            double timeQPS = (double)(endQPS - startQPS)/1000000000;
            double timeQS = (double)(endQS - startQS)/1000000000;

            averageQPS+= timeQPS;
            averageQS+= timeQS;

            System.out.println(timeQPS);
            System.out.println(timeQS);
            System.out.println();
        }
        System.out.println("Average QPS time for size " + size + " : " + averageQPS/10);
        System.out.println("Average QP time for size " + size + " : " + averageQS/10);
    }

    public static int[] getBestPerformanceData(int size)
    {
        int[] arr = new int[size];
        int number = (int)(Math.random()*100);
        Arrays.fill(arr, number);
        return arr;
    }
    public static int[] getSortedData(int size)
    {
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = i;
        }
        return arr;
    }
    public static void executeAlgorithmBestPerfomanceTesting(int size)
    {
        double averageBPD = 0;
        double averageRandom = 0;
        double averageSorted = 0;
        for(int i = 0; i < 10; ++i)
        {
            int[] bestPerformanceData = getBestPerformanceData(size);
            int[] randomData = getData(size);
            int[] sortedData = getSortedData(size);

            long startBPD = System.nanoTime();
            quickPartSort(bestPerformanceData, 0, bestPerformanceData.length - 1);
            long endBPD = System.nanoTime();

            double timeBPD = (double)(endBPD - startBPD)/1000000000;
            averageBPD+= timeBPD;


            long startRandom = System.nanoTime();
            quickPartSort(randomData, 0, randomData.length - 1);
            long endRandom = System.nanoTime();

            double timeRandom = (double)(endRandom - startRandom)/1000000000;
            averageRandom+= timeRandom;

            long startSorted = System.nanoTime();
            quickPartSort(sortedData, 0, sortedData.length - 1);
            long endSorted = System.nanoTime();

            double timeSorted = (double)(endSorted - startSorted)/1000000000;
            averageSorted+= timeSorted;

            System.out.println(timeBPD);
            System.out.println(timeRandom);
            System.out.println(timeSorted);
            System.out.println();
        }
        System.out.println("Average time for best performance data: " + averageBPD/10);
        System.out.println("Average time for random data: " + averageRandom/10);
        System.out.println("Average time for sorted data: " + averageSorted/10);
    }
    public static void main(String[] args)
    {
        //executeQuickPartSortAlgorithm(100 * 100 * 100);
        //executeQuickSortComparisonAlgorithm(100 * 100 * 100);
        executeAlgorithmBestPerfomanceTesting(10000);
    }
}