
- The application has an entry point to call the calculation over HTTP. 

- The method type is preferred as Post method to run a query on inmemory db and to eliminate the url size limit

- Vehicle abstract class is converted to db table to store different types of vehicles and their "tax exempt" state.

- Microservice architecture best practices are used to rebuild the project architecture.

- Database tables are built to allow for the creation of reusable and configurable objects.

- Test scenarios are added

- CongextionTax... classes are added to improve the project solution to support different cities and different tax rules.

- As an improvement, the tax rules(CongestionTax entity) for the specified city can be stored in a db table that can be accessed

- Tax rules may be stored as a json object and entities could be created according to these json type data, so the tax rules structure could be generic