node {
  checkout scm
  env.JAVA_HOME="${tool 'JDK'}"
  env.MAVEN_HOME="${tool 'maven'}"
  
  env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
  stage('SonarQube analysis') {
    withSonarQubeEnv('Sonar') {
        withCredentials([[$class : 'StringBinding', credentialsId   : 'github', variable: 'GITHUB_TOKEN',]]) {
        // requires SonarQube Scanner for Maven 3.2+
        def response = httpRequest url: 'https://api.github.com/repos/Babenko/bitmap-generator/pulls', customHeaders: [[name: 'Authorization', value: "Basic ${env.GITHUB_TOKEN}"]]
        
        def data = readJSON text: response.content
        
          sh "echo ${data}"
        sh "echo ${BRANCH_NAME}"
          sh "echo ${env.BRANCH_NAME}"
        sh "echo ${env.SONAR_ENDPOINT}" 
        sh "mvn clean package org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=${env.CHANGE_ID} -Dsonar.github.repository=Babenko/bitmap-generator -Dsonar.github.oauth=${env.GITHUB_TOKEN}"
      }
    }
  }
}
