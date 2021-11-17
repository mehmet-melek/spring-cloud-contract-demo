package org.melek.producerwarehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/productReservation", produces="application/json")
public class WarehouseController {

    @GetMapping
    public ResponseEntity<String> reservation(@RequestParam(name = "product") String product,
                                              @RequestParam(name = "quantity") Integer quantity) {

        Stock stock = new Stock("ABC", 20);

        if (product.equals(stock.getProduct())) {
            return quantity <= stock.getQuantity() ?
                    new ResponseEntity<>("Products are reserved.", HttpStatus.OK) :
                    new ResponseEntity<>("Not enough products were found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }
}

@Getter
@AllArgsConstructor
class Stock {
    private String product;
    private int quantity;
}