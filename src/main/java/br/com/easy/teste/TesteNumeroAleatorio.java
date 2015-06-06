package br.com.easy.teste;

import java.util.Random;

public class TesteNumeroAleatorio {
	
	
	public static int addVisualizacao(int valor){
		
		  valor++;	

			return valor;
		}
		
		

	public static void main(String[] args) {
		
		//System.out.println(addVisualizacao(4));
		int j = (int) (Math.random() * 10);
		System.out.println(j);
		
		

	  

	}

}
