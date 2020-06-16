package com.ZinebJava.AppRestAppMobile.data;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Depense implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String libele;
	float montant;
	String note;
	String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
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
		return "Depense [id=" + id + ", libele=" + libele + ", montant=" + montant + ", note=" + note + ", date=" + date
				+ "]";
	}


	
	
	
}
