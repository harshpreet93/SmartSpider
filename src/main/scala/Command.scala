trait Command {
    var opcode: String
    var flags: Array[String]

    def get_opcode(): String = {
        return opcode
    }

    def get_flags(): Array[String] = {
        return flags
    }
}
