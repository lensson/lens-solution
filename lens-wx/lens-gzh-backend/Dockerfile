FROM openjdk:8-jdk-alpine
MAINTAINER lensson.zhen@gmail.com
ARG JAR_FILE
# jar/opt
COPY ${JAR_FILE} /opt/app.jar
# /data
ENV DATAPATH /data
# /data
VOLUME $DATAPATH
# ADD fontconfig to resolve can't get captcha image bug
ENV LANG en_GB.UTF-8
RUN apk --update add ttf-dejavu && rm -rf /var/cache/k/*
#
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
EXPOSE 9031