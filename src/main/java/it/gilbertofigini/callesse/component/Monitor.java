package it.gilbertofigini.callesse.component;

import it.gilbertofigini.callesse.service.CheckAppointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Monitor {

    @Autowired
    private CheckAppointment checkAppointment;

    final static Logger LOG = LoggerFactory.getLogger(Monitor.class);

    @PostConstruct
    public void init() {
        LOG.debug("start init");
        //checkAppointment.checkAppointEsse();
        scheduledCheck();
        // initialize your monitor here, instance of someService is already injected by this time.
        LOG.debug("end init");
    }

    @Scheduled(cron = "0 0/3 * * * ?")
    private void scheduledCheck() {
        LOG.debug("start scheduledCheck");
        checkAppointment.checkAppointEsse();
        LOG.debug("start scheduledCheck");
    }
}
