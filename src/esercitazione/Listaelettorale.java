package esercitazione;

import java.util.ArrayList;
import java.util.List;

public class Listaelettorale {
	private String nome;
	private String slogan;
	private String promessaElettorale;
	private List<Candidati> candidati;
	
	Listaelettorale(String nome,String slogan,String promessaElettorale){
		this.nome=nome;
		this.slogan=slogan;
		this.promessaElettorale=promessaElettorale;
		this.candidati= new ArrayList<>();
	}
	
	Listaelettorale(){
		candidati = new ArrayList<>();
	}

	public void aggiungiCandidato(Candidati candidato) {
		candidati.add(candidato);
	}
	
	public boolean contieneSindaco() {
		for(Candidati c : candidati) {
			if(c.getRuolo().equalsIgnoreCase("sindaco")) {
				return true;
			}
		}
		return false;
	}
	

	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getPromsessaElettorale() {
		return promessaElettorale;
	}

	public void setPromsessaElettorale(String promsessaElettorale) {
		this.promessaElettorale = promsessaElettorale;
	}

	@Override
	public String toString() {
		return "Listaelettorale [nome=" + nome + ", slogan=" + slogan + ", promsessaElettorale=" + promessaElettorale
				+ "]";
	}

	public List<Candidati> getCandidato() {
		return candidati;
	}

	public void setCandidato(List<Candidati> candidato) {
		this.candidati = candidato;
	}
	
	
}
