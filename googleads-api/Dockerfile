FROM gradle:7.5.1-jdk17-focal AS build
COPY --chown=gradle:gradle . /work
WORKDIR /work
RUN --mount=type=cache,sharing=locked,target=/root/.gradle gradle :googleads-api:clean :googleads-api:build --no-daemon -x test --parallel

FROM openjdk:17
COPY --from=build /work/googleads-api/build/libs/googleads-api-0.0.1.jar app.jar

RUN mkdir -p /home/newrelic
ADD ./thirdparty/newrelic/newrelic.jar /home/newrelic/newrelic.jar
ENV NRIA_LICENSE_KEY="not-set"
ENV ENVIRONMENT="not-set"

ENTRYPOINT java -Dnewrelic.config.app_name='googleads-api' -Dnewrelic.config.license_key=${NRIA_LICENSE_KEY} -Dnewrelic.environment=${ENVIRONMENT} -Dnewrelic.config.log_file_name=STDOUT -javaagent:/home/newrelic/newrelic.jar -jar /app.jar
