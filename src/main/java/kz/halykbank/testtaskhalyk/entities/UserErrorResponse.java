package kz.halykbank.testtaskhalyk.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
