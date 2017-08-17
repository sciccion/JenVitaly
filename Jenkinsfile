pipeline {
  agent {
    node {
      label 'ubuntu'
    }
    
  }
  stages {
    stage('error') {
      steps {
        parallel(
          "First step": {
            echo 'Hello'
            
          },
          "Date": {
            sh 'date'
            
          }
        )
      }
    }
    stage('Check app') {
      steps {
        fileExists 'first.groovy'
      }
    }
    stage('run app') {
      steps {
        sh '/usr/bin/groovy first.groovy'
      }
    }
    stage('check result') {
      steps {
        fileExists 'rp.txt'
      }
    }
    stage('git') {
      steps {
        git(url: 'git@github.com:sciccion/JenVitaly.git', branch: '/master', poll: true, credentialsId: 'c1372f54-03e8-4986-af3b-293c4afff74e')
      }
    }
  }
}