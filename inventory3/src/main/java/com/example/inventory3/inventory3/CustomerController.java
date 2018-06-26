package com.example.inventory3.inventory3;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Customer;
import com.model.Message;
import com.servicecontact.ICustomerService;


@RequestMapping("/customer")
@Scope("request")
@Controller
public class CustomerController {
	
	@Autowired
	ICustomerService customerApp;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		try{List<Customer> customers=customerApp.Get();
		//Customer customer=customerApp.Get(1);
	    model.addAttribute("obj",customers);
		}catch (HibernateException e) {
			return "customer/update";
		}
		//return "customer/customer";
	return "AircraftAdmin-Free/customer-list";
		
	}
	@RequestMapping("/addcustomer")
	public String add (Model model) {
		Customer customer = new Customer();
		model.addAttribute("obj",customer);
		return "AircraftAdmin-Free/add-customer";
			}
//	@RequestMapping("/cus")
//	public String index1(Model model) {
//		try{List<Customer> customers=customerApp.Get();
//		//Customer customer=customerApp.Get(1);
//	    model.addAttribute("obj",customers);
//		}catch (HibernateException e) {
//			return "customer/update";
//		}
//		//return "customer/customer";
//	return "AircraftAdmin-Free/customer-list";
//		
//	}
//	@RequestMapping("/save")
//	public String Save() {
//		Customer customer = new Customer();
//		customer.setAddress("A1");
//		customer.setName("N1");
//		customerApp.Save(customer);
//		return "index";
//	}
//	@RequestMapping("/add")
//	public String add (Model model) {
//		Customer customer = new Customer();
//		model.addAttribute("obj",customer);
//		return "customer/add";
//		
//	}
	
	@RequestMapping(value = "/ioi", method = RequestMethod.POST)
	public  String aa( @ModelAttribute("obj")Customer customer, 
			   Model model) {
		
		boolean issave=customerApp.Save(customer);
		if(issave) {
	    //model.addAttribute("obj",customer);
	    return "redirect:/customer/addcustomer";
		}
		else 
		    return "customer/eror";
		//System.out.println(firstname);
	
		
	}
//	@RequestMapping("/findone")
//	public String findone(Integer id,Model model) {
//		Customer customer=new Customer();
//		customer=customerApp.Get(id);
//		model.addAttribute("obj",customer);
//		return "customer/edit";
//	}
//	@RequestMapping(value = "findone/up", method = RequestMethod.POST)
//	public  String update( @ModelAttribute("obj")Customer customer, 
//			   Model model) {
//		
//		customerApp.Update(customer);
//		
//	    return "redirect:/customer/";
//		}
	
//	@RequestMapping("/delete")
//	public String delete(Integer id,Model model) {
//		customerApp.Delete(id);
//		return "redirect:/customer/";
//	}
	
//	@RequestMapping(value="/delete1/{id}", method=RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//    public Message deleteproduct(@PathVariable int id) {
//		customerApp.Delete(id);
//		Customer customer=new Customer();
//		Message  message  = new Message ("Done", customer);
//		return message ;
//    }
	@RequestMapping(value="/delete2", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public Message deleteproduct1(@RequestParam int id) {
		customerApp.Delete(id);
		Customer customer=new Customer();
		Message  message  = new Message ("Done", customer);
		return message ;
    }
	@RequestMapping(value = "/save1" ,method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Message  postCustomer(@RequestBody Customer customer) {
		if(customer.getId()>0) {
		customerApp.Update(customer);
			Message  message  = new Message ("Done", customer);
		return message ;
		}
		else {
			customerApp.Save(customer);
		Message  message  = new Message ("Done", customer);
			return message ;
		}
		
	}
//	@RequestMapping(
//			  value = "/ex/foos", 
//			  method = RequestMethod.GET, 
//			  headers = "Accept=application/json")
//			@ResponseBody
//			public String getFoosAsJsonFromBrowser() {
//			    return "Get some Foos with Header Old";
//			}
	
	
	@RequestMapping(value = "/all",method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	   public Message getResource() {
		List<Customer> customers=customerApp.Get();
	    Message message = new Message ("Done", customers);
		
		return message;
	}
	@RequestMapping(value="/get", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public Message get (@RequestParam int id) {
		Customer customer=customerApp.Get(id);
     	Message  message  = new Message ("Done2", customer);
		return message;    }
	}


