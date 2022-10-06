package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

  @Getter
  @Setter
  private String gender;
  @Getter
  @Setter
  private String nat;
  @Getter
  @Setter
  private PersonNameDto name;

  @Override
  public String toString() {
    return String.format("[%s, %s, %s]", gender, nat, name.toString());
  }
}
