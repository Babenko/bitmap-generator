
node {
  //env.JAVA_HOME = "${tool 'JDK8'}"
  env.MAVEN_HOME = "${tool 'maven'}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'export JAVA_HOME=/home/babenkosemen/.sdkman/candidates/java/current/bin'
      sh '/home/babenkosemen/.sdkman/candidates/maven/current/bin/mvn -v'
      sh 'export PATH=$PATH:/home/babenkosemen/.sdkman/candidates/maven/current/bin'
      sh 'pwd'
      sh 'echo $PATH'
      sh '/home/babenkosemen/.sdkman/candidates/maven/current/bin/mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
