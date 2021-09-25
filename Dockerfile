FROM openjdk:11

ARG PROFILE
ARG ADDITTIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/doctor-management

COPY /target/DoctorManagement-0.0.1-SNAPSHOT*.jar DoctorManagement-0.0.1-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar DoctorManagement-0.0.1-SNAPSHOT.jar --spring.profiles.active=${PROFILE}