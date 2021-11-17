import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("When product is not exist, should return product not found message")
    request {
        method GET()
        url("/productReservation") {
            queryParameters {
                parameter('product', 'InvalidProduct')
                parameter('quantity', 20)
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body("Product not found!")
        status(404)
        headers {
            contentType(applicationJson())
        }
    }
}