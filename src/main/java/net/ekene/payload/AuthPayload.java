package net.ekene.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthPayload {
    private String email;
    private String password;
}
