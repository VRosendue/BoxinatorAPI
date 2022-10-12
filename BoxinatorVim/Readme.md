BEFORE STARTING ENDPOINTS:
```diff
1. go to application.properties and change name of database spring.datasource.url= jdbc:postgresql://localhost:5432/{boxinatorWork}
      - change username and password to the one corresponding in pgAdmin/postgreSQL
2. go to resources folder and execute all startup.sql files
3. For postman, all endpoints starts with http://localhost:8084/api/v1/{PLACEHOLDER} then change to shipments, countries or users.
