package adopteunfilmserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie
{

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
	Set<Genre> genres;

	@Id
	@Column(name = "id_movie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movie_keywords", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_keyword"))
	Set<Keyword> keywords;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "id_movie"), inverseJoinColumns = @JoinColumn(name = "id_language"))
	Set<Language> languages;

	@Column(name = "runningtime")
	double runningTime;

	@Column(name = "movie")
	String title;

	@Column(name = "movie_type")
	String type;

	@Column(name = "years")
	int year;

	public Movie()
	{}

	public Movie(String title, int year, String type, double runningTime)
	{
		super();
		this.id = 0;
		this.title = title;
		this.year = year;
		this.type = type;
		this.runningTime = runningTime;
		this.genres = new HashSet<Genre>();
		this.keywords = new HashSet<Keyword>();
		this.languages = new HashSet<Language>();
	}

	public Set<Genre> getGenres()
	{
		return genres;
	}

	public int getId()
	{
		return id;
	}

	public Set<Keyword> getKeywords()
	{
		return keywords;
	}

	public Set<Language> getLanguages()
	{
		return languages;
	}

	public double getRunningTime()
	{
		return runningTime;
	}

	public String getTitle()
	{
		return title;
	}

	public String getType()
	{
		return type;
	}

	public int getYear()
	{
		return year;
	}

	public void setGenres(Set<Genre> genres)
	{
		this.genres = genres;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setKeywords(Set<Keyword> keywords)
	{
		this.keywords = keywords;
	}

	public void setLanguages(Set<Language> languages)
	{
		this.languages = languages;
	}

	public void setRunningTime(double runningTime)
	{
		this.runningTime = runningTime;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

}
