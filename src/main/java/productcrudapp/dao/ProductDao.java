package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate template;
	
	// New Product
	@Transactional
	public void createNewProduct(Product product)
	{
		this.template.saveOrUpdate(product);
	}
	
	// Load all
	public List<Product> getAllProducts()
	{
		List<Product> products = this.template.loadAll(Product.class);
		return products;
	}
	
	// Load 1 product with Id
	public Product getProduct(int pid)
	{
		Product product = this.template.get(Product.class, pid);
		return product;
	}
	
	// Delete with Id
	@Transactional
	public void deleteProduct(int pid)
	{
		Product product = this.template.get(Product.class, pid);
		this.template.delete(product);
	}
	
}
