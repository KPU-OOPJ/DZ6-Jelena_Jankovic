
package javaapplication20;


public class Rukometas {
        private String imePrezime;
	private String pozicija;
	private int poeni;

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		if (imePrezime == null || imePrezime.length() > 20) {
			throw new RukometException("Ime i prezime ne moze biti null ili duze od dvadeset znakova.");
		}
		this.imePrezime = imePrezime;
	}
	
	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		if (pozicija == null || pozicija.length() > 20) {
			throw new RukometException("Pozicija ne moze biti null ili duza od dvadeset znakova.");
		}
		this.pozicija = pozicija;
	}

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		if (poeni < 0) {
			throw new RukometException("Poeni ne mogu biti manji od nule.");
		}
		this.poeni = poeni;
	}

	@Override
	public boolean equals(Object obj) {
		
		
		if (!(obj instanceof Rukometas)) {
			throw new RukometException("Ovo nije objekat klase Rukometas.");
		}
		
		Rukometas r = (Rukometas) obj;
		
		if (this.getImePrezime().equals(r.getImePrezime())) {
			return true;
		}
		return false;
	}
    
}
