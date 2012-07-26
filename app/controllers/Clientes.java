package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import play.data.validation.Valid;
import play.mvc.Controller;

/**
 * Classe que representa o controller de Clientes
 * @author yudi
 * @date 24/06/2012
 */
public class Clientes extends Controller {

	public static void list() {
    	List<Cliente> lista = new ArrayList<Cliente>();
    	lista = Cliente.findAll();
        render(lista);
    }
    
    public static void blank() {
    	render();
    }
    
    public static void save(@Valid Cliente cliente){
    		flash.error("Preencha os campos corretamente");
    		if(validation.hasErrors()){
    		render("Clientes/blank.html", cliente);
    	}else{
    		cliente.save();
    		flash.success("Cadastro feito com sucesso !");
    	}
    	list();
    }

    public static void edit(long id) {
    	Cliente cliente = Cliente.findById(id);
    	render(cliente);
    }
    
    public static void delete(long id) {
    	Cliente cliente = Cliente.findById(id);
    	cliente.delete();
    	flash.success("Cliente excluido com sucesso !");
    	list();
    }
    
    public static void search(String text) {
    	List<Cliente> lista = Cliente.findByNameOrEmail(text);
    	render("Clientes/list.html", lista, text);
    }
}
