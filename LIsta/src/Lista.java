import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lista {
	
	private int[] liczby;
	private int pojemnosc;
	private int rozmiar;
	
	public Lista(int pojemnosc) {
		this.pojemnosc = pojemnosc;
		liczby = new int[pojemnosc];
		rozmiar = 0;
	}
	
	public void dodajElement(int element){
		if (rozmiar>=pojemnosc){
			System.out.println("Lista pe³na");
		}
		else {
			liczby[rozmiar]=element;
			rozmiar++;
		}
	}
	
	public int znajdz(int element){
		for (int i=0; i<rozmiar; i++){
			if (liczby[i]==element)
				return i;
		}
		return -1;
	}
	
	public void pisz(){
		String l="";
		for (int i=0; i<rozmiar; i++){
			l+=liczby[i] + " ";
		}
		System.out.println("pojemnosc=" + pojemnosc + ", rozmiar=" + rozmiar +
				"\nliczby=" + l);
	}
	public void usun(int indeks){
		for (int i=indeks; i<rozmiar-1; i++){
			liczby[i]=liczby[i+1];
		}
		liczby[rozmiar-1]=0;
		rozmiar--;
	}
	
	public void usunPierwszy(int element){
		int indeks=znajdz(element);
		if (indeks>=0){
			usun(indeks);
		}
	}
	
	public void usunPowtorzenia(){
		for (int i=0; i<rozmiar; i++){
			
			for (int j=i+1; j<rozmiar; j++){
				if (liczby[j]==liczby[i]){
					usun(j);
				}
			}
		}
	}

	public void zapiszDoPliku(String nazwaPliku) throws IOException {
		String l="";
		for (int i=0; i<rozmiar; i++){
			l+=liczby[i] + " ";
		}
		
		 Files.write(Paths.get(nazwaPliku), l.getBytes());
		
	}

}
