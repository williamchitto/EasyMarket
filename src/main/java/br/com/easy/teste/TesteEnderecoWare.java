package br.com.easy.teste;

import br.com.easy.model.EnderecoWare;
import br.com.easy.webservicecep.DevWareCEPService;

public class TesteEnderecoWare {

	public static void main(String[] args) {
		
		DevWareCEPService cepService = new DevWareCEPService();
		EnderecoWare endereco = cepService.consultarCEP("78093559");
		System.out.println(endereco.getBairro());
		System.out.println(endereco.getCep());
		System.out.println(endereco.getCidade());
		System.out.println(endereco.getEstado());
		System.out.println(endereco.getLogradouro());
		System.out.println(endereco.getLogradouro_curto());
		System.out.println(endereco.getUf());
		System.out.println(endereco.getResultado_txt());
		System.out.println(endereco.getNumero());
    

		

	}

}
