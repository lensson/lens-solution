FROM lensson/8-jdk-alpine:latest
MAINTAINER lensson.zhen@gmail.com

WORKDIR /
ADD . .

RUN pwd
RUN ls -al

ENV MAVEN_VERSION=3.6.3

WORKDIR /usr/local/maven

RUN tar -zxvf apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    rm -fr apache-maven-${MAVEN_VERSION}-bin.tar.gz

#对外暴漏的端口号
EXPOSE 9000

WORKDIR /

RUN mkdir -p /root/.m2/
COPY settings.xml /
RUN ls -al
RUN cp ./settings.xml /root/.m2/
RUN /usr/local/maven/apache-maven-${MAVEN_VERSION}/bin/mvn clean package

#将本地项目jar包拷贝到Docker容器中的位置
RUN cp ./target/plumemo-v1.2.0.jar ./

RUN rm -rf target
RUN rm -rf repository
RUN rm -rf pom.xml
RUN rm -rf Dockerfile

#加入时区
RUN apk add --no-cache tzdata
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

#开机启动
ENTRYPOINT ["java","-jar","/plumemo-v1.2.0.jar"]
