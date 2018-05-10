FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/phptravel-admin-tests.jar /usr/share/tag/phptravel-admin.jar
ADD  target/libs /usr/share/tag/libs
ADD  RegressionSuite.xml /usr/share/tag/RegressionSuite.xml

# Command line to execute the test
ENTRYPOINT /usr/bin/java -cp /usr/share/tag/libs/*:/usr/share/tag/phptravel-admin.jar -Dhub=$HUB_HOST -Dport=$HUB_PORT org.testng.TestNG /usr/share/tag/RegressionSuite.xml