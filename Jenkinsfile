
node {
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'export PATH=$PATH:/home/babenkosemen/.sdkman/candidates/maven/current/bin'
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
