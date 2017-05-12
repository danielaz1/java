import java.io.Serializable;

public class Zamowienie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pozycja[] pozycje;
	private int maksRozmiar;
	private int ileDodanych=0;
	
	public Zamowienie() {
		maksRozmiar=10;
		pozycje = new Pozycja[maksRozmiar];
	}
	public Zamowienie(int maksRozmiar) {
		this.maksRozmiar = maksRozmiar;
		pozycje = new Pozycja[maksRozmiar];
	}
	
	public void dodajPozycje(Pozycja p){
		
		boolean czyIstniejePozycja=false;
		for (int i=0; i<ileDodanych; i++){
			if (pozycje[i].getNazwaTowaru()==p.getNazwaTowaru()){
				int ileSzt = pozycje[i].getIleSztuk()+p.getIleSztuk();
				pozycje[i].setIleSztuk(ileSzt);
				czyIstniejePozycja=true;
				break;
			}
		}
		if(!czyIstniejePozycja){
		pozycje[ileDodanych]=p;
		ileDodanych++;
		}
	}
	
	public double obliczWartosc(){
		double wartosc = 0;
		
		for (int i=0; i<ileDodanych; i++){
			wartosc+=pozycje[i].obliczWartosc();
		}
		return wartosc;
	}
	
	public double obliczWartoscZRabatem(){
		double wartosc = 0;
		
		for (int i=0; i<ileDodanych; i++){
			wartosc+=pozycje[i].obliczWartoscZRabatem();
		}
		return wartosc;
	}
	
	public void usunPozycje(int indeks){
		for (int i=indeks; i<ileDodanych-1; i++){
			pozycje[i]=pozycje[i+1];
		}
		pozycje[ileDodanych-1]=null;
		ileDodanych--;
	}
	
	/*public void edytujPozycje(int indeks){
		
	}*/
	
	@Override
	public String toString() {
		String s = "";
		for (int i=0; i<ileDodanych; i++){
			s+=pozycje[i].toString() + "\n";
		}
		s+= "\nRazem: " + String.format("%.2f", obliczWartosc()) + 
			"\tRazem z rabatem: " + String.format("%.2f", obliczWartoscZRabatem());
		
		return s;
	}
	
	
	
}
