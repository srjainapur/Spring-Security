Mongo DB Insert Script
db.user.insert({"id":"2", "email":"sjainapur@gmail.com", "password":"$2a$10$BKm2FpzAbfw.qf7GKITd9ODNPHuwpAz9XjdCixfMl4hCg6yLMvOya", "name":"Satish", "lastName":"Jainapur", "active":1, "isLoacked":true, "isExpired":false, "isEnabled":true, "role":[{"id":"1", "role":"USER"},{"id":"2", "role":"ADMIN"}]})

db.role.insert({"id":1, "role":"USER"})
db.role.insert({"id":1, "role":"ADMIN"})

db.user.insert({"id":"satish", "email":"sjainapur@gmail.com", "password":"$2a$10$BKm2FpzAbfw.qf7GKITd9ODNPHuwpAz9XjdCixfMl4hCg6yLMvOya", "name":"Satish", "lastName":"Jainapur", "active":1, "isLoacked":true, "isExpired":false, "isEnabled":true, "role_ids":[ObjectId("5c8f9488d3699f4c8dcbf6b1"),ObjectId("5c8f948fd3699f4c8dcbf6b2")]})

db.user.insert({"id":"sjainapur", "email":"sjainapur@zensar.com", "password":"$2a$10$BKm2FpzAbfw.qf7GKITd9ODNPHuwpAz9XjdCixfMl4hCg6yLMvOya", "name":"Satish", "lastName":"Jainapur", "active":1, "isLoacked":false, "isExpired":false, "isEnabled":true, "role":[{"id":1, "role":"USER"},{"id":2, "role":"ADMIN"}]})

--Encoded Value
--password = $2a$10$BKm2FpzAbfw.qf7GKITd9ODNPHuwpAz9XjdCixfMl4hCg6yLMvOya
========================================================================================================================


1. To Loggin to the Application
METHOD		POST 
URL			http://localhost:8090/api/signin
BODY		{
				"username":"sjainapur@zensar.com",
				"password":"test"
			}
			
2. To Loggout of the application
METHOD		POST
URL			http://localhost:8090/api/signout
HEADER		KEY = Authorization
			VALUE = ACCESS TOKEN RECEIVED AFTER LOGIN
			
3. TO HIT Account Microservice
METHOD		GET
URL			http://localhost:8090/api/cart/v1/cart/123
HEADER		KEY = Authorization
			VALUE = ACCESS TOKEN RECEIVED AFTER LOGIN
			
4. To Create Employee CRUD 
METHOD		POST
URL			http://localhost:8090/api/emp/employee
HEADER		VALUE = ACCESS TOKEN RECEIVED AFTER LOGIN
PAYLOAD		{
				"empId":55501,
				"firstName":"LAXMI",
				"lastName":"SARKAR",
				"email":"laxmi@zensar.com"
			}
			
5. To GET all employee
METHOD		GET
URL			http://localhost:8090/api/emp/allEmployee
HEADER		VALUE = ACCESS TOKEN RECEIVED AFTER LOGIN


