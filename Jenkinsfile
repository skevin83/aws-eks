pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
         stage('Clone Repository') { 
            steps { 
                script{
                    checkout([$class: 'GitSCM', branches: [[name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '', url: 'https://github.com/skevin83/aws-eks.git']]]) 
                }
            }
        }
        stage('Build') { 
            steps {                
                script {
                 app = docker.build("demo-helloworld-java-app")
                }
            }
        }
        stage('Test'){
            steps {
                echo 'Empty'
            }
        }
        stage('Upload Image to Registry') {
            steps {
                script {
                    docker.withRegistry('https://619587246008.dkr.ecr.ap-southeast-1.amazonaws.com', 'ecr:ap-southeast-1:aws-credentials') {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
        stage('Deploying App to Kubernetes') {
          steps {
            script {
              kubernetesDeploy(configs: "k8s.yml", kubeconfigId: "kubernetes")
            }
          }
        }
    }
}
