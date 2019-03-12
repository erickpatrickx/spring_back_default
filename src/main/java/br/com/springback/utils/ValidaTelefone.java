package br.com.springback.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaTelefone {
           
	private static final String TELEFONE_PATTERN = 
	        "(\\([1-9][0-9]\\)?|[1-9][0-9])\\s?([9]{1})?([0-9]{4})-?([0-9]{4})$";

	private static final Pattern pattern = Pattern.compile(TELEFONE_PATTERN, Pattern.CASE_INSENSITIVE);
	
    public static boolean isTelefone(String telefone) {
    	   	Matcher  matcher = pattern.matcher(telefone);
    	    return matcher.matches();
    }
}          
        