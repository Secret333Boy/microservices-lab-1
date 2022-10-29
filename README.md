# microservices-labs

## Who made services
Команда №0
1. Auth service - Pashkovskiy Eugene IP-01
2. Movie-Manage Service - Moskalenko Vladislav IP-01
3. Booking Service - Omelyan Dmytro IP-02
4. Email Service - Bogdan Zaranik IP-01

## Main pipeline
# Run scripts:

k apply -f ./email/secrets&k apply -f ./email/db&k apply -f ./email

k apply -f ./auth/secrets&k apply -f ./auth/db&k apply -f ./auth

k apply -f ./client

k apply -f ./booking/postgres
k apply -f ./booking

k apply -f ./movie-management-service/secrets&k apply -f ./movie-management-service/db&k apply -f ./movie-management-service

# Delete scripts:

k delete -f ./auth/secrets&k delete -f ./auth/db&k delete -f ./auth

k delete -f ./email/secrets&k delete -f ./email/db&k delete -f ./email

k delete -f ./client

k delete -f ./movie-management-service/secrets&k delete -f ./movie-management-service/db&k delete -f ./movie-management-service

Now auth and email service work nice together.
Movie-management-service also works good
Other services also work, but they are on the dev stage and might be issues with them.

## Testing
After starting the app:
1. Register in system
    POST http://localhost/api/auth/register
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }

2. Go to your email account and follow the link. You will see nothing, but on backend 
your account will be verified.

3. You may login
    POST http://localhost/api/auth/login
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }

4. Email Service works internally (even does not have ingress. it is not needded
hence is used only by auth service).
