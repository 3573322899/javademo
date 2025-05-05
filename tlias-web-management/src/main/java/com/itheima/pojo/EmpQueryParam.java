package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam{
   Integer page=1;
   Integer pageSize=10;
   String name;
   Integer gender;
   @DateTimeFormat(pattern="yyyy-MM-dd")
   LocalDate begin;
   @DateTimeFormat(pattern="yyyy-MM-dd")
   LocalDate end;

}
