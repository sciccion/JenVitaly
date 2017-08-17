pipeline {
  agent {
    node {
      label 'ubuntu'
    }
    
  }
  stages {
    stage('') {
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
    stage('Install Groovy') {
      steps {
        sh 'apt-get update && apt-get install groovy'
      }
    }
    stage('run app') {
      steps {
        sh 'exec /usr/bin/groovy first.groovy'
      }
    }
    stage('check result') {
      steps {
        fileExists 'rp.txt'
      }
    }
    stage('git') {
      steps {
        git(url: 'git@github.com:sciccion/JenVitaly.git', branch: '/master', poll: true)
      }
    }
  }
}