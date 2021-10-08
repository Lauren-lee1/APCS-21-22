public class Greet{
	public static void main(String[] args) {
		String greeting;

		BigSib richard = new BigSib ("Word Up");
		BigSib grizz = new BigSib ("Hey ya");
		BigSib dotCom = new BigSib("Sub");
		BigSib tracy = new BigSib("Salutation");
		
		greeting = richard.greet("freshman");
		System.out.println(greeting);
    		greeting = tracy.greet("Dr.Spaceman");
        	System.out.println(greeting);
        	greeting = grizz.greet("Koey Fooey");
        	System.out.println(greeting);
        	greeting = dotCom.greet("mom");
        	System.out.println(greeting);
	} //end main()
}
