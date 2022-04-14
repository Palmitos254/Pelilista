package Projekti.Pelilista;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Projekti.Pelilista.domain.Game;
import Projekti.Pelilista.domain.GameRepository;
import Projekti.Pelilista.domain.Genre;
import Projekti.Pelilista.domain.GenreRepository;
import Projekti.Pelilista.domain.User;
import Projekti.Pelilista.domain.UserRepository;

@SpringBootApplication
public class PelilistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PelilistaApplication.class, args);
	}

	@Bean
	public CommandLineRunner gameDemo(GameRepository repository, GenreRepository grepository,
			UserRepository urepository) {
		return (args) -> {
			grepository.save(new Genre("RPG"));
			grepository.save(new Genre("SandBox"));
			grepository.save(new Genre("Hack and Slash"));
			grepository.save(new Genre("Platformer"));
			grepository.save(new Genre("Rhythm game"));

			Game game1 = new Game("Elden Ring", 2022, 16, true, false, true, false, true, false , grepository.findByName("RPG").get(0));
			game1.setPlatform("PC Xbox360 Ps4");
					repository.save(game1);
			
			Game game2 = new Game("Dark Souls", 2011, 16, false, true, false, false, false, true , grepository.findByName("RPG").get(0));
			game2.setPlatform("Xbox NintendoSwitch");
					repository.save(game2);
			
			Game game3 = new Game("Terraria", 2011, 12 , true , false, false, false, false, false , grepository.findByName("SandBox").get(0));
			game3.setPlatform("PC");
					repository.save(game3);
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@admin.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
