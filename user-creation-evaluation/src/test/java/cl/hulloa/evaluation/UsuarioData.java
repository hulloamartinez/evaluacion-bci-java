package cl.hulloa.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.hulloa.evaluation.models.Phone;
import cl.hulloa.evaluation.models.Usuario;
import cl.hulloa.evaluation.utils.DataTimeUtils;

public final class UsuarioData {
	
	static DataTimeUtils dataTimeUtils = new DataTimeUtils();
	
	public final static Usuario getUsuario() {
		
		
		
		Usuario user = new Usuario();
		List<Phone> listaPhone = new ArrayList<>();
		
		user.setId(UUID.randomUUID());
		user.setEmail("juanito@losclonosaurios.com");
		user.setPassword("aA12llos");
		user.setNombre("Juanito");
		
		listaPhone.add(new Phone("2","22","222"));
		listaPhone.add(new Phone("33","3","123456"));

		user.setPhones(listaPhone);
		
		user.setCreated(dataTimeUtils.fechaActual().toString());
		user.setActive(true);
		user.setToken(UUID.randomUUID().toString());
		user.setModified(dataTimeUtils.fechaActual().toString());
		user.setLastLogin(null);
		
		return user;
		
	}
	
	public final static Usuario getUsuarioPost() {
		
		Usuario user = new Usuario();
		List<Phone> listaPhone = new ArrayList<>();
		
		user.setId(UUID.randomUUID());
		user.setEmail("juanito@losclonosaurios.com");
		user.setPassword("aA12llos");
		user.setNombre("Juanito");
		
		listaPhone.add(new Phone("2","22","222"));
		listaPhone.add(new Phone("33","3","123456"));

		user.setPhones(listaPhone);
		
		
		return user;
		
	}
	

}
