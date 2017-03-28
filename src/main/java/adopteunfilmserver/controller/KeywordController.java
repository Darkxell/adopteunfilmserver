package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.KeywordService;
import adopteunfilmserver.model.Keyword;

@Controller
public class KeywordController
{

	@Autowired
	private KeywordService keywordService;

	@RequestMapping(value = "/keyword/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Keyword> add(@PathVariable String name)
	{
		this.keywordService.add(new Keyword(name));
		return this.keywordService.list();
	}

	@RequestMapping(value = "/keyword/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Keyword> delete(@PathVariable int id)
	{
		this.keywordService.delete(id);
		return this.keywordService.list();
	}

	@RequestMapping(value = "/keyword/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Keyword get(@PathVariable int id)
	{
		return this.keywordService.get(id);
	}

	@RequestMapping(value = "/keyword/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Keyword> list()
	{
		return this.keywordService.list();
	}

	@RequestMapping(value = "/keyword/update/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Keyword update(@PathVariable int id, @PathVariable String name)
	{
		Keyword keyword = this.keywordService.get(id);
		keyword.setName(name);
		this.keywordService.update(keyword);
		return keyword;
	}

}
