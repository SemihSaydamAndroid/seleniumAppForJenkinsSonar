pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
        // SonarQube Scanner installations ekleyin
        sonarqube 'SonarQube'
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
                script {
                    // SonarQube Scanner kullanarak analiz yap
                    def scannerHome = tool 'SonarQube'
                    withEnv(["PATH+MAVEN=${tool 'mvnDefault'}/bin"]) {
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=java-webdriver"
                    }
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
                    cucumber buildStatus: 'UNSTABLE',
                            fileIncludePattern: '**/cucumber.json',
                            sortingMethod: 'NATURAL'
                }
            }
        }
    }
}
