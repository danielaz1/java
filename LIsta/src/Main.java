import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		final int N = 10;
		Lista lista = new Lista(N);
		for (int i = 0; i < N / 2; ++i) {
			lista.dodajElement((1 << i));
		}
		lista.dodajElement(2);
		lista.dodajElement(8);
		lista.pisz();
		lista.usunPierwszy(2);
		lista.pisz();
		for (int i = 0; i < N / 2; ++i) {
			lista.dodajElement((1 << i));
		}
		lista.pisz();
		System.out.println("Po usuniêciu powtórzeñ:");
		lista.usunPowtorzenia();
		lista.pisz();

		lista.zapiszDoPliku("liczby.txt");
	}

}
