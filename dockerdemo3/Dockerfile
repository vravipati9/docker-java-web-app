FROM openjdk:17
RUN mkdir code; \
    cd code; \
    echo "openjdk pulled and created code directory !"
WORKDIR code
COPY ["Hello.java", "."]
RUN ["javac" , "Hello.java"]
ENTRYPOINT ["java", "Hello"]
#or CMD java Hello DDDD