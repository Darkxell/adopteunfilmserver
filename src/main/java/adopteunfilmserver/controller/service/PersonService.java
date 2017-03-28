package adopteunfilmserver.controller.service;

import org.springframework.stereotype.Service;

import adopteunfilmserver.model.Person;

@Service("personService")
public class PersonService extends AFSService<Person>
{

	public PersonService()
	{
		super(Person.class);
	}

}
