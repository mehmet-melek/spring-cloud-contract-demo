import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("When stock is not enough should return stock error message")
    request {
        method GET()
        url("/productReservation") {
            queryParameters {
                parameter('product', 'ABC')
                parameter('quantity', 50)
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body("Not enough products were found!")
        status(404)
        headers {
            contentType(applicationJson())
        }
    }
}