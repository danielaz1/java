import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Pozycja p1 = new Pozycja("P1", 5, 17.5);
		Pozycja p2 = new Pozycja("P2", 12, 2);
		Pozycja p3 = new Pozycja("P3", 10, 7.25);

		Zamowienie z = new Zamowienie(20);
		z.dodajPozycje(p1);
		z.dodajPozycje(p2);
		z.dodajPozycje(p3);
		z.dodajPozycje(p1);
		z.dodajPozycje(p2);

		// System.out.println(z);

		zapiszZamowienie(z, "zam1.ser");

		Zamowienie z1 = wczytajZamowienie("zam1.ser");
		System.out.println(z1);

	}

	public static void zapiszZamowienie(Zamowienie z, String nazwaPliku) throws IOException {
		OutputStream outStream = new FileOutputStream(nazwaPliku);
		ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
		fileObjectOut.writeObject(z);
		fileObjectOut.close();
		outStream.close();
	}

	public static Zamowienie wczytajZamowienie(String nazwaPliku) throws IOException, ClassNotFoundException {
		InputStream inStream = new FileInputStream(nazwaPliku);
		ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
		Zamowienie z = (Zamowienie) fileObjectIn.readObject();
		fileObjectIn.close();
		inStream.close();
		return z;
	}
}
