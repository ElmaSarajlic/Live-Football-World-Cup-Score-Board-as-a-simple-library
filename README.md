# Live-Football-World-Cup-Score-Board-Library

## Description
This library provides a simple in-memory solution to track and display scores for ongoing football matches. The library allows starting new match, updating scores, finishing match, and retrieving a summary of all ongoing matches.

## Features
- **Start a New Match**: Initialize matches with a score of 0 – 0.
- **Update Score**: Modify scores for ongoing matches.
- **Finish Match**: Remove a match from the scoreboard.
- **Get Summary**: Retrieve a list of ongoing matches sorted by total score.

### Prerequisites
- Java 11 or newer
- Maven (for building the project and running tests)

### Core Dependencies

- **JUnit Jupiter (v5.9.2)**: Used for unit testing. This ensures that all functionalities are tested.
- **Lombok (v1.18.30)**: Simplifies the codebase by reducing boilerplate code such as getters, setters, and constructors through annotations. This dependency is optional and provided at compile time.
- **SLF4J (v2.0.7) and Logback (v1.4.7)**: Provides a logging framework to help with debugging and tracking the application's behavior in production.

### Installation
1. Clone the repository:
   git clone https://github.com/ElmaSarajlic/Live-Football-World-Cup-Score-Board-as-a-simple-library.git
   
2. Build the project:
   mvn clean install