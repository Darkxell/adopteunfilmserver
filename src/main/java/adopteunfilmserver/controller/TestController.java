package adopteunfilmserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.model.Bean;

/** Test controller. */
@Controller
public class TestController
{

	@RequestMapping(value = "/test/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Bean testJson(@PathVariable String name)
	{
		return new Bean(name, name.length());
	}

}
