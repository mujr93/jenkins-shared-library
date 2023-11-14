package org.test.lib

class ParallelUtils {

    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara(environments) {
        def e = environments.join(',')
        def s = """
            def environments = ${e.split(',')}
            for (def i = 0; i < environments.size(); i++) {
                def environment = environments[i]
                Thread.start {
                    println environment
                }
            }
        """
        steps.withGroovy {
            steps.sh """groovy -e "${s}""""
        }
    }
}
