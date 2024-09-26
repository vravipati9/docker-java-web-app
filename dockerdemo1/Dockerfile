FROM openjdk:17
RUN mkdir code; \
    cd code; \
    echo "openjdk pulled and created code directory !"
WORKDIR code
COPY Hello.java .
RUN javac Hello.java
CMD java Hello "Success" && sh

#docker run --rm  --name mysql-container1 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=myDB -p 3306:3306 mysql:latest
#docker exec mysql-container1 -uroot -ppassword