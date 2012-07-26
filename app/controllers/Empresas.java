package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Empresa;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Empresas extends Controller{
	
	public static void list() {
		List<Empresa> listaEmpr = new ArrayList<Empresa>();
		listaEmpr = Empresa.findAll();
		render(listaEmpr);
	}
	
	public static void blank() {
		render();
	}
	
	public static void save(@Valid Empresa empresa){
		if(validation.hasErrors()){
			flash.error("Preencha os campos corretamente");
			render("Empresas/blank.html", empresa);
		}else{
			empresa.save();
			flash.success("Cadastro feito com sucesso !");
		}
		list();
	}
	
	public static void edit(long id) {
		Empresa empresa = Empresa.findById(id);
		render(empresa);
	}	
	
	public static void delete(long id) {
		Empresa empresa = Empresa.findById(id);
		empresa.delete();
		flash.success("Empresa excluida com sucesso !");
		list();
	}
	
	public static void search(String text) {
    	List<Empresa> lista = Empresa.findByNameOrCnpj(text);
    	render("Application/list.html", lista, text);
    }
   
}
