package Projekti.Pelilista.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long genreId;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Game> games;

	public Genre() {
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}