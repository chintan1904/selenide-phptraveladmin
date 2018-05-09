FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/phptravel-admin-tests.jar /usr/share/tag/phptravel-admin.jar
ADD  target/libs /usr/share/tag/libs

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "libs\*;phptravel-admin-tests.jar", "org.testng.TestNG", "-testjar", "phptravel-admin-tests.jar", "-testclass", "tests.LoginPageTest"]

#Below command not working
#ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/phptravel-admin.jar", "org.testng.TestNG", "-testclass", "com.tests.LoginPageTest"]