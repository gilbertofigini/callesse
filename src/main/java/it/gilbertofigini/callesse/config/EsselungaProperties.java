package it.gilbertofigini.callesse.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.esselunga")
@Data
public class EsselungaProperties {

    private String cookie;
    private String token;
    private String referer;
    private String uriCheckStatus;
    private String uriLoginExt;
}
