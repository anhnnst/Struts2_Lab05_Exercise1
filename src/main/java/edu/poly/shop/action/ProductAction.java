package edu.poly.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import edu.poly.shop.constants.ActionConstant;
import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//import org.apache.struts2.convention.annotation.*;

@Results({
        @Result(name = "input", location = "/products/add.jsp"),
        @Result(name = "success", location = "/products/list.jsp"),
        @Result(name = "search", location = "/products/search.jsp")
})
@InterceptorRefs(value = {
        @InterceptorRef(value = "authStack"),
})
public class ProductAction extends ActionSupport
        implements ModelDriven<Product>, Preparable, HttpParametersAware {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    private Product product = new Product();

    private List<Product> products;

    private String idEdit;

    public String getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(String idEdit) {
        this.idEdit = idEdit;
    }

    private String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Action("/product/addOrEdit")
    public String addOrEdit() {
        return INPUT;
    }

    @Action(value="/product/saveOrUpdate", results = {
            @Result(name = "success", type = "redirect", location = "list")
    })
    public String saveOrUpdate() {
        productService.save(product);

        return SUCCESS;
    }

    @Action("/product/delete")
    public String delete() {
        productService.delete(product);

        return SUCCESS;
    }

    @Action("/product/list")
    public String list() {
        products = (List<Product>) productService.findAll();

        return SUCCESS;
    }

    @Action("/product/search")
    public String search() {
        System.out.println("search : " + searchText);
        if (searchText != null && !searchText.equals("")) {
            products = productService.findProductsByName(searchText);
        }else{
            products = (List<Product>) productService.findAll();
        }

        return ActionConstant.SEARCH;
    }

    @Override
    public Product getModel() {
        return product;
    }

    @Override
    public void prepare() {
        System.out.println(idEdit);
        if (idEdit != null && !idEdit .equals("")){
            product =productService.findOne(Long.parseLong(idEdit));
        }
        else{
            product = new Product();
            System.out.println("new product");
        }
    }

    @Override
    public void setParameters(HttpParameters parameters) {
        if (parameters.size()>0 && parameters.containsKey("idEdit"))
            this.idEdit= parameters.get("idEdit").getValue();
        if (parameters.size()>0 && parameters.containsKey("searchText"))
            this.searchText= parameters.get("searchText").getValue();

    }

    public List<Product> getProducts() {
        return products;
    }
    public List<Category> getCategories(){
        return (List<Category>) categoryService.findAll();
    }

    public boolean isNoData() {
        return products == null || products.size()==0;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
