import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description("if parameter contains 'say my name' return Heisenberg")
    request {
        method GET()
        url("/whoTheHellAreYou") {
            queryParameters {
                parameter("youKnow", "some-dummy-words")
            }
        }
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body("Who the hell are you!")
        status(200)
        headers {
            contentType(applicationJson())
        }
    }
}

