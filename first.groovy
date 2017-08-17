
class Report {

    private String name
    def sout = new StringBuilder(), serr = new StringBuilder()
    def proc = 'cat /proc/cpuinfo'.execute()

    def writeFile () {
        def f = new File("${this.name}.txt")

        if (!f.exists()) {
            f.createNewFile()
        }
        proc.consumeProcessOutput(sout, serr)
        proc.waitForOrKill(1000)
        f.append("out>\n $sout err>\n $serr")
    }

}

MyRepo = new Report()
MyRepo.name = 'rp'
MyRepo.writeFile()

