package co.com.banco.util;

import com.google.gson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Clase que representa cliente para consumir servicios Rest externos
 * @author Mquintero
 *
 */
@Service
public class ClientService {

    /**
     * Método para consumir servicio post
     *
     * @param url
     * @param body
     * @param mapaHeaders
     * @param respuesta
     * @param <T>
     * @param <V>
     * @return
     */
    public <T, V> V postClient(String url, T body, Map<String, String> mapaHeaders, Class<V> respuesta) {
        RestTemplate restTemplate = new RestTemplate();
        String json = "";
        if (body != null) {
            json = new Gson().toJson(body);
        }
        HttpHeaders headers = new HttpHeaders();
        if (mapaHeaders != null) {
            mapaHeaders.forEach((k, v) -> headers.set(k, v));
        }
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        V resp = restTemplate.postForObject(url, request, respuesta);
        return resp;
    }
    
    /**
     * Método para consumir servicio delete
     *
     * @param url
     * @param body
     * @param mapaHeaders
     * @param respuesta
     * @param <T>
     * @param <V>
     * @return
     */
    public <T, V> V deleteClient(String url, T body, Map<String, String> mapaHeaders, Class<V> respuesta) {
        RestTemplate restTemplate = new RestTemplate();
        String json = "";
        if (body != null) {
            json = new Gson().toJson(body);
        }
        HttpHeaders headers = new HttpHeaders();
        if (mapaHeaders != null) {
            mapaHeaders.forEach((k, v) -> headers.set(k, v));
        }
        HttpEntity<String> request = new HttpEntity<>(json, headers);
		V resp = restTemplate.exchange(url, HttpMethod.DELETE, request, respuesta).getBody();
        return resp;
    }

    /**
     * Método para consumir servicio get
     *
     * @param url
     * @param mapaHeaders
     * @param responseType
     * @param <T>
     * @return
     */
    public <T> T getClient(String url, Map<String, String> mapaHeaders, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        if (mapaHeaders != null) {
            mapaHeaders.forEach((k, v) -> headers.set(k, v));
        }
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        ResponseEntity<T> resp = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
        return responseType.cast(resp.getBody());
    }
    
    /**
     * Método para consumir servicio post
     *
     * @param url
     * @param body
     * @param mapaHeaders
     * @param <T>
     * @return
     */
    @SuppressWarnings("rawtypes")
	public <T> ResponseEntity postClient(String url, T body, Map<String, String> mapaHeaders) {
        RestTemplate restTemplate = new RestTemplate();
        String json = new Gson().toJson(body);
        HttpHeaders headers = new HttpHeaders();
        if (mapaHeaders != null) {
            mapaHeaders.forEach((k, v) -> headers.set(k, v));
        }
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity resp = restTemplate.postForEntity(url, request, String.class);
        return resp;
    }

    /**
     * Método para consumir servicio get
     *
     * @param url
     * @param mapaHeaders
     * @return
     */
    @SuppressWarnings("rawtypes")
	public ResponseEntity getClient(String url, Map<String, String> mapaHeaders) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        if (mapaHeaders != null) {
            mapaHeaders.forEach((k, v) -> headers.set(k, v));
        }
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        ResponseEntity resp = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return resp;
    }
}
