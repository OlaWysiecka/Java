package zad_dod;
import java.util.ArrayList;
import java.util.Arrays;

public class Pracownik 
{
	
	double identyfikator;
	String imie, nazwisko;
	int wiek,doswiadczenie;
	String[] adres = new String[4];
	static ArrayList<Pracownik> rejestr = new ArrayList<>();
	Pracownik()	{
		identyfikator = 0000;
		imie = "-";
		nazwisko = "-";
		wiek = 0;
		doswiadczenie = 0;
		for(int i=0; i<4; i++) {
			adres[i] = "-";
		}
	}
	
	Pracownik(double i, int d, String im, String n, int w, String[] a){
		identyfikator = i;
		imie = im;
		nazwisko = n;
		wiek = w;
		doswiadczenie = d;
		for(int k=0; k<4; k++) {
				adres[k] = a[k];
			}
		}
	

	void dodaj_pracownika(Pracownik a) {
		rejestr.add(a);	
	}
	
	void dodaj_pracownika(Biurowy a) {
		rejestr.add(a);		
	}
	
	void dodaj_pracownika(Fizyczny a) {
		rejestr.add(a);		
	}
	
	void dodaj_pracownika(Handlarz a) {
		rejestr.add(a);		
	}
	
	void usun_pracownika(double i) {
		for(int x = 0; i<rejestr.size(); i++){
			if(rejestr.get(x).identyfikator == i) {
				rejestr.remove(rejestr.get(x));
				break;
			}
		}
	}
	

	boolean alfabet(String a, String b) {
		boolean test = false;
		for(int i=0; i<max(a.length(), b.length());i++) {
			if((int) a.charAt(i) < (int) b.charAt(i)) {
				test = true;	
			}else {
				test = false;
				break;
			}
		}
		return test;
	}
	
	int max(int a, int b) {
		if(a<b) {
			return b;
		}else {
			return a;
		}
	}

	ArrayList lista_sort() {	 //doswiadczenie(liczby malejaca) - wiek(liczby rosnaco) - nazwisko(alfabet)
		int dosw[] = new int[rejestr.size()], wiek[] = new int[rejestr.size()];
		String nazw[] = new String[rejestr.size()];
		for(int i=0, j=rejestr.size(); i<rejestr.size();i++,j--) {
			dosw[j] = rejestr.get(j).doswiadczenie;
			wiek[i] = rejestr.get(i).wiek;
			nazw[i] = rejestr.get(i).nazwisko;
		}
		
		Arrays.sort(dosw);
		Arrays.sort(wiek);
		Arrays.sort(nazw);
	
		ArrayList<Pracownik> rejestr_sort = new ArrayList<>();
		
		//wg doswiadczenia:
		for(int i=0; i<rejestr.size();i++) {
			for(int j=0; j<rejestr.size();j++) {
				if(rejestr.get(j).doswiadczenie == dosw[i]) {
					rejestr_sort.add(rejestr.get(j));
				}//wg wieku:
				if(rejestr_sort.get(j).doswiadczenie == rejestr_sort.get(i).doswiadczenie) {
					if((rejestr_sort.get(i).wiek > rejestr_sort.get(j).wiek && i<j)
							||(rejestr_sort.get(j).wiek > rejestr_sort.get(i).wiek && j<i)){
						int abc = rejestr_sort.get(j).doswiadczenie;
						rejestr_sort.get(j).doswiadczenie = rejestr_sort.get(i).doswiadczenie;
						rejestr_sort.get(i).doswiadczenie = abc;
					}//wg nazwiska alfabetycznie:
					if(rejestr_sort.get(j).wiek == rejestr_sort.get(i).wiek) {
						if((alfabet(rejestr_sort.get(i).nazwisko,rejestr_sort.get(j).nazwisko)==false && i<j)
								||((alfabet(rejestr_sort.get(j).nazwisko,rejestr_sort.get(i).nazwisko)==false && j<i))) {
							String nazwisko1 = rejestr_sort.get(i).nazwisko;
							rejestr_sort.get(i).nazwisko = rejestr_sort.get(j).nazwisko;
							rejestr_sort.get(j).nazwisko = nazwisko1;
						}
					}
				}
			}
		}
		return rejestr_sort;
		
	}
	

	
	void miasto(String m) {
		for(int i=0; i<rejestr.size(); i++) {
			if(rejestr.get(i).adres[3] == m) {
				String a = rejestr.get(i).imie+" "+rejestr.get(i).nazwisko;
				System.out.println(a);
			}
		}
	}
	
	
	
	void dane() {
		for(int i=0; i<rejestr.size(); i++) {
			String a = rejestr.get(i).imie+" "+rejestr.get(i).nazwisko;
			if(rejestr.get(i) instanceof Biurowy) {
				int b = rejestr.get(i).doswiadczenie*((Biurowy)rejestr.get(i)).intelekt;
				System.out.println(a+": "+b);
			}else {
				if(rejestr.get(i) instanceof Fizyczny) {
					int c = rejestr.get(i).doswiadczenie*((Fizyczny)rejestr.get(i)).sila/rejestr.get(i).wiek;
					System.out.println(a+": "+c);
				}else {
					if(rejestr.get(i) instanceof Handlarz) {
						if(((Handlarz)rejestr.get(i)).skutecznosc == "niska") {
							System.out.println(a+": "+rejestr.get(i).doswiadczenie*60);
						}else {
							if(((Handlarz)rejestr.get(i)).skutecznosc == "srednia"){
								System.out.println(a+": "+rejestr.get(i).doswiadczenie*90);
							}else {
								if(((Handlarz)rejestr.get(i)).skutecznosc == "wysoka"){
									System.out.println(a+": "+rejestr.get(i).doswiadczenie*120);
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	
	
}
