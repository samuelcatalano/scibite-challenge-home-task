package co.uk.scibite.challenge.fizzbuzz.controller;

import co.uk.scibite.challenge.fizzbuzz.json.FizzBuzz;
import co.uk.scibite.challenge.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Samuel Catalano
 * @since 23 March, 2020
 */

@RestController
@RequestMapping(value = "/fizz-buzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @PostMapping(value = "/validate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> validatesFizzBuzzFile(@RequestBody final FizzBuzz fizzBuzz) {
        boolean isValid = this.fizzBuzzService.validatesFizzBuzzFile(fizzBuzz);
        return ResponseEntity.ok(isValid);
    }
}