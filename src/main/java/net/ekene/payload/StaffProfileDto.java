package net.ekene.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffProfileDto {
    private String email;
    private String gender;
    private String phoneNumber;
    private LocalDate dob;
    @JsonIgnore(value = false)
    private String departmentName;
    private double salary;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
