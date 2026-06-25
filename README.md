# E2E Java Selenium Framework

TestNG + Selenium framework for the SauceDemo login, cart, and checkout flows.

## Requirements

- Java 17+
- Maven 3.9+
- Chrome, Firefox, or Edge

## Design

- All XPath locators are stored in `src/test/java/elements/PageElements.java`.
- Page Object classes turn those locators into business actions.
- Test classes call Page Object methods only; they contain no XPath and no direct `findElement` calls.
- Browser, environment, timeout, and retry settings are read from `config.properties` and may be overridden with JVM properties.
- User test data is loaded from JSON.
- Failed tests create screenshots under `reports/screenshots`.

## Run

```bash
mvn clean test
mvn clean test -Dbrowser=chrome -Dheadless=true -Denv=qa
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

Supported environments are `dev`, `qa`, and `staging`.

## Reports

- TestNG/Surefire report: `target/surefire-reports`
- Failure screenshots: `reports/screenshots`
- Execution log: `reports/test.log`

Do not commit real passwords or tokens. For production projects, inject secrets from CI rather than storing them in test resources.
