package zad_dod;

public class Biurowy extends Pracownik {

	int intelekt;
	double stanowisko;
	
	Biurowy(){
		super();
		intelekt = 70;
		stanowisko = 0000;
	}
	
	Biurowy(int intel, double stan, double i, int d, String im, String n, int w, String[] a){
		super(i, d, im, n, w, a);
		if(intel>=70 && intel<=150) {
			intelekt = intel;
		}else {
			System.out.println("zla wartosc (intelekt)");
		}
		stanowisko = stan;
	}
	
}
