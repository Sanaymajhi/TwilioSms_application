package Twiliosms.TwilioSms.service;


import Twiliosms.TwilioSms.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SMSService {
    private final TwilioConfig twilioConfig;
    @Autowired
    public SMSService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(twilioConfig.getAccountSid(),
                twilioConfig.getAuthToken());
    }
    public void sendSMS(String to, String from, String body) {
        Message.creator(new PhoneNumber(to), new PhoneNumber(from),
                body).create();
    }
}
