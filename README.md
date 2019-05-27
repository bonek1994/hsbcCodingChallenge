# hsbcCodingChallenge
Coding challenge for HSBC recruitment

# Run Application
It is Spring Boot appplication - main class is com.example.rest.RestApplication

# Rest Api
## Post 

### On endpoint: /employees 
Accepts JSON form:
{
  "name": "<name>",
  "surname: "<surname>",
  "age": age,
  "grade": grade
}
returns:
Response Status 201
Response Body:
{
  "id": id,
  "name": "<name>",
  "surname: "<surname>",
  "age": age,
  "grade": grade
}

## Get

### On endpoint: /employees/{id}

returns: JSON as above if exist or Http Status Not Found(404) otherwise

### On endpoint /employees

returns: JSON which is list of all employees. 
May be filtered by any combination of properties name, surname, age, grade for example: 
/employees?name=john&surname=wick
/employees
/employees?name=john&surname=wick&age=36&grade=4

## Put

### On endpoint: /employees/{id}
Accepts JSON form:
{
  "name": "<name>",
  "surname: "<surname>",
  "age": age,
  "grade": grade
}

## Delete
### On endpoint: /employees/{id}
