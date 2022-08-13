package kz.halykbank.testtaskhalyk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int personnelNumber;

    @NotBlank(message = "Full name should be defined")
    @Size(max = 150, message = "Full name must not be longer than 150 characters")
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Size(max = 50, message = "The length of the role must not exceed 50 characters")
    private String role;
}
