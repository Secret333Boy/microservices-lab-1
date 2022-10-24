# microservices-labs

Run scripts:

k apply -f ./auth/secrets
k apply -f ./auth/db
k apply -f ./auth

k apply -f ./email/secrets
k apply -f ./email/db
k apply -f ./email

k apply -f ./client

k apply -f ./booking/postgres
k apply -f ./booking

k apply -f ./movie-management-service/secrets
k apply -f ./movie-management-service/db
k apply -f ./movie-management-service

Now auth and email service work nice together.
Other services also work, but they are on the dev stage and might be issues with them.

Testing.
After starting the app:
1) Register in system
    POST http://localhost/api/auth/register
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }

2) Go to your email account and follow the link. You will see nothing, but on backend 
your account will be verified.

3) You may login
    POST http://localhost/api/auth/login
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }
