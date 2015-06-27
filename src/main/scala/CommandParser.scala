import scala.util.parsing.combinator._

class CommandParser extends RegexParsers
{
    def number: Parser[Integer] = """[0-9]+""".r ^^
    {
        case num =>
        {
            num.toInt.asInstanceOf[Integer]
        }
    }
    
}
