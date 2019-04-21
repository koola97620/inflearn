package me.jdragon.currencycalculator.controller;

import java.net.URI;
import me.jdragon.currencycalculator.domain.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author choijaeyong on 19/04/2019.
 * @project currencycalculator
 * @description
 * http://apilayer.net/api/live?access_key=d7bba865db7d2615876ecb82f2b124f8&currencies=KRW,PHP,JPY
 */

@RestController
public class CurrencyController {

  @GetMapping("/api")
  public String getCurrencyData() {
    // 역할분리는 나중에. 일단 기능테스트좀.

    URI uri = UriComponentsBuilder.fromHttpUrl("http://apilayer.net/api/live")
        .queryParam("access_key", "d7bba865db7d2615876ecb82f2b124f8")
        .queryParam("currencies","KRW,PHP,JPY,AUD")
//        .queryParam("format" , "1")
        .build().toUri();

    RestTemplate restTemplate = new RestTemplate();
    String responseString = restTemplate.getForObject(uri,String.class);

    Response response = restTemplate.getForObject(uri, Response.class);
    System.out.println(response.getQuotes().size());
    System.out.println(response.getQuotes());

    Float usdaud = response.getQuotes().get("USDAUD");
    Float usdkrw = response.getQuotes().get("USDKRW");

    Float audkrw = usdkrw/usdaud;

    System.out.println(audkrw);




    return responseString;
  }

}
