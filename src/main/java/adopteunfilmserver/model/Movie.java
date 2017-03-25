package adopteunfilmserver.model;

public class Movie
{

	int id;
	int runningTime;
	String title;
	String type;
	int year;

	public Movie(int id, String title, int year, String type, int runningTime)
	{
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.type = type;
		this.runningTime = runningTime;
	}

	public int getId()
	{
		return id;
	}

	public int getRunningTime()
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

	public void setRunningTime(int runningTime)
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
