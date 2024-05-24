package net.ekene.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppOtp {
    private String email;
    private String otp;
}
