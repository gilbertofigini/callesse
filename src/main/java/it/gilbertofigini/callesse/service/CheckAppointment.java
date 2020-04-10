package it.gilbertofigini.callesse.service;

import it.gilbertofigini.callesse.service.model.DeliverySlots;
import it.gilbertofigini.callesse.service.model.Slot;
import it.gilbertofigini.callesse.util.RestCaller;
import it.gilbertofigini.callesse.util.UtilMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CheckAppointment {
    static final Logger LOG = LoggerFactory.getLogger(CheckAppointment.class);
    static final String host = "www.esselungaacasa.it";

    @Value("${application.esselunga.cookie}")
    private String cookie;
    @Value("${application.esselunga.token}")
    private String token;
    @Value("${application.esselunga.referer}")
    private String referer;
    @Value("${application.esselunga.uriCheckStatus}")
    private String uriCheckStatus;
    @Value("${application.esselunga.uriCheckStatus}")
    private String uriLoginExt;

    public void loginEsse() {
        LOG.debug("start loginEsse");

        RestCaller restCaller = new RestCaller();

        LOG.debug("set headers");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        headers.setCacheControl("no-cache");
        headers.set("Cookie", cookie);
        headers.setConnection("keep-alive");
        headers.set("Referer", referer);
        headers.set("X-XSRF-TOKEN", token);



        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<DeliverySlots> result = null;
        try {
            LOG.info("call {}", uriLoginExt);
//            result = callStatusEsse(uri, HttpMethod.GET, entity);
//            String result = restCaller.postLoginEsse();
            LOG.info("check result");
//            checkIfEnable(result);
        } catch (Exception e) {
            LOG.error("errore nella call REST ", e);
        }

        System.out.println(result.toString());

        LOG.debug("end loginEsse");
    }

    public void checkAppointEsse() {
        LOG.debug("start checkAppointEsse");

        RestCaller restCaller = new RestCaller();
        LOG.debug("cookie From prop {}",cookie);
        LOG.debug("token From prop {}",token);
        LOG.debug("referer From prop {}",referer);
        LOG.debug("referer From prop {}",uriCheckStatus);


        LOG.debug("set headers");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setCacheControl("no-cache");
        headers.set("Cookie", cookie);
        headers.setConnection("keep-alive");
        headers.set("Referer", referer);
        headers.set("X-XSRF-TOKEN", token);

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<DeliverySlots> result = null;
        try {
//            LOG.info("call {}", uri);
//            result = callStatusEsse(uriCheckStatus, HttpMethod.GET, entity);
            result = restCaller.callApisEsseWithCustomHeaders(uriCheckStatus, HttpMethod.GET, entity);
            if (result.getStatusCode().is2xxSuccessful()) {
                LOG.info("result code {}", result.getStatusCodeValue());
                LOG.debug("check result");
                checkIfEnable(result);
            } else if (result.getStatusCodeValue() == 401) {
                LOG.info("TODO Proviamo a loggarci");
//                loginEsse();
            }

        } catch (Exception e) {
            LOG.error("errore nella call REST ", e);
        }

        System.out.println(result.toString());

        LOG.debug("end checkAppointEsse");
    }

   /* private ResponseEntity<DeliverySlots> callStatusEsse(String uri, HttpMethod httpMethod, HttpEntity<String> entity) {
        LOG.debug("start callStatusEsse");
        ResponseEntity<DeliverySlots> result = null;
        RestTemplate restTemplate = new RestTemplate();
        LOG.debug("end callStatusEsse");
        return restTemplate.exchange(uri, httpMethod, entity, DeliverySlots.class);
    }*/

    private void checkIfEnable(ResponseEntity<DeliverySlots> result) {
        LOG.debug("start checkIfEnable");
        DeliverySlots deliverySlots = result.getBody();
        List<Slot> slots = deliverySlots.getSlots();
        UtilMail utilMail = new UtilMail();
        String status = null;
        Boolean finded = true;
        //int i = 1;
        for (Slot slot : slots) {
            if (!slot.getViewStatus().equalsIgnoreCase("esaurita")) {
                LOG.info("!!!!!!!!!!!!!!!!!!LIBERA!!!!!!!!!!!!! {}", slot.getViewStatus());
                LOG.info("!!!!!!!!!!!!!!!!!!LIBERA!!!!!!!!!!!!! {}", slot.getStartTime());
                LOG.info("!!!!!!!!!!!!!!!!!!LIBERA!!!!!!!!!!!!! {}", slot.getEndTime());
                /*List<String> templateArgs = new ArrayList<String>();
                templateArgs.add(slot.getViewStatus());
                templateArgs.add(slot.getStartTime());
                templateArgs.add(slot.getEndTime());
                String text = String.format(template.getText(), templateArgs);
                emailService.sendSimpleMessage("gilberto.figini@gmail.com", "Esselunga trovata fascia oraria", text);*/
            } else {
                finded = false;
                status = slot.getViewStatus();
                /*if (i<2) {
                    try {
                        //587
                        String text = String.format(template.getText(), slot.getViewStatus(), slot.getStartTime(), slot.getEndTime());
                        utilMail.sendMail(text, "figini.gilberto@gmail.com", "gilberto.figini@gmail.com", "Esselunga trovata fascia oraria");
                        //emailService.sendSimpleMessage("gilberto.figini@gmail.com", "Esselunga trovata fascia oraria", text);
                    } catch (Exception e) {
                        LOG.error("errore in sendMail",e);
                    }
                }*/
            }
            //i++;
        }
        if (!finded)
            LOG.info("tutto esaurito {}", status);
        LOG.debug("end checkIfEnable");
    }
}
