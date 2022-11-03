# microservices-labs

## Who made services
Команда №0
1. Auth service - Pashkovskiy Eugene IP-01
2. Movie-Manage Service - Moskalenko Vladislav IP-01
3. Booking Service - Omelian Dmytro IP-02
4. Email Service - Bogdan Zaranik IP-01

## Main pipeline
# Run scripts:

k apply -f ./email/secrets&k apply -f ./email/db&k apply -f ./email

k apply -f ./auth/secrets&k apply -f ./auth/db&k apply -f ./auth

k apply -f ./client

k apply -f ./movie-management-service/secrets&k apply -f ./movie-management-service/db&k apply -f ./movie-management-service

# Delete scripts:

k delete -f ./auth/secrets&k delete -f ./auth/db&k delete -f ./auth

k delete -f ./email/secrets&k delete -f ./email/db&k delete -f ./email

k delete -f ./client

k delete -f ./movie-management-service/secrets&k delete -f ./movie-management-service/db&k delete -f ./movie-management-service

Now auth and email service work nice together.
Movie-management-service also works good.
React js client demo also should be available at http://localhost/
Booking service crud is ready, but config issues take place.

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

3. You may login and get token
    POST http://localhost/api/auth/login
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }

4. Email Service works internally (even does not have ingress. it is not needded
hence is used only by auth service).

5. You may get all movies(also by id)
    GET http://localhost/api/auth/movies

6. You may get all cinames(also by id)
    GET http://localhost/api/auth/movies

7. You may get all feedbacks of movie in certain cinema
    GET http://localhost/api/cinemas/1/feedbacks

8. You may get all feedbacks of movie
    GET http://localhost/api/movies/1/feedbacks

Also all POST/DELETE methods of movie-management service work.

9. You may see client demo on 
    GET http://localhost/
