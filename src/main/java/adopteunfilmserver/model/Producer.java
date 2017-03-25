package adopteunfilmserver.model;

public class Producer
{

	String info;
	int movie;
	String producer;

	public Producer(int movie, String producer, String info)
	{
		super();
		this.movie = movie;
		this.producer = producer;
		this.info = info;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public String getProducer()
	{
		return producer;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

	public void setProducer(String producer)
	{
		this.producer = producer;
	}

}
