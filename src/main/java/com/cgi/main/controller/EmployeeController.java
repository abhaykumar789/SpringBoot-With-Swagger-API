package com.cgi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.main.entity.Employee;
import com.cgi.main.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/empsapp/")
public class EmployeeController {

	@Autowired
	private EmployeeService eservice;

	// handler methods

	@GetMapping("home")
	@ApiOperation("HOME-PAGE")
	public String message() {
		return "WELCOME TO HOME PAGE";
	}
	// Write the Handler Method for handling the POST request which is coming
	// from the client side.
	@PostMapping("saveemployee")
	// @RequestMapping(path = "/saveemployee",method = RequestMethod.POST,consumes
	// =MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("SAVE-EMPLOYEE")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		// write the logic to save the data into the database.
		System.out.println(employee);
		eservice.saveEmployee(employee);
		return new ResponseEntity<String>("SUCCESSFULLY-STORED-IN-DB", HttpStatus.OK);
	}

	@GetMapping("employees")
	//@RequestMapping(path = "employees",method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
	@ApiOperation("GET-ALL-EMPLOYEES")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = this.eservice.getAllEmployees();
		System.out.println(list);// logs
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}

	@DeleteMapping("deleteemployee/{id}")
	@ApiOperation("DELETE-ENTITY-BY-ID")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		this.eservice.deleteById(id);
		return new ResponseEntity<String>("SUCCESSFULLY-DELETE-RECORD", HttpStatus.OK);
	}

	@PutMapping("updateemployee")
	@ApiOperation("UPDATE-EMPLOYEE-DETAILS")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		this.eservice.updateEmployee(employee);
		return new ResponseEntity<String>("SUCCESSFULLy-UPDATED", HttpStatus.OK);
	}

	@GetMapping("employee/{id}")
	@ApiOperation("SEARCH-EMPLOYEE-BY-ID")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
		Employee emp = this.eservice.getEmployeeById(id);

		if (emp == null)
			return new ResponseEntity<Object>("RECORD IS NOT FOUND", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(emp, HttpStatus.OK);
	}

}
