package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiMessage {
    @JsonIgnore
    private int responseCode;
    private String message;
    @JsonIgnore
    private Date responseTimestamp;

    public ApiMessage (String message) {
        this.message = message;
    }
}
