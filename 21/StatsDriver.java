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

		System.out.println("test mean(double,double)");
		System.out.println(Stats.mean(3.4,3.2) + " ...should be 3.3");
                System.out.println(Stats.mean(0.0,3.2) + " ...should be 1.6");
                System.out.println(Stats.mean(-3.4,-3.2) + " ...should be -3.3");
                System.out.println(Stats.mean(3.0,4.0) + " ...should be 3.5"); 
                System.out.println(Stats.mean(2.0,4.0) + " ...should be 3");

		System.out.println("test max(int, int)");
		System.out.println(Stats.max(4,3) + " ...should be 4");
                System.out.println(Stats.max(3,4) + " ...should be 4");
                System.out.println(Stats.max(3,3) + " ...should be 3");
                System.out.println(Stats.max(-4,-3) + " ...should be -3");


		System.out.println("test max(double, double)");
		System.out.println(Stats.max(4.0,

	}
}

