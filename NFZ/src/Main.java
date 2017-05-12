
public class Main {

	public static void main(String[] args) {
		
		String[] nazwa = {"Nazwa1", "nazwa2", "nazwa3", "nazwa4", "nazwa5"};
		double[] cena = {2,3,5,20,100};
		double[] refundacja = {0.5,0.1,0.3,0.2,0.1};
		
		Lekarstwa lekarstwa1=new Lekarstwa(nazwa, cena, refundacja);
		
		lekarstwa1.wyswietl();
		
		System.out.println(lekarstwa1.cena("Nazwa1", true));
		System.out.println(lekarstwa1.cena("Nazwa1", false));
		System.out.println(lekarstwa1.maksymalnaRefundacji());
		System.out.println(lekarstwa1.kosztCalkowity());
		

	}

}
