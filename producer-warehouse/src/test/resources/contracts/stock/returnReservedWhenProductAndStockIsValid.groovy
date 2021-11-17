import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("When product and stock is valid, should return product reserved message")
    request {
        method GET()
        url("/productReservation") {
            queryParameters {
                parameter('product', 'ABC')
                parameter('quantity', 20)
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body("Products are reserved.")
        status(200)
        headers {
            contentType(applicationJson())
        }
    }
}