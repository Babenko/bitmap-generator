
node {
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'who'
      sh 'export PATH=$PATH:/home/babenkosemen/.sdkman/candidates/maven/current/bin'
      sh 'pwd'
      sh 'echo $PATH'
      sh '/home/babenkosemen/.sdkman/candidates/maven/current/bin/mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
