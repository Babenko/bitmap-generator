
node {
  //env.JAVA_HOME = "${tool 'JDK8'}"
  //env.MAVEN_HOME = "${tool 'maven'}"
  env.JAVA_HOME="${tool 'JDK'}"
  env.MAVEN_HOME="${tool 'maven'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      
      sh 'mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.branch=${BRANCH_NAME}'
    }
  }
}
