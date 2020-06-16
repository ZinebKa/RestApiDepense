package com.ZinebJava.AppRestAppMobile.data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Dette  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String personne;
	String delai;
	float montant;
	String note;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonne() {
		return personne;
	}
	public void setPersonne(String personne) {
		this.personne = personne;
	}
	public String getDelai() {
		return delai;
	}
	public void setDelai(String delai) {
		this.delai = delai;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Dette [id=" + id + ", personne=" + personne + ", delai=" + delai + ", montant=" + montant
				+ ", note=" + note + "]";
	}
	

}
