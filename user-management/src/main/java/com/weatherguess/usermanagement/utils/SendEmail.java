package com.weatherguess.usermanagement.utils;

import com.sendgrid.*;

import java.io.IOException;

public class SendEmail {

    public static Boolean send(String to, String subject) throws IOException {
        Email fromEmail = new Email("ismailkouz2015@gmail.com");
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        return send(mail);
    }

    private static Boolean send(Mail mail) throws IOException {
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            return response.getStatusCode() == 200 || response.getStatusCode() == 202;
        } catch (IOException ex) {
            throw ex;
        }
    }


}
