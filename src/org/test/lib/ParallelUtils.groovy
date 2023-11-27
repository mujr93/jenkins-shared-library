package org.test.lib

class ParallelUtils {

    def script

    ParallelUtils(script) {
        this.script = script
    }

    def runPara(environments) {
        script.echo 'Starting Para'

        script.echo 'Ending Para'
    }
}
