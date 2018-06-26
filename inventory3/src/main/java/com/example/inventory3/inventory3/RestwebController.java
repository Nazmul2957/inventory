package com.example.inventory3.inventory3;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.Message;
import com.servicecontact.ICustomerService;


@RestController
@RequestMapping("customer")
public class RestwebController {
//	   @Autowired
//	    ICustomerService customerApp;
//		List<Customer> cust = new ArrayList<Customer>();
//	 
//		@GetMapping(value = "/all")
//		public Message getResource() {
//			List<Customer> customers=customerApp.Get();
//			Message message = new Message ("Done", customers);
//			
//			return message;
//		}
//		
//		@PostMapping(value = "/save")
//		public Message  postCustomer(@RequestBody Customer customer) {
//			//cust.add(customer);
//			if(customer.getId()>0) {
//				customerApp.Update(customer);
//				Message  message  = new Message ("Done", customer);
//				return message ;
//			}
//			else {
//				customerApp.Save(customer);
//				Message  message  = new Message ("Done", customer);
//				return message ;
//				
//			}
//		}
//		@GetMapping(value = "/get/{id}")
//		public Message getCustomeredit(@PathVariable Integer id) {
//			
//			Customer customer=customerApp.Get(id);
//			Message  message  = new Message ("Done", customer);
//			return message;
//		}
//		@DeleteMapping(value = "/delete/{id}")
//		public String deleteCustomer(@PathVariable Integer id) {
//			
//			customerApp.Delete(id);
//			return "OK!";
//		}
	}

