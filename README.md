# creditcards

1 - initialize eureka (microservice register)
2 - initialize ms's
3 - initialize gateway 

## imagens docker  

RABBITMQ  
docker run -it --rm --name rabbitmqcredito -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management  

KEYCLOACK  
docker run -p 8081:8080 --name keycloakcredito -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.3 start-dev  

docker network credito-network

rodar todas as imagens com a --network credito-network
imagens com variáveis de ambiente 
docker run -e VARIAVEL_AMBIENTE=valor