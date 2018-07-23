
node {
  //env.JAVA_HOME = "${tool 'JDK8'}"
  //env.MAVEN_HOME = "${tool 'maven'}"
  env.JAVA_HOME="${tool 'JDK'}"
  env.MAVEN_HOME="${tool 'maven'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      
      sh 'mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.branch=jenkins-branch -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=1 -Dsonar.github.repository=Babenko/bitmap-generator -Dsonar.github.oauth=c2c359c342e9dc5c48bd41d70407a800ea7a3654'
    }
  }
}
