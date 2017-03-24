package adopteunfilmserver.model;


public class Bean
{

	int length;
	String name;

	public Bean(String name, int length)
	{
		this.name = name;
		this.length = length;
	}

	public int getLength()
	{
		return length;
	}

	public String getName()
	{
		return name;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
