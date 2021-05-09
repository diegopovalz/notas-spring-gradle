pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'Builing application'
                echo 'Application built'
                sh './gradlew clean build'
            }
        }
        stage('test') {
            steps {
                echo 'Testing application'
                echo 'Application tested'
                sh './gradlew test'
            }
        }
        stage('deploy') {
            steps {
                echo 'Deploying application'
                echo 'Application deployed'
            }
        }
    }
}