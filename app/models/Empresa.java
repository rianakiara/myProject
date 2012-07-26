package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Empresa extends Model {
	
	@Required
	public String nome;
	
	@Required
	public String razaoSocial;
	
	@Required
	public String cnpj;
	
	@Required
	public String telefone;
	
	@Required
	public String endereco;
	
	public static List<Empresa> findByNameOrCnpj(String text){
		return find("from Empresa e where lower(e.nome) like ? or lower(e.cnpj) = ?", "%"+text.toLowerCase()+"%", text.toLowerCase()).fetch();
	}

}
