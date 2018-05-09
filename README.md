# hello-spring-boot
Demo project for Spring Boot

* `POST` Add a new employee

http://localhost:8080/v1/employees
```json


{
    "name": "Alan",
    "id": null,
    "gender": "M",
    "phone": "0987654321",
    "address": "101F., No.7, Sec. 5, Xinyi Rd., Xinyi Dist., Taipei City 110, Taiwan (R.O.C.)",
    "age": 32
}
```

* `PUT` Update a employee with the given id

http://localhost:8080/v1/employees/1
```json
{
    "name": "Alice",
    "id": 1,
    "gender": "F",
    "phone": "0912345678",
    "address": "101F., No.7, Sec. 5, Xinyi Rd., Xinyi Dist., Taipei City 110, Taiwan (R.O.C.)",
    "age": 23
}
```

* `DELETE` Delete a employee with the given id

http://localhost:8080/v1/employees/1

* `GET` Find employees with the given name or id

http://localhost:8080/v1/employees?name=Alan&id=1

* `GET` Find all employees in pages

http://localhost:8080/v1/employees/page/1
