package homework1;

public class Sonata1 {

	public static void main(String[] args) {
		car mycar = new car();
		
		mycar.name = "소나타";
		mycar.color = "흰샌";
		mycar.speed = 120;
		mycar.weight = 2;
		
		System.out.println(mycar.name);
		System.out.println(mycar.color);
		System.out.println(mycar.speed+"km");
		System.out.println(mycar.weight+"톤");

	}

}
