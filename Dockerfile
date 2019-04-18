FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV TZ=Asia/Shanghai
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories
RUN apk update && apk add -U tzdata
RUN cp /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ >/etc/timezone
RUN apk del tzdata
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
EXPOSE 8091
#-Duser.timezone=GMT+8修改时区
#  spring.jackson=time-zone: GMT+8
ENTRYPOINT ["java","-Xmx512m", "-Duser.timezone=GMT+8","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
