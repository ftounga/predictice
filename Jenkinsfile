pipeline {
  agent any
  stages {
    stage('initialization') {
      steps {
        echo 'Predictice initialization'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
}