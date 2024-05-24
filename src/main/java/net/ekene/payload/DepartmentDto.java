package net.ekene.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private String departmentName;
    private String headOfDepartmentEmail;
    private LocalDate dateCreated;
    private boolean accredited;
}
