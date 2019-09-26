#include <iostream>
#include <cmath>
using namespace std;
struct Point {
	int x, y;
};
void fillPoint(Point &point1, Point &point2, Point &point3) {
	cout << "Coordinates of  point A: ";
	cin >> point1.x >> point1.y;
	cout << "Coordinates of point B: ";
	cin >> point2.x >> point2.y;
	cout << "Coordinates of point C: ";
	cin >> point3.x >> point3.y;
}
float calculateArea(float lengthsArray[]) {
	float perimeter = (lengthsArray[0]+ lengthsArray[1]+ lengthsArray[2])/2;
	float formulaGerona = sqrt(perimeter * (perimeter - lengthsArray[0]) * (perimeter - lengthsArray[1]) * (perimeter - lengthsArray[2]));
	return formulaGerona;
}

bool isTriangle(Point point1, Point point2, Point point3, float lengthsArray[]) {
	lengthsArray[0] = sqrt(pow((point2.x - point1.x), 2) + pow((point2.y - point1.y), 2));
	lengthsArray[1] = sqrt(pow((point3.x - point2.x),2) + pow((point3.y - point2.y),2));
	lengthsArray[2] = sqrt(pow((point1.x - point3.x), 2) + pow((point1.y - point3.y), 2));
	if (lengthsArray[0]+ lengthsArray[1]< lengthsArray[2])
		return false;
	if (lengthsArray[1]+ lengthsArray[2]< lengthsArray[0])
		return false;
	if (lengthsArray[2]+ lengthsArray[0]< lengthsArray[1])
		return false;
	else return true;
}
void main()
{
	Point point1, point2, point3;
	float lengthsArray[3];
	fillPoint(point1, point2, point3);
	if (isTriangle(point1, point2, point3, lengthsArray)) {
		cout<<calculateArea(lengthsArray);
	}
	else cout << "Such triangle doesn't exist" << endl;
}