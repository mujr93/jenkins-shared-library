package org.test.lib

class ParallelUtils {

    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }

    def runPara(environments) {
        def s = """
            'groovy -v'.execute()
            def environments = ['kobe', 'lebron', 'cp3']
            for (def i = 0; i < environments.size(); i++) {
                def environment = environments[i]
                Thread.start {
                    println environment
                }
            }
        """
        steps.withGroovy {
            steps.sh "groovy -e \"${s}\""
        }
    }
}
