package projetJava;

public class Consultation {

	String id ;
	String titre ;
	String contenu;
	
	
	
	
	public Consultation(String id, String titre, String contenu) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
	
	
}
