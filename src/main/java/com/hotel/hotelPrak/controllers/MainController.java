package com.hotel.hotelPrak.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public  String home(Model model){
        model.addAttribute("name","Гранд Отель");
        return "homeMain";
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model){
        double result = switch (operator){
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default ->  0.0;
        };
        model.addAttribute("result", result);
        return "result";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("name_currency") String nameCurrency,
                          @RequestParam("input_currency") double inputCurrency,
                          @RequestParam("second_name_Currency") String SecondNameCurrency,
                          Model model){
        double resultCurr = switch (nameCurrency){
            case "RUB" -> switch (SecondNameCurrency){
                case "USD" -> inputCurrency * 0.01;
                case "EURO" -> inputCurrency * 0.009;
                default -> 0.0;
            };
            case "USD" -> switch (SecondNameCurrency){
                case "RUB" -> inputCurrency * 92.58;
                case "EURO" -> inputCurrency * 0.899;
                default -> 0.0;
            };
            case "EURO" -> switch (SecondNameCurrency){
                case "USD" -> inputCurrency * 1.11;
                case "RUB" -> inputCurrency * 103.38;
                default -> 0.0;
            };
            default -> 0.0;
        };

        model.addAttribute("resultConvert", resultCurr); // вроде передаем html.
        return "resultConvert";
    }

    @GetMapping("/converter")
    public String converter(Model model){
        return "converter";
    }

    @GetMapping("/calculator")
    public  String calculator(Model model){
        return "calculator";
    }

}
