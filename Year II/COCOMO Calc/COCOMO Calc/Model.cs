using System;

namespace COCOMO_Calc
{
    public enum ProjectType 
    {
        Organic, 
        Semi_detached, 
        Embedded 
    }

    public class Model
    {
        private static float[,] RatioTable = 
       {
            { 2.4f, 1.05f, 2.5f, 0.38f },
            { 3.0f, 1.12f, 2.5f, 0.35f },
            { 3.6f, 1.20f, 2.5f, 0.32f }
        };


        public static double CalculateEfforts(ProjectType type, int size) =>
            RatioTable[(int)type, 0] * Math.Pow(size, RatioTable[(int)type, 1]);

        public static double CalculateTimeDevelop(ProjectType type, int size) =>
            RatioTable[(int)type, 2] * Math.Pow(CalculateEfforts(type, size), RatioTable[(int)type, 3]);

        public static double CalculatePersonsToDevelop(ProjectType type, int size) =>
            CalculateEfforts(type, size) / CalculateTimeDevelop(type, size);

    }
}

