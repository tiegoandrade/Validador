import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que possui os m�todos de valida��o.
 * @author Tiego
 */
public class Validador {
	
	
	/**
	 * M�todo que valida um determinado CPF
	 * @param cpf: CPF que ser� validado
	 * @return: Retorna true se o CPF estiver formatado ou False caso contr�rio.
	 */
	public static boolean validarCPF(String cpf) {
		
		/*
		 * Aceita os seguintes formatos de CPF:
		 * 432.567.324-01
		 * 43256732401
		 * 432 567 324 01
		 */
		String regex = "\\d\\d\\d([\\.\\s])?\\d\\d\\d([\\.\\s])?\\d\\d\\d([-\\s])?\\d\\d";
		return validarRegex(cpf,regex);
	}
	
	/**
	 * M�todo que valida um determinado telefone.
	 * @param telefone: Telefone que ser� validado.
	 * @return: Retorna o true se o Telefone estiver formatado ou False caso contr�rio.
	 */
	public static boolean validarTelefone(String telefone) {
		
		/*
		 * Aceita os seguintes formatos de telefone:
		 * 5634-2395
		 * 5634 2395
		 * (99) 5634-2395
		 */
		String regex = "(\\(\\d\\d\\))?\\s*\\d\\d\\d\\d([-\\s])?\\d\\d\\d\\d";
		return validarRegex(telefone,regex);
	}
	
	/**
	 * M�todo que executa a valida��o
	 * @param str: Recebe uma String de um telefone ou CPF.
	 * @param regex: Recebe o padr�o utilizado para o telefone ou CPF
	 * @return: Retorna true se o telefone ou CPF combinam com os padr�es estipulados.
	 */
	private static boolean validarRegex(String str, String regex) {
		
		// Se for passada uma String vazia, a valida��o falha.
		if (str == null) {
			return false;
		}
		
		// "compile" recebe uma express�o regular.
		Pattern p = Pattern.compile(regex);
		
		// "matcher" recebe a string que ser� comparada.
		Matcher m = p.matcher(str);
		
		// Retorna true ou false dependendo se o padr�o e o telefone/cpf combinam.
		return m.matches();
	}
}
