package dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ResultsDto {

  @Getter
  @Setter
  private List<PersonDto> results;

  @Override
  public String toString() {
    return results.stream()
        .map(Object::toString)
        .collect(Collectors.joining(","));
  }
}
