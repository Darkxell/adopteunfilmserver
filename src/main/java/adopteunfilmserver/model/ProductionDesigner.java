package adopteunfilmserver.model;

public class ProductionDesigner
{

	String info;
	int movie;
	String productionDesigner;

	public ProductionDesigner(int movie, String productionDesigner, String info)
	{
		super();
		this.movie = movie;
		this.productionDesigner = productionDesigner;
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

	public String getProductionDesigner()
	{
		return productionDesigner;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public void setMovie(int movie)
	{
		this.movie = movie;
	}

	public void setProductionDesigner(String productionDesigner)
	{
		this.productionDesigner = productionDesigner;
	}

}
