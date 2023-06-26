package Twiliosms.TwilioSms.RestController;


import Twiliosms.TwilioSms.Dto.SMSRequest;
import Twiliosms.TwilioSms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SMSController {
    private final SMSService smsService;
    @Autowired
    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }
    // http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSMS(@RequestBody SMSRequest request)
    {
        String to = request.getTo(); // Recipient phone number
        String from = request.getFrom(); // Your Twilio phone number
        String body = request.getBody(); // SMS message body
        smsService.sendSMS(to, from, body);
        return ResponseEntity.ok("SMS sent successfully");
    }
}
