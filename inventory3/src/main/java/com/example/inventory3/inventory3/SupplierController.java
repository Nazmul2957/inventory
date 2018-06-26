package com.example.inventory3.inventory3;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.Message;
import com.model.Supplier;
import com.servicecontact.ISupplierService;

@RequestMapping("/supplier")
@Scope("request")
@Controller
public class SupplierController {
	@Autowired
	ISupplierService supplierApp;
	
	//request for page
	@RequestMapping("/")
	public String index(Model model) {
		try{List<Supplier> suppliers=supplierApp.Get();
		//Customer customer=customerApp.Get(1);
	    model.addAttribute("obj",suppliers);
		}catch (HibernateException e) {
			return "customer/update";
		}
		//return "customer/customer";
	return "AircraftAdmin-Free/supplier-list";
		
	}
	@RequestMapping("/addsupplier")
	public String add (Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("obj",supplier);
		return "AircraftAdmin-Free/add-suppliers";
			}
	
	
	
	//request from thymleaf
	@RequestMapping(value = "/ioi2", method = RequestMethod.POST)//request for save data from add page
	public  String aa( @ModelAttribute("obj")Supplier supplier, 
			   Model model) {
		
		boolean issave=supplierApp.Save(supplier);
		if(issave) {
	    //model.addAttribute("obj",customer);
	    return "redirect:/supplier/addsupplier";
		}
		else 
		    return "customer/eror";
		//System.out.println(firstname);
	}
	
	
	
	
	///request from javaScript	
	@RequestMapping(value = "/saveSupplier" ,method = RequestMethod.POST, produces = "application/json")//request for update data
	@ResponseBody
	public Message  postCustomer(@RequestBody Supplier supplier) {
		if(supplier.getId()>0) {
			supplierApp.Update(supplier);
			Message  message  = new Message ("Done", supplier);
		return message ;
		}
		else {
			supplierApp.Save(supplier);
		Message  message  = new Message ("Done", supplier);
			return message ;
		}
		
	}
	
	@RequestMapping(value = "/allsupp",method=RequestMethod.GET, produces = "application/json")//request for get all data
	@ResponseBody
	   public Message getResource() {
		List<Supplier> suppliers=supplierApp.Get();
	    Message message = new Message ("Done", suppliers);
		
		return message;
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET, produces = "application/json")//request for get value by id for edit data
	@ResponseBody
    public Message get (@RequestParam int id) {
		Supplier supplier=supplierApp.Get(id);
     	Message  message  = new Message ("Done2", supplier);
		return message;   
		}
	
	@RequestMapping(value="/deletesupplier", method=RequestMethod.GET, produces = "application/json")//request for delete data
	@ResponseBody
    public Message deleteproduct1(@RequestParam int id) {
		supplierApp.Delete(id);
		Supplier supplier=new Supplier();
		Message  message  = new Message ("Done", supplier);
		return message ;
    }
	}

	
	

