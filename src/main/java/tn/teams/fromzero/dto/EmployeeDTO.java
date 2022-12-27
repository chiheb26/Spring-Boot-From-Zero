package tn.teams.fromzero.dto;

import lombok.*;
import tn.teams.fromzero.entities.Employee;

import javax.validation.constraints.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmployeeDTO {

    private Long id ;

    @NotBlank
    @NotEmpty (message = "le fullName doit etre not empty")
    @Size(max = 50 , min = 4)
    private String fullName ;

    @Min(value = 20,message = "l'age doit etre sup a 20 ans")
    @Max(value = 62,message = "l'age doit etre inf a 62 ans")
    private Integer age ;

    @Email(message = "l'email doit etre dans la format adéquate")
    private String email ;

    public static EmployeeDTO fromEntity(Employee employee){
        return EmployeeDTO.builder()
                .id(employee.getId())
                .age(employee.getAge())
                .email(employee.getEmail())
                .fullName(employee.getFullName())
                .build();
    }
    public static Employee toEntity(EmployeeDTO dto){
        return Employee.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .build();
    }
}
