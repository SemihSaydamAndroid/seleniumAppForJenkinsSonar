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
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}


//Jenkinsfile'ı repoya koymanıza rağmen tanımıyorsa[not a git repository] : 
//  cd /var/jenkins_home
//  git config --global --add safe.directory '*'