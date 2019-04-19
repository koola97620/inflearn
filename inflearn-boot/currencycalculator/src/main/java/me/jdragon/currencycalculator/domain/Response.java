package me.jdragon.currencycalculator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author choijaeyong on 19/04/2019.
 * @project currencycalculator
 * @description
 */
@Getter
@Setter
public class Response {

  @JsonProperty("quotes")
  private Map<String, Float> quotes ;
  public Response() {
    quotes = new HashMap<>();
  }

}
