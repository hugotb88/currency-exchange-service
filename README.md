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

#Load balancer
![img.png](img.png)

Running an instance over port 8001
![img_2.png](img_2.png)


#H2 DB Configurations and Console
spring.jpa.show = true
spring.datasource.url = jdbc:h2:mem:testdb
spring.h2.console.enabled = true
spring.jpa.defer-datasource-initialization = true  //Indicates that the application should look for a data.sql file after the schema.sql after the Schema creation 

url --> localhost:8000/h2-console
![img_1.png](img_1.png)

