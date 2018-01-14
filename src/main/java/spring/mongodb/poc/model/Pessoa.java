package spring.mongodb.poc.model;

import org.springframework.data.annotation.Id;

public class Pessoa {

	@Id
	public String id;

	private String nome;
	private String email;

	public Pessoa() {
	}

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Pessoa[id=%s, nome='%s', email='%s']", id, nome, email);
	}

}