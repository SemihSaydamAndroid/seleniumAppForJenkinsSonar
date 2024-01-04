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
                    sh 'mvn sonar:sonar -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.profile=WebDriver'
                }
            }
        }

        stage('Build') {
            steps {
//                 sh 'mvn -q clean install'
                sh 'mvn clean install'
            }
        }

        stage('Cucumber Report') {
             steps {
                  script {
                  //kullanmak için "cucumber reports" plugin'ini kurman gerekir
                         cucumber buildStatus: 'UNSTABLE',
                                 fileIncludePattern: '**/cucumber.json',
                                 sortingMethod: 'NATURAL'
                     }
             }
        }
    }
}

//Jenkinsfile'ı repoya koymanıza rağmen tanımıyorsa[not a git repository] : 
//  cd /var/jenkins_home
//  git config --global --add safe.directory '*'