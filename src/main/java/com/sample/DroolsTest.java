package com.sample;

import java.sql.Date;
import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static final void main(String[] args) {
		try {
	        // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
	    	KieSession kSession = kContainer.newKieSession("ksession-rules");
	
	        // go !
	        kSession.fireAllRules();
	    } catch (Throwable t) {
	        t.printStackTrace();
	    }
	}
    
	
    public static class Klient{
        public boolean czlonekKlubu; 
        public String nazwa;
        public boolean wynajety;
        public String wyporzycz;
        public boolean maSamochod;
		public Klient(boolean czlonekKlubu, String nazwa) {
			super();
			this.czlonekKlubu = czlonekKlubu;
			this.nazwa = nazwa;
		}
        
    }
    public static class Samochod{
    	public boolean dowodRejestracyjny;
    	public int iloscKolpakow;
        public String typ;
        public int bagaznik;
        public int fotelikDlaDziecka;
        public int cena13;
        public int cena4;
        public boolean wolny;
        
		
        public Samochod(String typ, int cena13, int cena4, int bagaznik, int fotelikDlaDziecka) {
			this.typ = typ;
			this.bagaznik = bagaznik;
			this.fotelikDlaDziecka = fotelikDlaDziecka;
			this.cena13 = cena13;
			this.cena4 =  cena4;
			this.wolny = true;
        }
        
        
              
    }
    
    public static class Rezerwacja{
        public Samochod samochod;
        public Klient klient;
        public int dataPobrania;
        public int dataZwrotu;
        public int zadeklarowanaDataZwrotu;
        public int cenaZaDzien;
        public boolean zrealizowana;
        public int cenaCalkowita;
        
		public Rezerwacja(Samochod samochod, Klient klient, int dataPobrania,int zadeklarowanaDataZwrotu) {
			super();
			this.samochod = samochod;
			this.klient = klient;
			this.dataPobrania = dataPobrania;
			this.zadeklarowanaDataZwrotu = zadeklarowanaDataZwrotu;
			this.cenaCalkowita = 0;
			this.zrealizowana = false;
		}
        
     
    }
    
    public static class Zwrot{
    	public Rezerwacja rezerwacja;
    	public int karaUmowna;
    	
		public Zwrot(Rezerwacja rezerwacja, int karaUmowna) {
			super();
			this.rezerwacja = rezerwacja;
			this.karaUmowna = karaUmowna;
		}
    	
    }
    

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}