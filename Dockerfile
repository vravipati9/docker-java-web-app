FROM tomcat:10-jdk11
COPY target/javaweb-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/javaweb.war
EXPOSE 8080
CMD ["catalina.sh", "run"]

