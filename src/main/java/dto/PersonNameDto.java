package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class PersonNameDto implements Serializable {

    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String first;
    @Getter
    @Setter
    private String last;
}
