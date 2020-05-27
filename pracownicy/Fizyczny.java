package zad_dod;

public class Fizyczny extends Pracownik{

	int sila;
	
	Fizyczny(){
		super();
		sila = 1;
	}
	
	Fizyczny(int s, double i, int d, String im, String n, int w, String[] a){
		super(i, d, im, n, w, a);
		if(s>=1 && s<=100) {
			sila = s;
		}else {
			System.out.println("zla wartosc (sila)");
		}
	}
	
}
