package edu.poly.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import edu.poly.shop.domain.Category;
import edu.poly.shop.service.CategoryService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Actions(value = {
		@Action(value = "index", results = {
				@Result(location = "/index.jsp")
		})
})
@Results({
		@Result(name = "input", location = "/categories/add.jsp"),
		@Result(name = "success", location = "/categories/list.jsp")
})
public class CategoryAction extends ActionSupport
		implements ModelDriven<Category>, Preparable, SessionAware, HttpParametersAware {
	
	@Autowired
	private CategoryService categoryService;

	private String idEdit;

	private Category category;

	private List<Category> categories;


	private Map<String, Object> sessionAttributes = null;

	@Action(value = "/category/addOrEdit")
    public String addOrEdit(){
    	return INPUT;
    }

    @Action(value = "/category/saveOrUpdate", results = {
    		@Result(name = "success", type = "redirect", location = "list")
	})
    public String saveOrUpdate(){
		try {
			categoryService.save(category);

		}catch (Exception ex){
			ex.printStackTrace();
			return  INPUT;
		}

		return SUCCESS;
	}

	@Action(value = "/category/list")
    public String list(){
    	try {
    		categories = (List<Category>) categoryService.findAll();

    		return SUCCESS;
		}catch (Exception ex){
    		ex.printStackTrace();
    		return ERROR;
		}
	}
	@Action(value = "/category/delete")
	public String delete(){
		try {
			categoryService.delete(category);

			return SUCCESS;
		}catch (Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionAttributes = session;
	}

	@Override
	public void prepare() throws Exception {
		if (idEdit != null && !idEdit.equals("")) {
			category = categoryService.findOne(Long.parseLong(idEdit));
		}else {
			category = new Category();
		}
	}

	@Override
	public Category getModel() {
		return category;
	}

	public String getIdEdit() {
		return idEdit;
	}

	public void setIdEdit(String idEdit) {
		this.idEdit = idEdit;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public boolean isNoData() {
		return categories == null || categories.size()==0;
	}

	@Override
	public void setParameters(HttpParameters parameters) {
    	if (parameters.size()>0 && parameters.containsKey("idEdit"))
			this.idEdit = parameters.get("idEdit").getValue();
	}
}
