package esercitazione;

import java.util.Objects;

public class Candidati {
	private String nome;
	private String ruolo;
	private boolean sessoMaschile;
	private int eta;
	
	Candidati(String nome,String ruolo, boolean sessoMaschile,int eta){
		this.nome=nome;
		this.ruolo=ruolo;
		this.sessoMaschile=sessoMaschile;
		this.eta=eta;
	}
	Candidati(){
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(eta, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidati other = (Candidati) obj;
		return eta == other.eta && Objects.equals(nome, other.nome);
	}
	
	
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public boolean isSessoMaschile() {
		return sessoMaschile;
	}

	public void setSessoMaschile(boolean sessoMaschile) {
		this.sessoMaschile = sessoMaschile;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "Candidati [nome=" + nome + ", ruolo=" + ruolo + ", sessoMaschile=" + sessoMaschile + ", eta=" + eta
				+ "]";
	}
	
	
	
	
	
}
