package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.PersonService;
import adopteunfilmserver.model.Person;

@Controller
public class PersonController
{

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/person/add/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Person> add(@PathVariable String name)
	{
		this.personService.add(new Person(name));
		return this.personService.list();
	}

	@RequestMapping(value = "/person/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Person> delete(@PathVariable int id)
	{
		this.personService.delete(id);
		return this.personService.list();
	}

	@RequestMapping(value = "/person/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Person get(@PathVariable int id)
	{
		return this.personService.get(id);
	}

	@RequestMapping(value = "/person/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Person> list()
	{
		return this.personService.list();
	}

	@RequestMapping(value = "/person/update/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Person update(@PathVariable int id, @PathVariable String name)
	{
		Person person = this.personService.get(id);
		person.setName(name);
		this.personService.update(person);
		return person;
	}

}
