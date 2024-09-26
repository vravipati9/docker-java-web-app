FROM openjdk:17
MAINTAINER Veera R
RUN mkdir code; \
    cd code; \
    echo "openjdk pulled and created code directory !"
WORKDIR code
COPY ["Hello.java", "."]
ADD myfile.tar.gz .
ADD https://github.com/myfiles/one.war /lib
ENV DB_HOST_URL mydatasource:1234/db
EXPOSE 8080
VOLUME ["/host/dir", "/contianer/dir"]
USER veeraravipati
RUN ["javac" , "Hello.java"]
ENTRYPOINT ["java", "Hello"]
CMD ["Ravipati"]