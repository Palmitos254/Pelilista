package Projekti.Pelilista;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Projekti.Pelilista.domain.Game;
import Projekti.Pelilista.domain.GameRepository;
import Projekti.Pelilista.domain.Genre;
import Projekti.Pelilista.domain.GenreRepository;

@SpringBootApplication
public class PelilistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PelilistaApplication.class, args);
	}

	@Bean
	public CommandLineRunner gameDemo(GameRepository repository, GenreRepository grepository) {
		return (args) -> {
			grepository.save(new Genre("RPG"));
			grepository.save(new Genre("SandBox"));
			grepository.save(new Genre("Hack and Slash"));
			grepository.save(new Genre("Platformer"));
			grepository.save(new Genre("Rhythm game"));

			repository.save(new Game("Elden Ring", "PC, PS4", 2022, 16, grepository.findByName("RPG").get(0)));
			repository.save(new Game("Dark Souls", "PC, PS4", 2011, 16, grepository.findByName("RPG").get(0)));
			repository.save(new Game("Terraria", "PC, PS4", 2011, 12, grepository.findByName("SandBox").get(0)));
		};
	}
}
