FROM java:8-jre
MAINTAINER Mradul Pandey <pandeymradul@gmail.com>

ADD ./target/demo-cqrs-complaints.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/demo-cqrs-complaints.jar"]

EXPOSE 8081