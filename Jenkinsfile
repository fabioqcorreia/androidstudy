node('android') {
    stage('Git') {
        checkout scm
    }
    stage('Build') {
        sh './gradlew --refresh-dependencies clean assemble'
        lock('emulator') {
          sh './gradlew connectedCheck'
        }
        currentBuild.result = 'SUCCESS' 
    }
    stage('AWS Devicefarm') {
        junit '**/test-results/**/*.xml'
    }
    stage('Archive') {
      archiveArtifacts 'app/build/outputs/apk/*'
    }
}