pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
         stage('Clone repository') { 
            steps { 
                script{
                checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/skevin83/aws-eks.git']]]) 
                }
            }
        }

        stage('Build') { 
            steps {     
                sh `cd application`            
                script {
                 app = docker.build("demo-java-app")
                }
            }
        }
        stage('Test'){
            steps {
                echo 'Empty'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    docker.withRegistry('https://619587246008.ecr.us-east-1.amazonaws.com', 'ecr:us-east-1:aws-credentials') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }
}
