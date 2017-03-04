FROM java:8-jre
MAINTAINER Mradul Pandey <pandeymradul@gmail.com>

ADD ./target/demo-cqrs-statistics.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/demo-cqrs-statistics.jar"]

EXPOSE 8082