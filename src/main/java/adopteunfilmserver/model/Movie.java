package adopteunfilmserver.model;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie
{

	@Id
	@Column(name = "id_movie")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

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
	}

	public int getId()
	{
		return id;
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

	public void setId(int id)
	{
		this.id = id;
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
