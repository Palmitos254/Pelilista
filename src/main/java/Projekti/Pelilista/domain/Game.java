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
	private boolean platformTypePC = false;
	private boolean platformTypeXbox = false;
	private boolean platformTypeXbox360 = false;
	private boolean platformTypePs3 = false;
	private boolean platformTypePs4 = false;
	private boolean platformTypeNintendoSwitch = false;
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;

	public Game() {
	}
	
	public Game(String name, int release, int pegi, boolean platformTypePC, boolean platformTypeXbox,
			boolean platformTypeXbox360, boolean platformTypePs3, boolean platformTypePs4,
			boolean platformTypeNintendoSwitch, Genre genre) {
		super();
		this.name = name;
		this.release = release;
		this.pegi = pegi;
		this.platformTypePC = platformTypePC;
		this.platformTypeXbox = platformTypeXbox;
		this.platformTypeXbox360 = platformTypeXbox360;
		this.platformTypePs3 = platformTypePs3;
		this.platformTypePs4 = platformTypePs4;
		this.platformTypeNintendoSwitch = platformTypeNintendoSwitch;
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

	public boolean getPlatformTypePC() {
		return platformTypePC;
	}

	public void setPlatformTypePC(boolean platformTypePC) {
		this.platformTypePC = platformTypePC;
	}

	public boolean isPlatformTypeXbox() {
		return platformTypeXbox;
	}

	public void setPlatformTypeXbox(boolean platformTypeXbox) {
		this.platformTypeXbox = platformTypeXbox;
	}

	public boolean isPlatformTypeXbox360() {
		return platformTypeXbox360;
	}

	public void setPlatformTypeXbox360(boolean platformTypeXbox360) {
		this.platformTypeXbox360 = platformTypeXbox360;
	}

	public boolean isPlatformTypePs3() {
		return platformTypePs3;
	}

	public void setPlatformTypePs3(boolean platformTypePs3) {
		this.platformTypePs3 = platformTypePs3;
	}

	public boolean isPlatformTypePs4() {
		return platformTypePs4;
	}

	public void setPlatformTypePs4(boolean platformTypePs4) {
		this.platformTypePs4 = platformTypePs4;
	}

	public boolean isPlatformTypeNintendoSwitch() {
		return platformTypeNintendoSwitch;
	}

	public void setPlatformTypeNintendoSwitch(boolean platformTypeNintendoSwitch) {
		this.platformTypeNintendoSwitch = platformTypeNintendoSwitch;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", platform=" + platform + ", release=" + release + ", pegi="
				+ pegi + ", platformTypePC=" + platformTypePC + ", platformTypeXbox=" + platformTypeXbox
				+ ", platformTypeXbox360=" + platformTypeXbox360 + ", platformTypePs3=" + platformTypePs3
				+ ", platformTypePs4=" + platformTypePs4 + ", platformTypeNintendoSwitch=" + platformTypeNintendoSwitch
				+ ", genre=" + genre + "]";
	}
	
	
}
