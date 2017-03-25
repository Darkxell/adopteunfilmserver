package adopteunfilmserver.model;

public class Designer
{

	String designer;
	String info;
	int movie;

	public Designer(int movie, String designer, String info)
	{
		super();
		this.movie = movie;
		this.designer = designer;
		this.info = info;
	}

	public String getDesigner()
	{
		return designer;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setDesigner(String designer)
	{
		this.designer = designer;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

}
