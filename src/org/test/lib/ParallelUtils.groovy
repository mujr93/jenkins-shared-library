package org.test.lib

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        def groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(new File('jenkins-shared-library/scripts/Threads.groovy'))
        def threads = groovyClass.getDeclaredConstructor().newInstance()
        threads.run(['development', 'staging', 'production', 'testing', 'stress', 'pre-production', 'post-production', 'qa'])
    }
}
