import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("if parameter contains 'say my name' return Heisenberg")
    request {
        method GET()
        url("/whoTheHellAreYou") {
            queryParameters {
                parameter('youKnow', 'say-my-name')
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body("Heisenberg")
        status(200)
        headers {
            contentType(applicationJson())
        }
    }
}

