package com.company;

public class Main
{

    public static double derivF(double x, double y)
    {
        return 5.0;
    }
    public static void Eyler(double x0, double xn, double y0, double h)
    {
        int n = (int)((xn - x0)/h + 1);
        double[] X = new double[n];
        double[] Y = new double[n];
        X[0] = x0;
        Y[0]= y0;
        for(int i = 1; i < n; i++)
        {
            Y[i] = Y[i - 1] + h * derivF(X[i - 1],Y[i - 1]);
            X[i] = X[i - 1] + h;
        }
    }
    public static void main(String[] args)
    {
        Eyler(0, 10, 1, 0.25);


    }
}
