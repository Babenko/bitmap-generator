
node {
  //env.JAVA_HOME = "${tool 'JDK8'}"
  //env.MAVEN_HOME = "${tool 'maven'}"
  env.JAVA_HOME="${tool 'JDK'}"
  env.MAVEN_HOME="${tool 'maven'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
        withCredentials([[$class : 'StringBinding', credentialsId   : 'github', variable: 'GITHUB_TOKEN',]]) {
        // requires SonarQube Scanner for Maven 3.2+
        sh 'echo ${env.GITHUB_TOKEN}'
        sh 'mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=${env.CHANGE_ID} -Dsonar.github.repository=Babenko/bitmap-generator -Dsonar.github.oauth=${env.GITHUB_TOKEN}'
      }
    }
  }
}
