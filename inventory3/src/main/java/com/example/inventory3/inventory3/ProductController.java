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
import com.model.Product;

import com.servicecontact.IProductService;
@RequestMapping("/product")
@Scope("request")

@Controller
public class ProductController {
	@Autowired
	IProductService productApp;
	
	//request for page
	@RequestMapping("/")
	public String index(Model model) {
		try{List<Product> products=productApp.Get();
	    model.addAttribute("obj",products);
		}catch (HibernateException e) {
			return "customer/update";
		}
		//return "customer/customer";
	return "AircraftAdmin-Free/product-list";
		
	}
	@RequestMapping("/addproduct")
	public String add (Model model) {
		Product Product = new Product();
		model.addAttribute("obj",Product);
		return "AircraftAdmin-Free/add-products";
			}
	
	
	
	//request from thymleaf
	@RequestMapping(value = "/ioi2", method = RequestMethod.POST)//request for save data from add page
	public  String aa( @ModelAttribute("obj")Product product, 
			   Model model) {
		
		boolean issave=productApp.Save(product);
		if(issave) {
	    return "redirect:/product/add-product";
		}
		else 
		    return "customer/eror";
		//System.out.println(firstname);
	}
	
	
	
	
	///request from javaScript	
	@RequestMapping(value = "/saveproduct" ,method = RequestMethod.POST, produces = "application/json")//request for update data
	@ResponseBody
	public Message  postCustomer(@RequestBody Product product) {
		if(product.getId()>0) {
			productApp.Update(product);
			Message  message  = new Message ("Done", product);
		return message ;
		}
		else {
			productApp.Save(product);
		Message  message  = new Message ("Done", product);
			return message ;
		}
		
	}
	
	@RequestMapping(value = "/allprod",method=RequestMethod.GET, produces = "application/json")//request for get all data
	@ResponseBody
	   public Message getResource() {
		List<Product> products=productApp.Get();
	    Message message = new Message ("Done", products);
		
		return message;
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET, produces = "application/json")//request for get value by id for edit data
	@ResponseBody
    public Message get (@RequestParam int id) {
		Product product=productApp.Get(id);
     	Message  message  = new Message ("Done2", product);
		return message;   
		}
	
	@RequestMapping(value="/deleteproduct", method=RequestMethod.GET, produces = "application/json")//request for delete data
	@ResponseBody
    public Message deleteproduct1(@RequestParam int id) {
		productApp.Delete(id);
		Product product=new Product();
		Message  message  = new Message ("Done", product);
		return message ;
    }
	
	
}
