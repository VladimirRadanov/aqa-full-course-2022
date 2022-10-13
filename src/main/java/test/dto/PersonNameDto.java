package test.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @Override
  public String toString() {
    return String.format("[%s, %s, %s]", title, first, last);
  }
}
