pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    stages {
        stage('Clean workspace') {
            steps {
                cleanWs()
            }
        }
        // stage('Docker compose') {
        //     steps {
        //         sh 'docker compose -f jenkinsSonar.yml up -d --scale chrome=5 --scale firefox=0'
        //     }
        // }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
