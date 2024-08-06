pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    environment {
            MYSQL_USER = 'root'
            MYSQL_PASSWORD = 'root'
         scannerHome = tool 'sonar-scanner-6'
    }

    stages {
        stage('Clone repository') {
            steps {
                cleanWs()

//                 git branch: 'main', url: 'https://github.com/SemihSaydamAndroid/seleniumAppForJenkinsSonar.git'
                  checkout([
                            $class: 'GitSCM',
                            branches: [[name: '*/main']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [
                                [$class: 'RelativeTargetDirectory', relativeTargetDir: ''],
                                [$class: 'CheckoutOption', timeout: 100] // timeout value increased to 20
                            ],
                            submoduleCfg: [],
                            userRemoteConfigs: [[url: 'https://github.com/SemihSaydamAndroid/seleniumAppForJenkinsSonar.git']]
                        ])
            }
        }

        stage('Sonarqube analysis') {
            steps {
                script {
                    withSonarQubeEnv('SonarQube') {
                            sh """
                                mvn sonar:sonar \
                                -Dsonar.projectKey=com.pointr:Pointr-cucumber \
                                -Dsonar.profile=cucumber \
                                -Dsonar.language=gherkin \
                                -Dsonar.gherkin.file.suffixes=.feature \
                                -Dsonar.test.inclusions=src/test/java/resources/parallel \
                                -Dsonar.sources=pom.xml,src/main/resources,src/test/java/resources/parallel \
                                -Dsonar.scannerOpts='--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-modules java.xml.bind'
                            """

                    }
                }
            }
        }


        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

//         stage('Cucumber Report') {
//             steps {
//                 script {
// //                  kullanmak için plugin kurmanız gerekir.
//                     cucumber buildStatus: 'UNSTABLE',
//                             fileIncludePattern: '**/cucumber.json',
//                             sortingMethod: 'NATURAL'
//                 }
//             }
//         }

        stage('Check network-bridge') {
            steps {
                sh 'docker ps'
                sh 'docker network ls'
                sh 'docker network inspect seleniumappforjenkinssonar_my_network'
            }
        }

        stage('MySQL Connection') {
            steps {
                script {
                    def passed = 5
                    def failed = 10
                    def duration = 350
                    def dbHost = 'mysql'
                    def dbName = 'test_database'
                    def dbTable = 'test_results'

                    sh """
                        docker run --network seleniumappforjenkinssonar_my_network --rm mysql:8.0 sh -c "mysql -h ${dbHost} -u $MYSQL_USER -p$MYSQL_PASSWORD ${dbName} -e \
                            'INSERT INTO ${dbTable} (passed, failed, duration) \
                            VALUES (${passed}, ${failed}, ${duration}); \
                            SELECT * FROM ${dbTable};'"
                    """
                }
            }
        }
    }
}
