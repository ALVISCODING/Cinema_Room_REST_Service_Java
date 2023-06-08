


# Cinema_Room_REST_Service_Java 

This project is a Java Spring Boot application that implements a RESTful API for a small cinema ticket booking system. The system allows users to purchase, cancel, and refund tickets. The system also generates statistics of current sale income and available seats.






## Features

 Ticketing System

This is a ticketing system that allows users to purchase, cancel, and refund tickets.



   * Unique token generation: When a client purchases a ticket, a unique token is generated and associated with the ticket. This token can be used to cancel or refund the ticket.

   * Ticket cancellation and refund: A client can cancel or refund a ticket by providing the unique token associated with the ticket. If the token is valid, the ticket will be canceled or refunded.

   * System statistics: The system can generate statistics of current sale income and available seats. These statistics can be used to track the performance of the ticketing system and to make decisions about future events.

   * Error handling: If a ticket is purchased or a set number of requests exceeds the layout plan, or if the return token is wrong, an error will be generated. This error will be displayed to the user and will prevent the transaction from being completed.

   





## Run Locally


There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the cinema/Main.java class from your IDE.

My src file is on  Cinema Room REST Service (Java)/task/src/cinema

Start the system

```bash
  gradle bootRun
```




## Tech Stack

**Client:** Postman API Platform

**Server:** Java, Spring Boot


## Local Host

Please configure your local host setting 

```bash
 server.port=28852
```
## Usage/Examples

These are few examples of how the program operate!

```PostMan
Client purchase request:

POST /purchase HTTP/1.1
Cookie: JSESSIONID=25B8D5ED676F66E95D82EF78AF70DC29
Content-Type: application/json
Host: localhost:28852
Content-Length: 30

{
	 "row": 1,
   "column": 1
}


Backend reply :

{
	"token": "892a6d68-4285-492f-b5ac-707f55ca9219",
	"seat": {
		"row": 1,
		"column": 1,
		"price": 10
	}
}

```

```
Client return ticket request

POST /return HTTP/1.1
Cookie: JSESSIONID=25B8D5ED676F66E95D82EF78AF70DC29
Content-Type: application/json
Host: localhost:28852
Content-Length: 58

{
	"token": "892a6d68-4285-492f-b5ac-707f55ca9219"

}


Backend reply:
{
	"returned_ticket": {
		"price": 10,
		"column": 1,
		"row": 1
	}
}


```
```
if token is wrong 

Backend reply:

{"timestamp":"2023-06-08T00:38:34.839854700","status":400,"error":"Wrong token!","message":"400 BAD_REQUEST \"Wrong token!\""}

```

```
If client post a request exceed the max seating layout 

Backend reply:

{
	"timestamp": "2023-06-08T00:39:54.464943200",
	"status": 400,
	"error": "The number of a row or a column is out of bounds!",
	"message": "400 BAD_REQUEST \"The number of a row or a column is out of bounds!\""
}

```

```
To access the statistic 
super_secret is the password in json request 

POST /stats HTTP/1.1
Cookie: JSESSIONID=25B8D5ED676F66E95D82EF78AF70DC29
Content-Type: application/json
Host: localhost:28852
Content-Length: 31

{
	"password": "super_secret"
}
```




## Authors

- [@ALVISCODING](https://www.github.com/ALVISCODING)

