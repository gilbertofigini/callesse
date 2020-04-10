package it.gilbertofigini.callesse.util;

import it.gilbertofigini.callesse.service.model.DeliverySlots;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCaller {
    final static Logger LOG = LoggerFactory.getLogger(RestCaller.class);

    public ResponseEntity<DeliverySlots> callApisEsseWithCustomHeaders(String uri, HttpMethod httpMethod, HttpEntity<String> entity) {
        LOG.debug("start callStatusEsse");
        ResponseEntity<Object> result = null;
        RestTemplate restTemplate = new RestTemplate();
        LOG.debug("end callStatusEsse");
        return restTemplate.exchange(uri, httpMethod, entity, DeliverySlots.class);
    }

    public String postLoginEsse() {
        return null;
    }
}
