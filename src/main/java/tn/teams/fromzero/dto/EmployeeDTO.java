package tn.teams.fromzero.dto;

import lombok.*;

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

    @Email(message = "l'émail doit etre dans la format adéquate")
    private String email ;
}
