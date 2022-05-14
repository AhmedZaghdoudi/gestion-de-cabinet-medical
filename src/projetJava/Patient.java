package projetJava;

public class Patient {
	
	int id ;
	String code ;
	String nom , prenom , address , tel ;
	
	public String allToString() {
		return id + "  |  " + code + "  |  " + nom + "  |  " + prenom + "  |  " + address + "  |  " + tel + "  |  ";
	}
	
	@Override
	public String toString() {
		return  code + "  |  " + nom + "  |  " + prenom + "  |  " + address + "  |  " + tel + "  |  ";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

	public Patient(int id, String code, String nom, String prenom, String address, String tel) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.tel = tel;
	}
	
	
	
}
