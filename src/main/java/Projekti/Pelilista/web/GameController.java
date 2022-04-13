package Projekti.Pelilista.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Projekti.Pelilista.domain.Game;
import Projekti.Pelilista.domain.GameRepository;
import Projekti.Pelilista.domain.GenreRepository;

@Controller
public class GameController {

	@Autowired
	private GameRepository repository;

	@Autowired
	private GenreRepository grepository;

	@RequestMapping(value = { "/", "/gamelist" })
	public String gameList(Model model) {
		model.addAttribute("games", repository.findAll());
		return "gamelist";
	}

	// RESTful service to get all games
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public @ResponseBody List<Game> gameListRest() {
		return (List<Game>) repository.findAll();
	}

	// RESTful service to get game by id
	@RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Game> findBookRest(@PathVariable("id") Long gameId) {
		return repository.findById(gameId);
	}

	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", grepository.findAll());
		return "addgame";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Game game) {
		System.out.println(game);
		if (game.getPlatformTypePC()) {
			if (game.getPlatform() == null) {
				game.setPlatform("PC");
				repository.save(game);
			}
		}

		if (game.isPlatformTypeXbox()) {
			if (game.getPlatform() == null) {
				game.setPlatform("Xbox");
				repository.save(game);
			} else {
				game.setPlatform(game.getPlatform() + " Xbox");
				repository.save(game);
			}
		}
		
		if (game.isPlatformTypeXbox360()) {
			if (game.getPlatform() == null) {
				game.setPlatform("Xbox360");
				repository.save(game);
			} else {
			game.setPlatform(game.getPlatform() + " Xbox360");
			repository.save(game);
		}}
		
		if (game.isPlatformTypePs3()) {
			if (game.getPlatform() == null) {
				game.setPlatform("Ps3");
				repository.save(game);
			} else {
			game.setPlatform(game.getPlatform() + " Ps3");
			repository.save(game);
		}}
		
		if (game.isPlatformTypePs4()) {
			if (game.getPlatform() == null) {
				game.setPlatform("Ps4");
				repository.save(game);
			} else {
			game.setPlatform(game.getPlatform() + " Ps4");
			repository.save(game);
		}}
		
		if (game.isPlatformTypeNintendoSwitch()) {
			if (game.getPlatform() == null) {
				game.setPlatform("NintendoSwitch");
				repository.save(game);
			} else {
			game.setPlatform(game.getPlatform() + " NintendoSwitch");
			repository.save(game);
			
		}}
		repository.save(game);
		return "redirect:gamelist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.deleteById(gameId);
		return "redirect:../gamelist";
	}

	@RequestMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editGame(@PathVariable("id") Long gameId, Model model) {
		model.addAttribute("game", repository.findById(gameId));
		model.addAttribute("genres", grepository.findAll());
		return "editgame.html";
	}
}
