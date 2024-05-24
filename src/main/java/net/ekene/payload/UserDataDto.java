package net.ekene.payload;

import lombok.*;
import net.ekene.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDataDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
