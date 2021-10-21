/**
Clueless Cats: Vansh saboo + Tiffany, Lauren Lee + Bo, Diana Akhmedova + Ajax
APCS
HW21: STAtisTically Speaking...
2021-10-20
**/

/**
DISCO
- to convert a double to an integer, round the double twice
- when the square root of a negative integer is found, the result is 0
QCC
- how do I write a method to find the square root of a number without using Math.sqrt or Math.pow
**/

public class StatsDriver{
	public static void main(String[] args) {
		System.out.println("test mean(int, int)");
		System.out.println(Stats.mean(4,4) + " ...should be 4");
                System.out.println(Stats.mean(0,4) + " ...should be 2");
                System.out.println(Stats.mean(-3,4) + " ...should be 0");
                System.out.println(Stats.mean(4,2) + " ...should be 3");
                System.out.println(Stats.mean(-3,-4) + " ...should be -3");
		System.out.println(" "+5/3);
		System.out.println(" "+6/3);

		System.out.println("---------------------------------------------");
		System.out.println("test mean(double,double)");
		System.out.println(Stats.mean(3.4,3.2) + " ...should be 3.3");
                System.out.println(Stats.mean(0.0,3.2) + " ...should be 1.6");
                System.out.println(Stats.mean(-3.4,-3.2) + " ...should be -3.3");
                System.out.println(Stats.mean(3.0,4.0) + " ...should be 3.5");
                System.out.println(Stats.mean(2.0,4.0) + " ...should be 3");

		System.out.println("--------------------------------------------");
		System.out.println("test max(int, int)");
		System.out.println(Stats.max(4,3) + " ...should be 4");
                System.out.println(Stats.max(3,4) + " ...should be 4");
                System.out.println(Stats.max(3,3) + " ...should be 3");
                System.out.println(Stats.max(-4,-3) + " ...should be -3");


		System.out.println("------------------------------------------");
		System.out.println("test max(double, double)");
		System.out.println(Stats.max(4.0,3.0) + " ... should be 4.0");
		System.out.println(Stats.max(4.0, -3.0) + " ...should be 4");
		System.out.println(Stats.max(-4.0,-3.0) + " ...should be -3");
		System.out.println(Stats.max(0.0,0.0) + " ... should be 0");
		System.out.println(Stats.max(3.1,4.2) + " ...should be 4.2");

		System.out.println("----------------------------------------");
		System.out.println("test geoMean(int a, int b)");
		System.out.println(Stats.geoMean(12,3) + " ...should be 6");
		System.out.println(Stats.geoMean(4,4) + " ...should be 4");
		System.out.println(Stats.geoMean(3,4) + "... should be 3");
		System.out.println(Stats.geoMean(-3,4) + " ...should be undefined");
		System.out.println(Stats.geoMean(-3,-4) + " ...should be 3");

		System.out.println("----------------------------------------");
		System.out.println("test geoMean(double a, double b)");
		System.out.println(Stats.geoMean(12.0,3.0) + " ...should be 6");
		System.out.println(Stats.geoMean(4.0,4.0) + " ...should be 4");
		System.out.println(Stats.geoMean(-3.0,-4.0) + " ...should be 3.4641016151377544");
		System.out.println(Stats.geoMean(4.2,4.3) + " ...should be 4.249705872175156");
	}
}

