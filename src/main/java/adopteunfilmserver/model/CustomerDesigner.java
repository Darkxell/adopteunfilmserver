package adopteunfilmserver.model;

public class CustomerDesigner
{

	String customerDesigner;
	String info;
	int movie;

	public CustomerDesigner(int movie, String customerDesigner, String info)
	{
		super();
		this.movie = movie;
		this.customerDesigner = customerDesigner;
		this.info = info;
	}

	public String getCustomerDesigner()
	{
		return customerDesigner;
	}

	public String getInfo()
	{
		return info;
	}

	public int getMovie()
	{
		return movie;
	}

	public void setCustomerDesigner(String customerDesigner)
	{
		this.customerDesigner = customerDesigner;
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
