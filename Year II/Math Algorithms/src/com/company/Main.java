package com.company;

public class Main {

    public static double integralFunction(double value)
    {
        return Math.pow(value, 3) * Math.sqrt(Math.pow(value, 2) - 1);
    }

    public static double rectangleMethodL(double a, double b, double step)
    {
        double sum = 0.0;
        double x = a;
        int n = (int)((b - a)/step);
        for(int i = 0; i < n; i++)
        {
            sum += integralFunction(x + i * step);
        }
        return sum * step;
    }

    public static double rectangleMethodR(double a, double b, double step)
    {
        double sum = 0.0;
        double x = a;
        int n = (int)((b - a)/step);
        for(int i = 1; i <= n; i++)
        {
            sum += integralFunction(x + i * step);
        }
        return sum * step;
    }

    public static double rectangleMethodM(double a, double b, double step)
    {
        double sum = 0.0;
        double x = a + step/2;
        int n = (int)((b - a)/step);
        for(int i = 0; i < n; i++)
        {
            sum += integralFunction(x + i * step);
        }
        return sum * step;
    }

    public static double trapezoidMethod(double a, double b, double step)
    {
        double sum = (integralFunction(b) + integralFunction(a))/2;
        int n = (int)((b - a) / step);
        double current;

        for (int i = 1; i < n; i++)
        {
            current = a + step * i;
            sum += integralFunction(current);
        }

        return sum * step;
    }

    public static double simpsonsMethod(double a, double b, double step)
    {
        int n = (int) ((b - a) / step);
        double sum = integralFunction(b) + integralFunction(a);
        double subSum = 0;
        double x;
        for (int i = 1; i < n; i += 2)
        {
            x = a + step * i;
            subSum += integralFunction(x);
        }
        subSum *= 4;
        sum += subSum;
        subSum = 0;
        for (int i = 2; i < n - 1; i += 2)
        {
            x = a + step * i;
            subSum += integralFunction(x);
        }
        subSum *= 2;
        sum += subSum;
        return sum * step / 3;
    }

    public static double f(double value)
    {
        return Math.pow(value, 2) - 1 - Math.cos(1.2 * value);
    }
    public static double halfDivision(double a, double b, double ebs){
        double x = (a + b)/2;
        while(Math.abs(f(x)) > ebs)
        {
            if(f(a) * f(x) < 0)
            {
                b = x;
            }
            else if(f(b) * f(x)<0)
            {
                a = x;
            }
            x = (a + b)/2;
        }
        return x;
    }
    private static double firstDerivative(double x)
    {
        return 2 * x + 1.2 * Math.sin(1.2 * x);
    }
    private static double secondDerivative(double x)
    {
        return 1.44 * Math.cos(1.2 * x) + 2;
    }
    public static double methodNewton(double a, double b, double ebs)
    {
        double x;
        if(f(a) * secondDerivative(a) > 0)
        {
            x = a;
        }
        else
        {
            x = b;
        }
        while(Math.abs(f(x)) > ebs)
        {
            x = x - f(x)/firstDerivative(x);
        }
        return x;
    }

    public static double methodChord(double a, double b, double ebs)
    {
        double x;
        if (f(a) * secondDerivative(a) > 0)
        {
            x = a;
            while (Math.abs(f(x)) > ebs)
            {
                x = x - (b - x) * f(x) / (f(b) - f(x));
            }
        }
        else
        {
            x = b;
            while (Math.abs(f(x)) > ebs)
            {
                x = x - (x - a) * f(x) / (f(x) - f(a));
            }
        }
        return x;
    }

    public static String Eyler(double x0, double xn, double y0, double h)
    {
        StringBuilder sb = new StringBuilder();

        int n = (int)((xn - x0)/h + 1);
        double[] X = new double[n];
        double[] Y = new double[n];
        X[0] = x0;
        Y[0]= y0;
        for(int i = 1; i < n;i++)
        {
            Y[i] = Y[i - 1] + h * derivF(X[i - 1],Y[i - 1]);
            X[i] = X[i - 1] + h;
            sb.append("X: ");
            sb.append(String.format("%.2g", X[i]));
            sb.append(" Y:");
            sb.append(String.format("%.4g%n", Y[i]));
        }
        return sb.toString();
    }
    public static double derivF(double x, double y)
    {
        return Math.cos(x - y);
    }

    public static void main(String[] args)
    {
        int a = 1, b = 3;
        double step = 0.25;

        System.out.println("Rectangle method left: " + rectangleMethodL(a, b, step));
        System.out.println("Rectangle method right: " + rectangleMethodR(a, b, step));
        System.out.println("Rectangle method centre: " + rectangleMethodM(a, b, step));
        System.out.println("Trapezoid method: " + trapezoidMethod(a, b, step));
        System.out.println("Simpson's method: " + simpsonsMethod(a, b, step));

        System.out.println("Half division method: " + halfDivision(0, 10, 0.00000000001));
        System.out.println("Newton method: " + methodNewton(0, 10, 0.00000000001));
        System.out.println("Secant method: " + methodChord(1, 10, 0.00000000001));

          System.out.println("Eyler method: \n" + Eyler(0, 10, 1, 0.25));
    }
}
