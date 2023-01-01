# Airlines Ticket Microservice

Airlines ticket microservice application was developed with JAVA and Spring Boot. It communicates to other services using GRPC and RabbitMQ. There are three different service which are used in this application:

> - <a href= "https://github.com/BeratYesbek/Airlines-Discount-Microservice">Discount Service</a>
> - <a href="https://github.com/BeratYesbek/Airlines-Checking-Microservice">Checking Service</a>
> - <a href="https://github.com/BeratYesbek/Airlines-Notification-Microservice">Notfiy service</a>
</br>
</br>

Service using POSTGRESQL as a database. 
</br>
</br>

This service provide list tickets and sell tickets. Whenever someone is enforming to buy ticket, the following steps take place respectively
> - if someone has discount code service will trigger <a href= "https://github.com/BeratYesbek/Airlines-Discount-Microservice">Discount Service</a> to get discount.
> - If everything is success Ticket Service will trigger <a href="https://github.com/BeratYesbek/Airlines-Checking-Microservice">Checking Service</a> to pass ticket data using GRPC
> - last step service will trigger <a href="https://github.com/BeratYesbek/Airlines-Notification-Microservice">Notfiy service</a> to send email to user using RabbitMQ

##### <a href="https://documenter.getpostman.com/view/16401804/2s8Z6zyrZe">POSTMAN DOCUMANTATION</a>

### Entity Diagram
<img src= "https://user-images.githubusercontent.com/77804034/210167129-9bc14dd0-ae4f-4fbf-b374-ee17921bfbd2.png"/>

### Service Diagram
<img src= "https://user-images.githubusercontent.com/77804034/210167148-06b47da3-17b2-410c-88ee-ea0e6b7a0158.png"/>
