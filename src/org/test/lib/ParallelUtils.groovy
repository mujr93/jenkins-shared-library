package org.test.lib

class ParallelUtils {
    
    def steps
    def script

    def ParallelUtils(steps, script) {
        this.steps = steps
        this.script = script
    }
    
    def runPara() {
    def testSteps = ['setupDevkit', 'executeDevkit', 'restoreDevkit']

    testSteps.stream().filter(s -> s != 'setupDevkit').forEach(s -> steps.echo s)
    testSteps.stream().forEach(s -> steps.echo s)
    testSteps.parallelStream().forEach(s -> steps.echo s)
  }
}
