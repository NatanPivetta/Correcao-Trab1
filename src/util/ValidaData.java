package util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public interface ValidaData{
    public static boolean validar(String date){
        
    	try {
    		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    		LocalDate d = LocalDate.parse(date, formatador);
    		return true;
    	}catch(DateTimeParseException e) {
    		return false;	
    	}
    }
}