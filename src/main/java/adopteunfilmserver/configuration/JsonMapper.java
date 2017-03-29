package adopteunfilmserver.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class JsonMapper extends ObjectMapper
{
	private static final long serialVersionUID = -8280579838955988663L;
	
	public JsonMapper()
	{
		this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		this.registerModule(new Hibernate4Module());
	}
}
