package spring.mongodb.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import spring.mongodb.poc.model.indexes.PessoaIndex;

public interface PessoaIndexRepository extends MongoRepository<PessoaIndex, String> {

	List<PessoaIndex> findAllBy(TextCriteria criteria);

	List<PessoaIndex> findAllByOrderByScoreDesc(TextCriteria criteria);
	
	@Query("{ 'nome': ?0, 'email': ?1}")
	PessoaIndex obterPorNomeEmail(String nome, String email); 
}
