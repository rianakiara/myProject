package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cliente extends Model {
	
	@Required
	public String nome;
	
	@Email
	@Required
	public String email;
	
	@Required
	public String telefone;
	
	@Required
	public String endereco;
	
	@Required
	public Date dataNasc;

	@Required
	public String cpf;
	
	
	public static List<Cliente> findByNameOrEmail(String text){
		return find("from Cliente c where lower(c.nome) like ? or lower(c.email) = ?", "%"+text.toLowerCase()+"%", text.toLowerCase()).fetch();
	}

}