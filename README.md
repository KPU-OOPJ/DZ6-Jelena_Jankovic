**Kreirati aplikaciju koji će imati korisnički interfejs kao što je dato na slici i sledeću funkcionalnost:**

-	Padajuća lista bi trebalo da ima stavke: “golman”, “krilo”, “bek”, “centar”.
-	Javnu klasu Rukometaš koja ima:
-	Privatni atribut imePrezime. Vrednost za ovaj atribut je uvek u formatu “IME PREZIME”.
-	Privatni atribut pozicija koji predstavlja poziciju koju rukometaš igra (npr. “golman” ili “bek”).
-	Privatni atribut poeni koji predstavlja ukupan broj poena koje je rukometaš postigao na utakmici.
-	Odgovarajuće javne get i set metode za ove atribute. Nedozvoljene vrednosti za attribute imePrezime i pozicija su null i String-ovi duži od 20 znakova, a broj poena može biti nula ili veći od nule. U slučaju unosa nedozvoljenih vrednosti,baciti izuzetak klase RukometException sa odg.porukom.
-	Redefinisanu equals metodu klase Object. Prvo je potrebno proveriti da li je unet objekat klase Rukometaš, pa ako nije, baciti izuzetak klase RukometException sa odgovarajućom porukom. Metoda vraća true ako su ime i prezime jednaki imenu i prezimenu unetog rukometaša, a inače false.
-	Klasa RukometGUI bi trebalo da sadrži privatni atribut igrači koji predstavlja listu objekata klase Rukometaš. Ovu listu je potrebno odmah inicijalizovati.
-	Kada se pritisne dugme “Obriši”,briše se sadržaj svih polja za unos (ne brisati sadržaj pad. liste).
-	Kada se pritisne dugme “Sačuvaj”, svi podaci o rukometašima iz liste se upisuju u dva data fajla „golmani.txt“ i “igraci.txt”. U prvi fajl je potrebno upisati samo podatke o golmanima iz liste dok bi drugi trebalo da sadrži podatke o svim ostalim igračima iz liste. U oba slučaja potrebno je upisati podatke za svakog igrača u posebnom redu u formatu: ime prezime – pozicija – brojpoena 
-	Kada se pritisne dugme “Unesi”, preuzimaju se svi podaci o rukometašu iz odgovarajućih polja (ime I prezime, pozicija i poeni), i novi rukometaš se unosi u listu. Unošenje se vrši samo ako u listi već ne postoji isti rukometaš i to tako da se očuva opadajući redosled prema broju poena. Ako u listi već postoji isti rukometaš, ili ako je nastao neki izuzetak u toku preuzimanja unetih podataka ili njihovog prevaranja u odgovarajući tip, potrebno je u naslov prozora dodati reč “GREŠKA”.

![2](https://scontent.fbeg6-1.fna.fbcdn.net/v/t1.15752-9/96237518_2990657231021187_6768217732295950336_n.png?_nc_cat=110&_nc_sid=b96e70&_nc_eui2=AeEQ8OVljsdj046hHpjUqKSESo4CGk-VsaNKjgIaT5Wxo1rA4Ct3ckAAlMwctuKjtNs&_nc_ohc=0KfcXa9Mi-oAX_OS-7v&_nc_ht=scontent.fbeg6-1.fna&oh=364bb373d52e03c47dc8213d59edecc8&oe=5EDE7957)
