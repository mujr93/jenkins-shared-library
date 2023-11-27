package org.test.lib

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        evaluate(new File("Threads.groovy"))
        def threads = new Threads(environments)
    }
}
