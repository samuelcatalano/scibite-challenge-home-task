package co.uk.scibite.challenge.fizzbuzz.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Samuel Catalano
 * @since 23 March, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzz implements Serializable {

    private List<String[]> lines;
}