## Maven build of the project done in Stage 1
FROM maven:latest as builder
#COPY . /tmp/Context/.
COPY . /opt/.
RUN curl https://download.java.net/java/early_access/jdk14/33/GPL/openjdk-14-ea+33_linux-x64_bin.tar.gz -o /opt/openjdk-14-ea+33_linux-x64_bin.tar.gz
RUN mvn -f /opt/pom.xml clean package

## Setup the jre version with all modules done in Stage 2
FROM bhatnagarm/linux_trifle as packer
#COPY --from=builder . /tmp/Context/.
COPY --from=builder ["/opt/openjdk-14-ea+33_linux-x64_bin.tar.gz","/opt/target/cloud-native-micro-service.jar", "/opt/"]
# Build our own jdk12 distro with only these modules, as first stage /opt/openjdk-12_linux-x64_bin.tar.gz
RUN tar -C /opt -zxf /opt/openjdk-14-ea+33_linux-x64_bin.tar.gz
RUN	/opt/jdk-14/bin/jlink \
    --module-path /opt/jdk-14/jmods \
    --verbose \
    --add-modules java.base,java.logging,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --compress 2 \
    --no-header-files \
    --output /opt/jdk-12-minimal

## Create the final minimalist build image which will be used in production
FROM bhatnagarm/linux_trifle
COPY --from=packer /opt/jdk-14-minimal /opt/jdk-14-minimal
#COPY --from=builder . /tmp/Context/.
COPY --from=packer /opt/cloud-native-micro-service.jar /opt/
ENV JAVA_HOME=/opt/jdk-12-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"

EXPOSE 8080
CMD ["java","-jar","/opt/cloud-native-micro-service.jar"]