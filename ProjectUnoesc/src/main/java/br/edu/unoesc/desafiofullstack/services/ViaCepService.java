/*package br.edu.unoesc.desafiofullstack.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.desafiofullstack.classes.ViaCepRecord;

@Service
public class ViaCepService {
	
	class ViaCepException extends Exception {
	    public ViaCEPException(String message) {
	        super(message);
	    }
	}
	
	public ViaCepRecord validaEndereco(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ViaCepRecord> resp = 
				restTemplate
				.getForEntity(
						String.format("https://viacep.com.br/ws/%s/json/", cep),
						ViaCepRecord.class);
				if (resp.getStatusCode() == HttpStatus.OK) {
					return resp.getBody();
				} else {
	                throw new ViaCEPException("Erro na requisição ao ViaCEP. Status: " + responseEntity.getStatusCodeValue());
	            }
	        } catch (HttpClientErrorException.NotFound e) {
	            throw new ViaCEPException("CEP não encontrado");
	        } catch (HttpClientErrorException.BadRequest e) {
	            throw new ViaCEPException("CEP inválido");
	        } catch (Exception e) {
	            throw new ViaCEPException("Erro desconhecido: " + e.getMessage());
	        }
	}
}
*/

package br.edu.unoesc.desafiofullstack.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.edu.unoesc.desafiofullstack.classes.Endereco;
import br.edu.unoesc.desafiofullstack.classes.ViaCepRecord;

@Service
public class ViaCepService {

    public ViaCepRecord validaEndereco(Endereco enderecoJson){
    	RestTemplate restEntity = new RestTemplate();
    	ResponseEntity<ViaCepRecord> response = restEntity.getForEntity(
    			String.format("https://viacep.com.br/ws/%s/json/", enderecoJson.cep()), ViaCepRecord.class);	
    	ViaCepRecord retornaDados = response.getBody();
    	return retornaDados;
    }
}
