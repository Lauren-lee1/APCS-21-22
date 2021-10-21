public class Stats{
	public static int mean(int a, int b){
		int mean = (a+b)/2;
		return mean;
	}

	public static double mean(double a, double b) {
		double mean = (a+b)/2;
		return mean;
	}

	public static int max(int a, int b) {
		if (a>b) {
			return a;
		} else{
			return b;
		}
	}

	public static double max(double a, double b) {
		if (a>b) {
			return a;
		} else{
			return b;
		}
	}

	public static int geoMean(int a, int b) {
		int geomean = Math.round(Math.round(Math.sqrt(a*b)));
		return geomean;
	}

	public static double geoMean(double a, double b) {
		double geomean = Math.sqrt(a*b);
		return geomean;
	}

}
