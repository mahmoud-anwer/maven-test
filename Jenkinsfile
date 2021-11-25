pipeline {
    agent any
    tools {
        maven "maven-3.8.4"
        //jdk "JDK"
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mahmoud-anwer/maven-test.git'
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean package"
            }
        }  
        stage('Run') {
            steps {
                echo ">> Start running jar files"
                sh "java -jar $WORKSPACE'/target/test.jar'"
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
            }
        }
        }
    }
}
