# String expression Integer Calculator

This is an Java Spring Boot application, that can also serve as it's own library.

## Assumptions
* Provided numbers are Integer
  * Anything other (Floats, Doubles, others) throws error
* Result is also an Integer
* The expression must be a space separated string
* Supported operations are `+, -, *, /`
* Negative numbers are supported, as long as the sign is next to the number
  * Example `-2`
  * It also works for leading `+` sign
  * Weird unicode signs for both are changed to proper `-` or `+`
* If no input is provided, we assume `0` as result
* The expression must start and end with a number, in order to be calculated

## Additional information
More technical information can be found in _JavaDocs_ of [this file](src/main/java/pl/domi/calculatortask/app/StringExpressionCalculator.java).