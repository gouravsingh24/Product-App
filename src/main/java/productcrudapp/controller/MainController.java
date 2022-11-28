package productcrudapp.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao dao;
	@Autowired
	private Date date;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products = dao.getAllProducts();
		m.addAttribute("products", products);
		return "Index";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "Add Product");
		return "add-product-form";
	}
	
	@RequestMapping(path = "/handleProduct" , method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product , HttpServletRequest request)
	{
		String dates = date + "";
		product.setDate(dates);
		this.dao.createNewProduct(product);
		RedirectView redirectView = new RedirectView();
		String url =  request.getContextPath()+"/";
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@RequestMapping("/deleteProduct/{pid}")
	public RedirectView handleDelete(@PathVariable("pid") int productId , HttpServletRequest request)
	{
		dao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		String url =  request.getContextPath()+"/";
		redirectView.setUrl(url);
		return redirectView;
	}
	
	@RequestMapping("/updateProduct/{pid}")
	public String handleUpdate(Model m , @PathVariable("pid") int id)
	{
		m.addAttribute("title", "Update Products");
		Product product = dao.getProduct(id);
		m.addAttribute("product",product);
		return "updateProduct";
	}
}
