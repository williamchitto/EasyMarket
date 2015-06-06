package br.com.easy.teste;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

public class Teste {
	
	
	public static void main(String[] args) {
	
		Date data01 = new Date();
		DateTime data = new DateTime();
		DateTime dataMaisDias = data.plusDays(365);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(dataMaisDias.getMillis());
		data01 = calendar.getTime();
		System.out.println(data01);
		
	}

}
