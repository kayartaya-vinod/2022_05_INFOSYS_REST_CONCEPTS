package co.vinod.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vinod.model.Customer;
import co.vinod.model.CustomerList;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	List<Customer> customers = new ArrayList<Customer>();
	
	
	
	public CustomerController() {
		Customer c1 = new Customer();
		c1.setName("Vinod Kumar");
		c1.setCity("Bangalore");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
		c1.setId("0d3c8259-0c90-4331-a049-a468a0b723d7");
		customers.add(c1);
		
		c1 = new Customer();
		c1.setName("Shyam Sundar");
		c1.setCity("Bangalore");
		c1.setEmail("shyamsundar@xmpl.com");
		c1.setPhone("9731424123");
		c1.setId("4749d4fd-2e5f-4b7e-bd1e-bc5efcf5cf19");
		customers.add(c1);
		
		
		c1 = new Customer();
		c1.setName("Satish Kumar");
		c1.setCity("Chennai");
		c1.setEmail("satishkumar@xmpl.com");
		c1.setPhone("9731424321");
		c1.setId("4749d4fd-2e5f-4b7e-bd1e-bc5efcf5abcd");
		customers.add(c1);	}

	@GetMapping(produces = {
		"application/json", "application/xml"
	})
	public CustomerList getAll() {
		return new CustomerList(customers);
	}
	
	@GetMapping(path="/{id}", produces = {
		"application/json", "application/xml"
	})
	public ResponseEntity<Object> getById(@PathVariable String id) {
		Optional<Customer> result = customers.stream()
			.filter(c->c.getId().equals(id))
			.findFirst();
		
		if(result.isEmpty()) {
			// send 404
			Map<String, Object> err = new HashMap<>();
			err.put("message", "No data found for id " + id);
			err.put("timestamp", new Date());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}
		else {
			// send 200 + data
			return ResponseEntity.ok(result.get());
		}
	}
	

	@GetMapping("/info")
	public String info() {
		return "This is a simple REST endpoint\n" + "exposing customer details at \n"
				+ "http://localhost:1234/api/customers\n" + "\n" + "This current response came from \n"
				+ "http://localhost:1234/api/customers/info";
	}

}
