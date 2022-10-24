# microservices-labs

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