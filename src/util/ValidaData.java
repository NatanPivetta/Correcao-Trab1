package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

public interface ValidaData {
	public static boolean validar(String data) {

		String dateFormat = "dd/MM/uuuu"; // utilizando "uuuu" no lugar de "yyyy", para que possa ser utilizado formato estrito

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat) // verifica formato da data
				.withResolverStyle(ResolverStyle.STRICT); // adiciona parametro estrito para verificar fenomenos como 29 de fevereiro ou dias que nao existem como 32 de julho
		try {
			LocalDate date = LocalDate.parse(data, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}