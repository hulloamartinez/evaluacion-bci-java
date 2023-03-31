package cl.hulloa.evaluation.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validation {
	
	public boolean validateEmail(String email) {
		
		Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
		
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();
		
	}
	
	public boolean validatePassword(String password) {
		
		Pattern pattern = Pattern.compile("(?=\\w*\\d{2,})(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
		
		Matcher matcher = pattern.matcher(password);
		
		return matcher.find();
		
	}

}
