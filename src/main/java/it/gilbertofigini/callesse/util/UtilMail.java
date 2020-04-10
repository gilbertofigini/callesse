package it.gilbertofigini.callesse.util;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class UtilMail {

    public static void sendMail(String text, String mailFrom, String mailTo, String subject) throws Exception {
        try {
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.socketFactory.port", "587");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.auth", "true");

            Authenticator auth = new MyAuthenticator();
            Session smtpSession = Session.getInstance(props, auth);
            smtpSession.setDebug(false);

            MimeMessage message = new MimeMessage(smtpSession);
            //SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));

            final String encoding = "UTF-8";

            message.setSubject(subject, encoding);
            message.setText(text, encoding);
            Transport.send(message);
        } catch (Exception e) {
            throw new Exception("sendMail()->Exception", e);
        }
    }

    static class MyAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = "figini.gilberto@gmail.com";
            String password = "DePippis80";

            return new PasswordAuthentication(username, password);
        }
    }
}
