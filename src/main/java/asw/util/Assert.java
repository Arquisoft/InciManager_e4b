package asw.util;

import asw.database.entities.Agent;

public class Assert {

	/**
	 * 
	 * @param email
	 * @return excepcion si esta vacio
	 */
	public static boolean isEmailEmpty(String email) {
		if(email.trim().isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isPasswordEmpty(String password) {
		if(password.trim().isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Comprobacion de si el correo es valido
	 * @param email
	 * @return true si es valido.
	 */
	public static boolean isEmailValid(String email) {
		String[] mailSplit = email.split("@");
		if (mailSplit.length != 2) {
			return false;
		}
		mailSplit = email.split("\\.");
		if (mailSplit.length != 2 || mailSplit[0].length() == 0 || mailSplit[1].length() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param participant
	 * @return devuelve false si no es null o excepcion
	 */
	public static boolean isAgentNull(Agent agent){
		if (agent == null) {
			return true;
		}
		return false;		
	}
	
	public static boolean isPasswordCorrect(String password,Agent agent){
		if (!password.equals(agent.getPassword())) {
			return false;
		}
		return true;
	}
	
	public static boolean isSamePassword(String password, String password2){
		if (password.equals(password2)) {
			return false;
		}
		return true;
	}

	public static boolean isSameEmail(String email, String email2){
		if (email.equals(email2)) {
			return false;
		}
		return true;
	}
	
	public static boolean isUserIdEmpty(String userId) {
		if(userId.trim().isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isKindEmpty(String kind) {
		if(kind.trim().isEmpty())
			return true;
		else
			return false;
	}

}
