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

        stage('Sonarqube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=java-webdriver'
                }
            }
        }

        stage('Build') {
            steps {

                sh 'mvn clean install'  //quiet option -- sh 'mvn -q clean install'
            }
        }

        stage('Cucumber Report') {
             steps {
                  script {
                         cucumber buildStatus: 'UNSTABLE', //kullanmak için "cucumber reports" plugin'ini kurman gerekir
                                 fileIncludePattern: '**/cucumber.json',
                                 sortingMethod: 'NATURAL'
                     }
             }
        }
    }
}

