package Projekti.Pelilista.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String name;
	private String platform;
	private int release;
	private int pegi;

	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;

	public Game() {
	}

	public Game(String name, String platform, int release, int pegi, Genre genre) {
		super();
		this.name = name;
		this.platform = platform;
		this.release = release;
		this.pegi = pegi;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
