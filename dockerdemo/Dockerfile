FROM alpine
RUN mkdir code; \
    cd code; \
    echo "Hello" > hello.txt
WORKDIR code
COPY Hello.java .
RUN touch hello-world1.txt
CMD echo "!!!!! Welcome to alp:ine container !!!!!!" && sh
