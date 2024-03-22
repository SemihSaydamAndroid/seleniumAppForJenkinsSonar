pipeline {
    agent any

    tools {
        maven 'mvnDefault'
        git 'gitDefault'
    }

    environment {
            MYSQL_USER = 'root'
            MYSQL_PASSWORD = 'root'
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
//                             sh 'mvn sonar:sonar -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=java-webdriver'
                            sh 'mvn sonar:sonar -Dsonar.sources=src -Dsonar.test.inclusions=src/test/java -Dsonar.qualitygate.wait=true -Dsonar.profile=java-webdriver -Dsonar.scannerOpts="--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED"'


//                        sh """
//                             ${scannerHome}/bin/sonar-scanner -X \
//                             -Dsonar.projectKey=com.pointr:Pointr-cucumber \
//                             -Dsonar.language=gherkin \
//                             -Dsonar.test.inclusions=src/test/java/resources/parallel \
//                             -Dsonar.sources=pom.xml,src/main/java,src/main/resources,src/test/resources/parallel \
//                             -Dsome.property=value -Xmx512m --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED
//                         """
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

        stage('Check network-bridge') {
            steps {
                sh 'docker ps'
                sh 'docker network ls'
                sh 'docker network inspect seleniumappforjenkinssonar_network-bridge'
            }
        }

        stage('MySQL Connection') {
            steps {
                script {
                    def passed = 10
                    def failed = 2
                    def duration = 300
                    def dbHost = 'mysql'
                    def dbName = 'test_database'
                    def dbTable = 'test_results'

                    withEnv(["MYSQL_USER=user", "MYSQL_PASSWORD=password"]) {
                        sh """
                            docker run --network seleniumappforjenkinssonar_network-bridge --rm mysql:8.0 sh -c 'mysql -h ${dbHost} -u \$MYSQL_USER -p\$MYSQL_PASSWORD ${dbName} -e \"
                                INSERT INTO ${dbTable} (passed, failed, duration)
                                VALUES (${passed}, ${failed}, ${duration});
                            \"'
                        """

                        // SELECT sorgusu eklenmiştir.
                        sh """
                            docker run --network seleniumappforjenkinssonar_network-bridge --rm mysql:8.0 sh -c 'mysql -h ${dbHost} -u \$MYSQL_USER -p\$MYSQL_PASSWORD ${dbName} -e \"
                                SELECT * FROM ${dbTable};
                            \"'
                        """
                    }
                }
            }
        }
    }
}
