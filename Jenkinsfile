
node {
  //env.JAVA_HOME = "${tool 'JDK8'}"
  //env.MAVEN_HOME = "${tool 'maven'}"
  env.JAVA_HOME="${tool 'JDK'}"
  env.MAVEN_HOME="${tool 'maven'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
      // requires SonarQube Scanner for Maven 3.2+
      //sh 'export JAVA_HOME=/home/babenkosemen/.sdkman/candidates/java/current/bin'
      
      sh 'export PATH=$PATH:/home/babenkosemen/.sdkman/candidates/java/current/bin'
      sh 'pwd'
      sh 'echo $PATH'
      sh 'echo $JAVA_HOME'
      sh 'mvn -v'
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
