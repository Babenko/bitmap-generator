pipeline { 
    agent any  
    stages { 
//        stage('Build') { 
//            steps { 
//               echo 'This is a minimal pipeline.' 
//            }
//        }
        stage('SonarQube analysis') {
            // requires SonarQube Scanner 2.8+
            def scannerHome = tool 'SonarQube Scanner 2.8';
            withSonarQubeEnv('Sonar') {
                sh "${scannerHome}/bin/sonar-scanner"
            }
        }
    }
}
