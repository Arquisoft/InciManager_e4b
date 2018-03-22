package asw.chatbot;

import java.util.HashMap;
import java.util.Map;

import asw.database.entities.Incidence;
import asw.database.location.Location;

//Clase creada con el patrón Singleton
public class ChatBot {

	static private ChatBot chatBot = new ChatBot();
	private int state;
	private Map<Integer, String> messages;
	private Map<Integer, String> errorMessages;
	private Map<Integer, String> finalValues;

	private ChatBot() {
		state = 0;

		// Inicializamos los mensajes que va a enviar al agente
		this.initMessages();

	}

	public static ChatBot getInstance() {
		return chatBot;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Map<Integer, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<Integer, String> messages) {
		this.messages = messages;
	}

	public Map<Integer, String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Map<Integer, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<Integer, String> getFinalValues() {
		return finalValues;
	}

	public void setFinalValues(Map<Integer, String> finalValues) {
		this.finalValues = finalValues;
	}

	// Inicializa los mensajes del bot
	public void initMessages() {
		messages = new HashMap<Integer, String>();
		errorMessages = new HashMap<Integer, String>();
		finalValues = new HashMap<Integer, String>();

		// Primer estado
		messages.put(0, "Bienvenido al asistente robótico de creación de incidencias.\n"
				+ "Le guiaré durante los pasos hasta que la incidencia esté creada y registrada en el sistema.\n"
				+ "En primer lugar, por favor introduzca el nombre de la incidencia que desea crear.");
		errorMessages.put(0, "El nombre de la incidencia no puede estar vacío.\n"
				+ "Por favor, introduzca un nombre válido para la incidencia a registrar.");

		// Segundo estado
		messages.put(1, "De acuerdo, ése será el nombre de la incidencia.\n"
				+ "Por favor, describa la incidencia con todos los detalles que pueda aportar.");
		errorMessages.put(1, "La descripción de la incidencia no puede estar vacía.\n"
				+ "Necesitamos que nos introduzca detalles para poder procesar la incidencia.");

		// Tercer estado
		messages.put(2,
				"Ya tenemos el nombre y la descripción de la incidencia.\n "
						+ "Ahora sólo nos hace falta saber la posición del incidente.\n"
						+ "Por favor, introduzca la latitud del incidente.");
		errorMessages.put(2,
				"No ha introducido una latitud válida.\n"
						+ "Necesitamos que nos introduzca la posición del incidente para poder procesarlo.\n"
						+ "Por favor, introduzca un dígito numérico que represente la latitud del incidente.");

		// cUARTO estado
		messages.put(3,
				"Ya casi hemos terminado.\n "
						+ "Sólo falta que introduzca la longitud del incidente y habremos terminado.");
		errorMessages.put(3,
				"No ha introducido una longitud válida.\n"
						+ "Necesitamos que nos introduzca la posición del incidente para poder procesarlo.\n"
						+ "Por favor, introduzca un dígito numérico que represente la longitud del incidente.");
	}
	
	public String getErrorMessage() {
		return errorMessages.get(state);
	}
	
	public String getMessage() {
		return messages.get(state);
	}
	
	public void nextState(String value) {
		finalValues.put(state, value);
		state++;
	}
	
	public void resetState() {
		state = 0;
	}
	
	public boolean isMessageValid(String msg) {
		if (state==0 || state==1) {
			return !(msg.isEmpty());
		}
		else {
			try {
				Double.valueOf(msg);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
			
	}
	
	public boolean isFinished() {
		return state == messages.size();
	}
	
	public Incidence getFinalIncidence() {
		Incidence i = new Incidence();
		i.setIncidenceName(finalValues.get(01));
		i.setDescripcion(finalValues.get(1));
		return i;
	}
	
	public Location getFinalLocation() {
		Location l = new Location();
		l.setLatitude(Double.valueOf(finalValues.get(2)));
		l.setLongitude(Double.valueOf(finalValues.get(3)));
		return l;
	}

}
