package controllers;

import play.*;

import play.data.validation.Valid;
import play.mvc.*;
import java.util.*;
import models.*;

import java.util.List;

/**
 * 
 * @author yudi
 *
 */
public class Application extends Controller {

    public static void index() {
    	List<Cliente> lista = new ArrayList<Cliente>();
    	lista = Cliente.findAll();
        render(lista);
    }
    
    public static void form() {
    	render();
    }
    
    public static void salvar(@Valid Cliente cliente){
    		flash.error("Preencha os campos corretamente");
    		if(validation.hasErrors()){
    		render("Application/form.html", cliente);
    	}else{
    		cliente.save();
    		flash.success("Cadastro feito com sucesso !");
    	}
    	index();
    }

    public static void editar(long id) {
    	Cliente cliente = Cliente.findById(id);
    	render(cliente);
    }
    
    public static void excluir(long id) {
    	Cliente cliente = Cliente.findById(id);
    	cliente.delete();
    	flash.success("Cliente excluido com sucesso !");
    	index();
    }
    
    public static void buscarCliente(String text) {
    	List<Cliente> lista = Cliente.findByNameOrEmail(text);
    	render("Application/index.html", lista, text);
    }
    
    public static void buscarEmpresa(String text) {
    	List<Empresa> listaEmpr = Empresa.findByNameOrCnpj(text);
    	render("Application/indexEmpr.html", listaEmpr, text);
    }
    
    public static void indexEmpr() {
    	List<Empresa> listaEmpr = new ArrayList<Empresa>();
    	listaEmpr = Empresa.findAll();
        render(listaEmpr);
    }
    
    public static void formEmpr() {
    	render();
    }
    
    public static void salvarEmpr(@Valid Empresa empresa){
    	if(validation.hasErrors()){
    		flash.error("Preencha os campos corretamente");
    		render("Application/formEmpr.html", empresa);
    	}else{
    		empresa.save();
    		flash.success("Cadastro feito com sucesso !");
    	}
    	indexEmpr();
    }

    /**
     * 
     * @param id
     */
    public static void editarEmpr(long id) {
    	Empresa empresa = Empresa.findById(id);
    	render(empresa);
    }	
    
    /**
     * 
     * @param id
     */	
    public static void excluirEmpr(long id) {
    	Empresa empresa = Empresa.findById(id);
    	empresa.delete();
    	flash.success("Empresa excluida com sucesso !");
    	indexEmpr();
    }
    
}