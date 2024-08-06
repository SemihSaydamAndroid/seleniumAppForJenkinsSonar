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
//                     export JAVA_HOME=/path/to/java-17
                    withSonarQubeEnv('SonarQube') {
//                             sh 'mvn sonar:sonar -Dsonar.sources=src/main/java -Dsonar.language=gherkin -Dsonar.tests=src/test/java/resources/parallel -Dsonar.inclusions=**/*.feature -Dsonar.qualitygate.wait=true -Dsonar.profile=Cucumber Gherkin'

//                      sh 'mvn sonar:sonar -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=cucumber -Dsonar.scannerOpts="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED"'

//       sh """
//                         mvn sonar:sonar \
//                         -Dsonar.sources=src/test/java \
//                         -Dsonar.profile=gherkin \
//                         -Dsonar.language=gherkin \
//                         -Dsonar.inclusions=**/*.feature \
//                         -Dsonar.test.inclusions=src/test/java/resources/parallel/*.feature \
//                         -Dsonar.qualitygate.wait=true \
//                         -Dsonar.scannerOpts='--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED'
//                     """
//                     [INFO] 18:40:12.270   Included sources: **/*.feature
//                        [INFO] 18:40:12.271   Excluded sources: src/test/java/resources/parallel/*.feature
//                        [INFO] 18:40:12.273   Included tests: src/test/java/resources/parallel/*.feature

//todo cannot index twice -->
// mvn sonar:sonar -Dsonar.sources=. -Dsonar.language=gherkin -Dsonar.tests=src/test/java/resources/parallel -Dsonar.inclusions=**/*.feature -Dsonar.qualitygate.wait=true -Dsonar.profile=Cucumber Gherkin

//                     -Dsonar.sources=src/main/resources               --> ile alakasız bir yeri gösterebilirsin. feature'ların olmadığı bir kısım olabilir
//                     -Dsonar.language=gherkin                         --> Plugin içinde bu şekilde verildiği için böyle verdik
//                     -Dsonar.tests=src/test/java/resources/parallel   --> feature'ların olduğu klasör
//                     -Dsonar.inclusions=**/*.feature                  --> sonar'ın tarayacağı şeyleri burada söylüyoruz
//                     -Dsonar.profile=Cucumber Gherkin                 --> Yeni bir dil olduğu için kalite profili tanımlıyoruz
//
//                         sh """
//                             export JAVA_OPTS="-Xmx512m --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED"
//                         """
//
                       sh """
                            ${scannerHome}/bin/sonar-scanner -X \
                            -Dsonar.projectKey=com.pointr:Pointr-cucumber \
                            -Dsonar.language=gherkin \
                            -Dsonar.test.inclusions=src/test/java/resources/parallel \
                            -Dsonar.sources=pom.xml,src/main/resources,src/test/java/resources/parallel \
                        """
// //                             -Dsome.property=value -Xmx512m --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED

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
