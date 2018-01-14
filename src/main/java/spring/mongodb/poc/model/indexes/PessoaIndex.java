package spring.mongodb.poc.model.indexes;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document
//@Data
public class PessoaIndex {

	@Id
	public String id;

	@TextIndexed(weight = 3)
	private String nome;

	@TextIndexed(weight = 2)
	private String email;

	@TextIndexed
	private List<String> telefones;

	@TextScore
	private Float score;

	public PessoaIndex() {
	}

	public PessoaIndex(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Pessoa [id=%s, nome='%s', email='%s', telefones='%s', score='%s']", id, nome, email,
				telefones, score);
	}

}