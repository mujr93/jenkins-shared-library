package org.test.lib

import static groovyx.gpars.GParsPool.*

class ParallelUtils {
    
    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }
    
    def runPara() {
        def mylist = ['item1','item2']
        withPool {
            mylist.eachParallel {
                fun1(it)
                fun2(it)
            }
        }
        //def testSteps = ['setupDevkit', 'executeDevkit', 'restoreDevkit']
    
        //testSteps.stream().filter(s -> s != 'setupDevkit').forEach(s -> steps.echo s)
        //testSteps.stream().forEach(s -> steps.echo s)
        //testSteps.parallelStream().forEach(s -> steps.echo s)
    }

    def fun1(s) {
        println "function-1 - ${s}"
    }
    
    def fun2(s) {
        println "function-2 - ${s}"
    }
}
