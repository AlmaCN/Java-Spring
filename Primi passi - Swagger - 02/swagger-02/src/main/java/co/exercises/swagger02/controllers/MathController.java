package co.exercises.swagger02.controllers;

import co.exercises.swagger02.entities.ArithmeticOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * Ho poi creato la classe MathController annotata con RestController.
 */
@RestController
@RequestMapping("/math")
public class MathController {

    /**
     * Ho creato un metodo welcomeMathMsg annotato con GetMapping
     * @return ritorna un messaggio di benvenuto nelle Arithmetic Operation
     */
    @GetMapping(value = "")
    @Operation(summary = "Welcome message to the Math API")
    public String welcomeMathMsg(){
        return "Welcome to Arithmetic Operation";
    }

    /**
     * Ho creato un metodo divisionInfo annotato con GetMapging
     * @return ritorna un oggetto di tipo ArithmeticOperation
     */
    @GetMapping(value = "division-info")
    @Operation(summary = "Information about division")
    public ArithmeticOperation divisionInfo(){
        return new ArithmeticOperation("Division", 2,
                "Division is the opposite of multiplication. If 3 groups of 4 make 12 in multiplication, 12 divided into 3 equal groups give 4 in each group in division.",
                new String[]{"Identity Property", "Zero Property", "Dividing a Number by Itself"});
    }

    /**
     * Ho creato un metodo multiplication annotato con GetMapping
     * @param n primo numero
     * @param m secondo numero
     * @return ritornera la moltiplicazione dei due numeri (Es: n * m)
     */
    @GetMapping(value = "multiplication")
    public int multiplication(@ApiParam("Method for multiply two numbers") @RequestParam int n, @RequestParam int m){
        return n * m;
    }

    /**
     * Ho creato un metodo square annotato con GetMapping
     * @param n numero
     * @return il numero dovra essere moltilpicato per se stesso (Es: n * n)
     */
    @GetMapping("/square/{n}")
    public int square(@ApiParam("Method to get the square of a number") @PathVariable int n){
        return n * n;
    }
}
