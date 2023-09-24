pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    stages {
        stage('Clone repository') {
            cleanWs()
            git -b main 'https://github.com/SemihSaydamAndroid/seleniumAppForJenkinsSonar'
        }
        stage('Docker compose') {
            steps {
                sh 'docker compose -f jenkinsSonar.yml up -d --scale chrome=5 --scale firefox=0'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}