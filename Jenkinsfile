pipeline {
  agent any
  stages {
    stage('initialization') {
      steps {
        echo 'Predictice initialization'
      }
    }
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            sh '''/home/tounga/maven3/bin/mvn clean install
'''
          }
        }
        stage('Test') {
          steps {
            sh '/home/tounga/maven3/bin/mvn test'
          }
        }
      }
    }
  }
}