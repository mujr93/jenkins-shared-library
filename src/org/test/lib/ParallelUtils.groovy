package org.test.lib

class ParallelUtils {

    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara(environments) {
        steps.withGroovy {
            steps.sh "groovy -e 'new ParallelUtils(steps, script).testPara()'"
        }
    }

    def testPara() {
        def proc = 'groovy -v'.execute()
        println proc.in.text ?: proc.err.text
        def environments = ['kobe', 'lebron', 'cp3']
        for (def i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            Thread.start {
                println environment
            }
        }
    }
}
