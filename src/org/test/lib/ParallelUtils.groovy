class SomeClass {

    static void main(args) {
        def environments = ["development", "staging", "production", "testing", "stress", "pre-production", "post-production", "qa"]

        for (def i = 0; i < environments.size(); i++) {
            def environment = environments[i]
            Thread.start {
                println environment
            }
        }
        
        println args.size()
        
        for (def i = 0; i < args.size(); i++) {
            println args[i]
        }
    }
}
