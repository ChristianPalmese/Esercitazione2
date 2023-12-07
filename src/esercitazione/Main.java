package esercitazione;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static Archivio archivio= new Archivio();
	
	public static void main(String[] args) {
		while(true) {
			
			int scelta=stampaMenu();
			if(scelta==1) {
				Listaelettorale lista=leggiListaElettorale();
				archivio.aggiungiLista(lista);
			}else if(scelta==2) {
				
				System.out.println("inserisci il nome della lista in cui vuoi inserire il candidato");
				String nomeLista=scanner.next();
				
				Listaelettorale listaElettoraleCercatoUtente = archivio.getListaByNome(nomeLista);
				
				if(listaElettoraleCercatoUtente==null) {
					System.out.println("errore lista non trovata");
					continue;
				}
				
				
				Candidati candidato = leggiCandidato();
				if(candidato.getRuolo().equalsIgnoreCase("sindaco")) {
					if(listaElettoraleCercatoUtente.contieneSindaco()==true) {
						System.out.println("il ruolo di sindaco è gia presente ");
						continue;
					}
				}

				listaElettoraleCercatoUtente.aggiungiCandidato(candidato);
				
			}else if(scelta==0) {
				System.exit(0);
			}else if(scelta==3) {
				riepilogo();
			}else if(scelta==4) {
				System.out.println("in quale lista vuoi cercare il duplicato?");
				String nomeListaDuplicato = scanner.next();
				archivio.getListaByNome(nomeListaDuplicato);
				Listaelettorale lista = archivio.getListaByNome(nomeListaDuplicato);
				
				if(lista==null) {
					System.out.println("errore lista non trovata");
					continue;
				}
				
				if(verificaDuplicatoV2(lista)==true) {
					System.out.println("Ci sono duplicati nella lista");
				}else {
					System.out.println("Non ci sono duplicati nella lista");
				}
				
			}else if(scelta==5) {
				double etaMediaDonneSindaco = calcolaEtaMediaDonneSindaco();
			    System.out.println("L'età media delle donne candidate a sindaco è: " + etaMediaDonneSindaco);
			}
			
			
		}	
	}
		
		
		
		
	
	
	
	
	
	
	
	
	private static int stampaMenu() {
		System.out.println("---------------------------------");
		System.out.println("GESTIONE LISTE ELETTORALI");
		System.out.println("---------------------------------");
		System.out.println("1: inserisci lista elettorale");
		System.out.println("2: inserisci candidato");
		System.out.println("3: riepilogo dei dati");
		System.out.println("4: verifica duplicati");
		System.out.println("5: verifica eta media delle donne candidatate a sindaco");
		System.out.println();
		System.out.println("0: esci");
		System.out.println("---------------------------------");
		System.out.println("INSERISCI LA TUA SCELTA: ");
		return scanner.nextInt();
		
	}
	
	private static Listaelettorale leggiListaElettorale() {
		Listaelettorale listaelettorale1= new Listaelettorale();
		
		System.out.println("aggiungi il nome della lista elettorale");
		String nome = scanner.next();
		
		listaelettorale1.setNome(nome);
		
		System.out.println("aggiungi lo slogan");
		String slogan = scanner.next();
		listaelettorale1.setSlogan(slogan);
		
		System.out.println("aggiungi la premessa elettorale");
		String premessaElettorale = scanner.next();
		listaelettorale1.setPromsessaElettorale(premessaElettorale);
		return listaelettorale1;
	}
	
	private static Candidati leggiCandidato() {
		
		
		Candidati candidato = new Candidati();
		
		System.out.println("Inserisci il nome del candidato");
		String nome1= scanner.next();
		candidato.setNome(nome1);
		
		System.out.println("aggiungi il ruole del candiato");
		String ruolo = scanner.next();
		candidato.setRuolo(ruolo);
		
		System.out.println("il candidato è di sesso maschile?");
		boolean sesso = scanner.nextBoolean();
		candidato.setSessoMaschile(sesso);
		
		System.out.println("aggiungere l'eta del candidato");
		int eta = scanner.nextInt();
		candidato.setEta(eta);
		return candidato;
		
	}
	
	private static void riepilogo() {
		
		for (Listaelettorale lista : archivio.getListe()) {
		    System.out.println("Nome lista: " + lista.getNome());
		    System.out.println("Slogan: " + lista.getSlogan());
		    System.out.println("Premessa elettorale: " + lista.getPromsessaElettorale());

		   
		    for (Candidati candidato : lista.getCandidato()) {
		        System.out.println("	Nome candidato: " + candidato.getNome());
		        System.out.println("	Ruolo: " + candidato.getRuolo());
		        System.out.println("	Sesso maschile: " + candidato.isSessoMaschile());
		        System.out.println("	Età: " + candidato.getEta());
		        System.out.println("----------------------------------");
		    }
	
		    
		}
		
		
		
	}
	
	
	
	
	private static boolean verificaDuplicatoV2(Listaelettorale lista) {
		Set<Candidati> insieme = new HashSet<>();
		insieme.addAll(lista.getCandidato());
		return insieme.size()!=lista.getCandidato().size();
		/*
		if(insieme.size()==lista.getCandidato().size()) {
			return false;
		}else {
			return true;
		}
		*/
		
	}
	
	
	
	
	
	
	
	private static boolean verificaDuplicato(Listaelettorale lista) {
		List<Candidati> candidati = lista.getCandidato();
		for(Candidati c1 :candidati) {
			for(Candidati c2 : candidati) {
				if(c1!=c2) {
					if(c1.equals(c2)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/*
	private static Listaelettorale trovaLista(String nomeLista) {
		for(Listaelettorale lista : archivio.getListe()) {
			if(lista.getNome().equalsIgnoreCase(nomeLista)) {
				return lista;
			}
		}
		return null;
	}
	*/
	
	private static double calcolaEtaMediaDonneSindaco() {
	    int sommaEta = 0;
	    int contatore = 0;

	    for (Listaelettorale lista : archivio.getListe()) {
	        List<Candidati> candidati = lista.getCandidato();
	        for (Candidati candidato : candidati) {
	            if (candidato.getRuolo().equalsIgnoreCase("sindaco") && !candidato.isSessoMaschile()) {
	                sommaEta += candidato.getEta();
	                contatore++;
	            }
	        }
	    }
	    
	    if (contatore > 0) {
	        double mediaEta = (double) sommaEta / contatore;
	        return mediaEta;
	    } else {
	        return 0.0;
	    }
	}
	
	
	
	
	
		
}
