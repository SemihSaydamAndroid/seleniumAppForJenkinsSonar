pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    stages {
        stage('Clone repository') {
            steps {
                cleanWs()
                git branch: 'main', url: 'https://github.com/SemihSaydamAndroid/seleniumAppForJenkinsSonar.git'
            }
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
