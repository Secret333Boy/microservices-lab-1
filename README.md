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

k apply -f ./movie-management/secrets&k apply -f ./movie-management/db&k apply -f ./movie-management

k apply -f ./booking/secrets&k apply -f ./booking/db&k apply -f ./booking

# Delete scripts:

k delete -f ./auth/secrets&k delete -f ./auth/db&k delete -f ./auth

k delete -f ./email/secrets&k delete -f ./email/db&k delete -f ./email

k delete -f ./client

k delete -f ./movie-management/secrets&k delete -f ./movie-management/db&k delete -f ./movie-management

k delete -f ./booking/secrets&k delete -f ./booking/db&k delete -f ./booking

Now auth and email service work nice together.
Movie-management-service also works good.
React js client demo also should be available at http://localhost/
Booking service crud is ready, but config issues take place.

## Testing
After starting the app:

1. GET http://localhost/api/auth/validate without auth header =>  401 status,
which is expectable. No auth token provided.

2. Register in system and get token
    POST http://localhost/api/auth/register
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }
3. GET http://localhost/api/auth/validate WITH auth header =>  401 status,
user is not activated yet. Go to your mail account for activation link.

Header: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Ijk4M2I3Yzk3LTVlM2YtNGYyNC1iMTUxLWJkNDZlYWRkYjY0MSIsImVtYWlsIjoiemFyYW5pa2J6QGdtYWlsLmNvbSIsImhhc2giOiIkMmIkMTAkb2t3eldTRTgya2U3WThIMi51QXV1dS5nbnBkeTBwOHY5MHZtQWZwajNoN0p3eHZwZFA0b1MiLCJpYXQiOjE2Njc1NDc5NDAsImV4cCI6MTY2NzU0OTc0MH0.ihYkQ04ny02paWIeiGlUjFmbilnUf1yoxf_xb7GqDNk

4. Click on link in mail account => see nothing(will be some message soon), but account is activated. Retry step and get status code 200 OK.



5. Go to your email account and follow the link. You will see nothing, but on backend 
your account will be verified.

6. You may login and get token
    POST http://localhost/api/auth/login
    {
        "email" : "your-email",
        "password": "Ab#432143215"
    }

4. Email Service works internally (even does not have ingress. it is not needded
hence is used now by auth service).

5. You may get all movies(also by id)
    GET http://localhost/api/movie-management/movies

6. You may get all cinames(also by id)
    GET http://localhost/api/movie-management/cinemas

7. You may get all feedbacks of movie in certain cinema
    GET http://localhost/api/movie-management/cinemas/1/feedbacks

8. You may get all feedbacks of movie
    GET http://localhost/api/movie-management/movies/1/feedbacks

Also all POST/DELETE methods of movie-management service work.

9. You may see client demo on 
    GET http://localhost/
