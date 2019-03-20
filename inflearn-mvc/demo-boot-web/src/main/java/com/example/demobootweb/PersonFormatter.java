//package com.example.demobootweb;
//
//import java.text.ParseException;
//import java.util.Locale;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
///**
// * @author choijaeyong on 19/03/2019.
// * @project demo-boot-web
// * @description
// * @Component를 입력해서 빈으로 만들면. WebConfig에 add 해줄 필요없다. 부트가 알아서 추가해준다.
// */
//
//@Component
//public class PersonFormatter implements Formatter<Person> {
//
//  @Override
//  public Person parse(String s, Locale locale) throws ParseException {
//    // parse() 는 문자열을 읽어서 객체로 바꿔준다.
//    Person person = new Person();
//    person.setName(s);
//    return person;
//  }
//
//  @Override
//  public String print(Person person, Locale locale) {
//    return person.toString();
//  }
//}

// spring-data-jpa 를 사용하면 포매터가 필요 없다.