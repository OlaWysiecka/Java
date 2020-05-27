package zad_dod;

public class Handlarz extends Pracownik{

	String skutecznosc; 
	float prowizja;
	
	
	Handlarz(String sk, float p, double i, int d, String im, String n, int w, String[] a){
		super(i, d, im, n, w, a);
		if(sk == "niska" || sk == "srednia" || sk=="wysoka") {
			skutecznosc = sk;
		}else {
			System.out.println("zla wartosc (skutecznosc)");
		}
		prowizja = p;
	}
	
	
	
}
