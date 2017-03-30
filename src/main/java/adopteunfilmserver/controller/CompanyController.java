package adopteunfilmserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import adopteunfilmserver.controller.service.AFSService;
import adopteunfilmserver.controller.service.CompanyService;
import adopteunfilmserver.model.Company;

@Controller
public class CompanyController
{

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/company/add/{name}/{country}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Company> add(@PathVariable String name, @PathVariable String country)
	{
		this.companyService.add(new Company(name, country));
		List<Company> companies = this.companyService.list();
		AFSService.closeSession();
		return companies;
	}

	@RequestMapping(value = "/company/delete/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Company> delete(@PathVariable int id)
	{
		this.companyService.delete(id);
		List<Company> companies = this.companyService.list();
		AFSService.closeSession();
		return companies;
	}

	@RequestMapping(value = "/company/get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Company get(@PathVariable int id)
	{
		return this.companyService.get(id);
	}

	@RequestMapping(value = "/company/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Company> list()
	{
		return this.companyService.list();
	}

	@RequestMapping(value = "/company/update/country/{id}/{country}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Company updateCountry(@PathVariable int id, @PathVariable String country)
	{
		Company company = this.companyService.get(id);
		company.setCountry(country);
		this.companyService.update(company);
		AFSService.closeSession();
		return company;
	}

	@RequestMapping(value = "/company/update/name/{id}/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Company updateName(@PathVariable int id, @PathVariable String name)
	{
		Company company = this.companyService.get(id);
		company.setName(name);
		this.companyService.update(company);
		AFSService.closeSession();
		return company;
	}

}
