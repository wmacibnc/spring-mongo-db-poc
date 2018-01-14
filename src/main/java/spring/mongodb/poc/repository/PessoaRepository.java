package spring.mongodb.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import spring.mongodb.poc.model.Pessoa;
import spring.mongodb.poc.model.indexes.PessoaIndex;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

	/**
	 * Método responsável por consultar uma pessoa por nome.
	 * 
	 * @param nome
	 * @return
	 */
	Pessoa findByNome(String nome);

	/**
	 * Método responsável por consultar todas as pessoas com o mesmo E-mail
	 * 
	 * @param email
	 * @return
	 */
	List<Pessoa> findByEmail(String email);

	/**
	 * Método responsável por consultar uma pessoa por nome, com query
	 * 
	 * @param nome
	 * @return
	 */
	@Query("{ 'nome': ?0}")
	PessoaIndex obterPorNome(String nome);

}
