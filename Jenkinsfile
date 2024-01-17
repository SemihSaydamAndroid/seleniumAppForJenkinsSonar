pipeline {
    agent any

    options {
        jvmOptions('-Dsome.property=value', '-Xmx512m', '--add-opens java.base/java.lang=ALL-UNNAMED', '--add-opens=java.base/java.util=ALL-UNNAMED')
    }

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    environment {
         scannerHome = tool 'SonarScanner' // the name you have given the Sonar Scanner (in Global Tool Configuration)
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
//                     export JAVA_HOME=/path/to/java-17
                    withSonarQubeEnv('SonarQube') {
                       sh "${scannerHome}/bin/sonar-scanner -X \
                               -Dsonar.projectKey=com.pointr:Pointr-cucumber \
                               -Dsonar.language=gherkin \
                               -Dsonar.test.inclusions=src/test/java/resources/parallel \
                               -Dsonar.sources=pom.xml,src/test/java/resources/parallel"
                    }
                }
            }
        }
//                         sh 'mvn sonar:sonar -Dsonar.projectKey=com.pointr:Pointr-cucumber -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=java-webdriver'


        stage('Build') {
            steps {
                sh 'mvn clean install'
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
