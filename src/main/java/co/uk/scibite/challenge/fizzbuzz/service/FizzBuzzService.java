package co.uk.scibite.challenge.fizzbuzz.service;

import co.uk.scibite.challenge.fizzbuzz.json.FizzBuzz;
import org.springframework.stereotype.Service;
import java.util.stream.IntStream;

/**
 * @author Samuel Catalano
 * @since 23 March, 2020
 */

@Service
public class FizzBuzzService {

    /**
     * Validates a fizz buzz file.
     * @param fizzBuzz the class that contais the lines to validate
     * @return <code>true</code> or <code>false</code>
     */
    public boolean validatesFizzBuzzFile(final FizzBuzz fizzBuzz) {
        boolean isValid = true;

        for (int j = 0; j < fizzBuzz.getLines().size(); j++) {
            StringBuilder sb = new StringBuilder();
            String[] lines = fizzBuzz.getLines().get(j);

            IntStream.rangeClosed(1, lines.length).forEach(i -> {
                if (i % 15 == 0) { // 15 is LCM(3,5)
                    sb.append(",FIZZBUZZ");
                } else if (i % 3 == 0) {
                    sb.append(",FIZZ");
                } else if (i % 5 == 0) {
                    sb.append(",BUZZ");
                } else {
                    sb.append("," + i);
                }
            });

            final String result = sb.toString().substring(1); // remove the first ","
            final String joined = String.join(",", lines);

            if (!joined.equals(result)) {
                isValid = false;
                break;
            };
        }
        return isValid;
    }
}