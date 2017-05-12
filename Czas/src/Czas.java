
public class Czas {
	int godz;
	int minuty;
	
	public Czas(int godz, int minuty){
	
		this.godz = godz+minuty/60;
		this.minuty = minuty%60;
	}
	
	public Czas(String tekst) {
		String[] numbers = tekst.replaceAll("^\\D+","").split("\\D+");
		int h=Integer.valueOf(numbers[0]);
		int min=Integer.valueOf(numbers[1]);
		this.godz=h+min/60;
		this.minuty=min%60;
	}

	@Override
	public String toString() {
		return godz + " h " + minuty + " min";
	}
	
	public Czas dodaj(Czas t){
		return new Czas(this.godz+t.godz, this.minuty+t.minuty);
	}
	
	public Czas odejmij(Czas t){
		int h=this.godz;
		int min=this.minuty;
		if (this.minuty-t.minuty<0){
			h--;
			min+=60;
		}
		return new Czas(h-t.godz, min-t.minuty);
	}
	
	public Czas pomnoz(int ile){
		return new Czas(this.godz*ile, this.minuty*ile);
	}
	
	public static Czas sumuj(Czas [] tab, int n){
		
		int h=0;
		int min=0;
		
		for (int i=0; i<n; i++){
			h+=tab[i].godz;
			min+=tab[i].minuty;
		}
		
		return new Czas(h,min);
	}
	

}
