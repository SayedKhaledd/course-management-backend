FROM openjdk:21-bullseye AS build
ENV MAVEN_VERSION=3.9.8
ENV MAVEN_HOME=/usr/lib/mvn
ENV PATH=$MAVEN_HOME/bin:$PATH
RUN apt update && apt install wget -y
RUN wget http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
tar -zxvf apache-maven-$MAVEN_VERSION-bin.tar.gz && \
rm apache-maven-$MAVEN_VERSION-bin.tar.gz && \
mv apache-maven-$MAVEN_VERSION /usr/lib/mvn
RUN mvn --version
WORKDIR /workspace/app
COPY backend-core-service/pom.xml backend-core-service/pom.xml
COPY keycloak-backend-client/pom.xml keycloak-backend-client/pom.xml
COPY course-management-app/pom.xml  course-management-app/pom.xml
COPY course-management-app/pom.xml .
COPY backend-core-service/src backend-core-service/src
COPY keycloak-backend-client/src keycloak-backend-client/src
COPY  course-management-app/src  course-management-app/src
  #RUN mvn -q dependency:purge-local-repository -DactTransitively=false -DreResolve=false --fail-at-end
RUN mvn  -q -f backend-core-service/pom.xml install -DskipTests
RUN mvn  -q -f keycloak-backend-client/pom.xml install -DskipTests
RUN mvn  -q -f  course-management-app/pom.xml install -DskipTests
RUN mkdir -p  course-management-app/target/dependency && (cd  course-management-app/target/dependency; jar -xf ../*.jar)
FROM openjdk:21-bullseye
ARG DEPENDENCY=/workspace/app/course-management-app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
  # COPY --from=frontend-build frontend-app/dist /workspace/app/care-giver-app/target/classes/static
  #ENV JAVA_OPTS="-Xmx2048m -Xms1024g"
EXPOSE 8090
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.coursemanagementapp.CourseManagementAppApplication"]