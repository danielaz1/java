import java.io.Serializable;

public class Pozycja implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nazwaTowaru;
	private int ileSztuk;
	private double cena;
	
	
	public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
		this.nazwaTowaru = nazwaTowaru;
		this.ileSztuk = ileSztuk;
		this.cena = cena;
	}
	
	public double obliczWartosc(){
		return cena*ileSztuk;
	}

	public double obliczWartoscZRabatem(){
		if (ileSztuk<5){
			return obliczWartosc();
		}
		else if(ileSztuk<=10){
			return obliczWartosc()*0.95;
		}
		else if(ileSztuk<=20){
			return obliczWartosc()*0.90;
		}
		else{
			return obliczWartosc()*0.85;
		}
	}
	
	
	@Override
	public String toString() {
		double wartosc = obliczWartosc();
		double wartoscZRabatem = obliczWartoscZRabatem();
		return String.format("%-20s", nazwaTowaru)+ String.format("%10.2f", cena) + " zl" + 
			String.format("%4s", ileSztuk) + " szt"+ String.format("%10.2f", wartosc) + " zl"
			+ String.format("%10.2f", wartosc-wartoscZRabatem) + " zl"
			+ String.format("%10.2f",wartoscZRabatem ) + " zl" ;
	}

	public int getIleSztuk() {
		return ileSztuk;
	}

	public void setIleSztuk(int ileSztuk) {
		this.ileSztuk = ileSztuk;
	}

	public String getNazwaTowaru() {
		return nazwaTowaru;
	}
	
	
	
	

}
