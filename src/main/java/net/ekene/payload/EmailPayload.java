package net.ekene.payload;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import net.ekene.user.UserData;
import net.ekene.user.VerificationToken;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmailPayload {
    private String recipientAddress;
    private Map<String, Object> variables;
    private String templateName;
    private String mailSubject;

    public EmailPayload returnEmailPayload(UserData userData) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", userData.getFirstName());
        variables.put("email", userData.getEmail());

        return EmailPayload.builder()
                .recipientAddress(userData.getEmail())
                .variables(variables)
                .templateName("welcome-mail")
                .mailSubject("no-reply mail")
                .build();
    }

    public EmailPayload returnEmailPayload(VerificationToken verificationToken) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", verificationToken.getUserData().getFirstName());
        variables.put("email", verificationToken.getUserData().getEmail());
        variables.put("token", verificationToken.getToken());

        return EmailPayload.builder()
                .recipientAddress(verificationToken.getUserData().getEmail())
                .variables(variables)
                .templateName("verify_mail")
                .mailSubject("no-reply mail")
                .build();
    }

    public EmailPayload generateOtpMail(Object otp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AppOtp appOtp = objectMapper.readValue((JsonParser) otp, AppOtp.class);

        Map<String, Object> variables = new HashMap<>();
        variables.put("email", appOtp.getEmail());
        variables.put("otp", appOtp.getOtp());

        return EmailPayload.builder()
                .recipientAddress(appOtp.getEmail())
                .variables(variables)
                .templateName("verify_mail")
                .mailSubject("no-reply mail")
                .build();
    }

    public EmailPayload resetPasswordEmailPayload(UserData userData) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("firstName", userData.getFirstName());
        variables.put("email", userData.getEmail());


        return EmailPayload.builder()
                .recipientAddress(userData.getEmail())
                .variables(variables)
                .templateName("reset_password")
                .mailSubject("no-reply mail")
                .build();
    }
}
