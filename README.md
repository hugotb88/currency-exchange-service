# currency-exchange-service
Currency Exchange Service, part of the microservices needed for the UDEMY course https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud


# This microservices allows the user to indicate two currencies, a quantity and get the amount in the second currency

URL
http://localhost:8000/currency-exchange/from/USD/to/INR



Response Structure

```
{
    "id":10001,
    "from":"USD",
    "to":"INR",
    "conversionMultiple":65.00,
    "environment":"8000 instance-id"
}
```