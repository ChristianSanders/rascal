node {
  def mvnHome = tool 'M3'
  env.JAVA_HOME="${tool 'jdk-oracle-8'}"
  env.PATH="${env.JAVA_HOME}/bin:${mvnHome}/bin:${env.PATH}"
  
  try {
    stage('Clone'){
      checkout scm
    }
    
    stage('Build') {
      sh "mvn -Drascal.courses=--buildCourses -Drascal.boot=--validating -B clean test"
      sh "curl https://codecov.io/bash | bash -s - -K -X gcov -t e8b4481a-d178-4148-a4ff-502906390512"
    }
    
    stage('Packaging') {
      sh "mvn -DskipTests -B package"
    }
    
    stage('Deploy') {
      if (env.BRANCH_NAME == "master" || env.BRANCH_NAME == "jenkins-deploy") {
        sh "mvn -s ${env.HOME}/usethesource-maven-settings.xml -DskipTests -B deploy"
      }
    }
    
    stage('Archive') {
      step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    }
    
    if (currentBuild.previousBuild.result == "FAILURE") { 
      slackSend (color: '#5cb85c', message: "BUILD BACK TO NORMAL: <${env.BUILD_URL}|${env.JOB_NAME} [${env.BUILD_NUMBER}]>")
    }
 
    build job: '../rascal-eclipse/master', wait: false
  } catch (e) {
    slackSend (color: '#d9534f', message: "FAILED: <${env.BUILD_URL}|${env.JOB_NAME} [${env.BUILD_NUMBER}]>")
    throw e
  }
}
