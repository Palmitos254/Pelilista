package Projekti.Pelilista.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("genres", grepository.findAll());
		return "addgame";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Game game) {
		repository.save(game);
		return "redirect:gamelist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.deleteById(gameId);
		return "redirect:../gamelist";
	}

	@RequestMapping("/edit/{id}")
	public String editGame(@PathVariable("id") Long gameId, Model model) {
		model.addAttribute("game", repository.findById(gameId));
		model.addAttribute("genres", grepository.findAll());
		return "editgame.html";
	}
}
