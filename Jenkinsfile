import groovy.time.TimeCategory
import groovy.time.TimeDuration

def time
def startTime
def duration
/*TimeDuration td*/

pipeline {
    agent any
    /*options {
        datadog(collectLogs: true, tags: ["pipelineTag:test"])
    }*/
    options {
        datadog(collectLogs: true, tags: ["pipelineTag:${debugparam}"])
    }

    parameters{
        string(name: 'debugparam', defaultValue: 'testValue', description: 'Just debug value')
    }

    stages {
        stage('Build') {
            steps {
                echo "Build step"
            }
        }
        stage('Test') {
            steps {
                script {
                    timeout(time: 1, unit: 'HOURS') {
                        startTime = System.currentTimeMillis()
                        /*time = new Date().format("yy-MM-dd.HH:mm:ss", TimeZone.getTimeZone('UTC'))*/
                        time = new Date()
                        sleep(10)
                        /*def now = new Date()*/
                        /*time = new Date().format("yy-MM-dd.HH:mm:ss", TimeZone.getTimeZone('UTC'))*/
                        println time
                        duration = System.currentTimeMillis() - startTime

                        echo "Duration: ${duration}"
                        /*duration = groovy.time.TimeCategory.minus(new Date().format("yy-MM-dd.HH:mm:ss", TimeZone.getTimeZone('UTC')) , time)*/
                        /* td = TimeCategory.minus(new Date(), time)*/

                        println "Duration: " + TimeCategory.minus(new Date(), time)
                    }

                }

               /* datadog(collectLogs: true, tags: ["duration:${TimeCategory.minus(new Date(), time)}", "param: ${debugparam}"]){
                   *//* echo "inside datadog"*//*
                }*/
                /*datadog(collectLogs: true, tags: [stepTag:debugPipeline])*/
                /*$pipelineTag = sepTag*/
                echo "Test step"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploy step"
            }
        }
    }
    post{
        always{
            echo "Post step"
        }
    }
}
