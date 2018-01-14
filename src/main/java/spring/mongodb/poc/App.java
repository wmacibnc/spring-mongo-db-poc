package spring.mongodb.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring.mongodb.poc.model.Pessoa;
import spring.mongodb.poc.repository.PessoaRepository;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private PessoaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new Pessoa("Maria", "teste@gmail.com"));
		repository.save(new Pessoa("José", "teste@gmail.com"));

		System.out.println("Todas as pessoas findAll():");
		System.out.println("-------------------------------");
		for (Pessoa pessoa : repository.findAll()) {
			System.out.println(pessoa);
		}
		System.out.println();

		System.out.println("Pessoa com o primeiro nome findByNome('Maria'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByNome("Maria"));

		System.out.println("Pessoa com o email findByEmail('teste@gmail.com'):");
		System.out.println("--------------------------------");
		for (Pessoa pessoa : repository.findByEmail("teste@gmail.com")) {
			System.out.println(pessoa);
		}

	}

}
