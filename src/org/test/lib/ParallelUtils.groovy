package org.test.lib

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        script.echo 'Starting Para'
        evaluate(new File("../../../../../scripts/Threads.groovy"))
        def threads = new Threads(environments)
        script.echo 'Ending Para'
    }
}
