package br.com.easy.webservicecep;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.easy.model.EnderecoWare;

public class DevWareCEPService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnderecoWare consultarCEP(String CEP) {

		EnderecoWare endereco = null;
		URL url;
		JAXBContext jc;
		Unmarshaller u;

		try {
			
			//Cria o contexto JAXB
			jc = JAXBContext.newInstance(EnderecoWare.class);
			
			//Instancia o componente Unmarshaller, utilizado para transformar um XML em um objeto
			u = jc.createUnmarshaller();

			//Atraves da classe URL, realiza o acesso a URL do servico, realizando a leitura do body resultante da
			//consulta realizada
			url = new URL("http://www.devmedia.com.br/devware/cep/service/?cep=" + CEP + "&chave=P5GZPOJ1YZ&formato=xml");

			//Realiza o unmarshal do conteudo obtido pela classe URL, transformando em um objeto do tipo EnderecoTO
			endereco = (EnderecoWare) u.unmarshal(url);
			endereco.setCep(CEP);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
		

		return endereco;
	}

}
