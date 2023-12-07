package esercitazione;

import java.util.ArrayList;

public class Archivio {
	private ArrayList<Listaelettorale> listeElettorali= new ArrayList<>();
	
	public void aggiungiLista(Listaelettorale listaelettorale) {
		listeElettorali.add(listaelettorale);
	}
	
	public ArrayList<Listaelettorale> getListe(){
		return listeElettorali;
	}
	
	public Listaelettorale getListaByNome(String nome) {
		for(Listaelettorale l : listeElettorali) {
			if(nome.equalsIgnoreCase(l.getNome())) {
				return l;
			}
			
		}
		return null;
	}
}
