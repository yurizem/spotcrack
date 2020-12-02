package br.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@XmlRootElement
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private int dataLancamento;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idCantor_id")
	private Cantor idCantor_id;
	
	public Musica(int id, String nome, int dataLancamento, Cantor idCantor_id) {
		this.id = id;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.idCantor_id = idCantor_id;
	}
	
	public Musica() {};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLacamento(int dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Cantor getidCantor_id() {
		return idCantor_id;
	}

	public void setidCantor_id(Cantor idCantor_id) {
		this.idCantor_id = idCantor_id;
	}
	
}
