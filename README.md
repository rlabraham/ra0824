## Richard Abraham Application Project
### Versions
Versions used during project development
- **Java:** 17
- **SpringBoot:** 3.3.2
### Build
1. Run `gradle clean build`
2. Start the application
3. Call the endpoint `[POST] /checkout` defined in `CheckoutController.java`
### External Libraries Used
- [Project Lombok](https://projectlombok.org/) - Used for reducing boilerplate code, logging implementation, and builder implementation.
- [Project Reactor](https://projectreactor.io/) - Used to make the API reactive, improving performance and making call asynchronous.
### Validation
All validation is handled through the `spring-boot-starter-validation` library. Validations are set up via property level annotations on `CheckoutRequest.java`. Violating the validations will throw a `MethodArgumentNotValidException` which is handled by `CheckoutController.handleValidationExceptions`
### Test Case Validation
From the design document:
- **Test Case #1:** This is an invalid request (discount percent > 100%). This scenario is validated in `CheckoutControllerIntegrationTest.java`
- **Test Case #2 - 6:** These are valid requests. These scenarios are each validated individually in `RentalAgreementMapperUnitTest.java`
### Resources
Inside `src/main/resources` there is a folder called `samples`. This folder contains a [PostMan](https://www.postman.com/) collection that can be imported and used to run the API. It also contains JSON files that each correspond to one of the test cases specified in the design doc.
### Scaling Up
This is a smale scale sample project that is *not* meant to be an enterprise grade application. Instead, it is meant to meet the requirements as specified in the design doc while showing off some of my capabilities as a developer. In order to scale up to a full scale, enterprise grade application several more things, would need to happen.
- Data would need to be moved out of the enums in the `org.example.ra0824.model.data` and into a database of some sort. Code would need to be written to query from this database.
   - A way to save rental agreement history would need to be implemented.
- Logging and error handling would need to be expanded upon.
- Authentication and authorization would need to be implemented
- Additional API endpoints would need to be implemented.
- Various CI/CD integrations would need to be implemented.
- Additional changes may be needed to become compliant with security and performance policies, company code standards and any applicable laws or regulations.
