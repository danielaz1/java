
public class Lekarstwa {
	
	String[] nazwa;
	double[] cena;
	double[] refundacja;
	
	public Lekarstwa(String[] nazwa, double[] cena, double[] refundacja) {
		String n;
		for (int i=0; i<nazwa.length; i++){
		n = nazwa[i].substring(0,1).toUpperCase() + nazwa[i].substring(1).toLowerCase();
		nazwa[i]=n;
		}
		this.nazwa = nazwa;
		this.cena = cena;
		this.refundacja = refundacja;
	}
	
	public double cena(String lek, boolean ubezpieczony){
		int ind=0;
		for (int i=0; i<nazwa.length; i++){
			if (nazwa[i]==lek){
				ind=i;
				break;
			}
		}
		return ubezpieczony ? cena[ind]-cena[ind]*refundacja[ind] : cena[ind];
	}

	
	public String maksymalnaRefundacji(){
		int ind = 0;
		double ref = 0;
		
		for (int i=0; i<cena.length; i++){
			if (cena[i]*refundacja[i]>ref){
				ref = cena[i]*refundacja[i];
				ind = i;
			}
		}
		return nazwa[ind] + " kwota refundacji: " + ref;
	}
	
	public double kosztCalkowity(){
		int suma=0;
		for (int i=0; i<cena.length; i++){
			suma+=cena[i];
		}
		
		return suma;
	}
	
	public void wyswietl() {
		for (int i=0; i<nazwa.length; i++){
			System.out.println(nazwa[i] + "\t" + cena[i] + "\t" + refundacja[i]);
		}
		
	}
}
