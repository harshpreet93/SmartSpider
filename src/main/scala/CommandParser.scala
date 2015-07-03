import scala.util.parsing.combinator._
import java.io.Serializable

case class ParseFailureException extends Exception
case class URL(link: String)
class CommandParser extends RegexParsers
{
    def number: Parser[Integer] = """[0-9]+""".r ^^
    {
        case num =>
        {
            num.toInt.asInstanceOf[Integer]
        }
    }
    def url: Parser[URL] = """_^(?:(?:https?|ftp)://)(?:\S+(?::\S*)?@)?(?:(?!10(?:\.\d{1,3}){3})
        (?!127(?:\.\d{1,3}){3})(?!169\.254(?:\.\d{1,3}){2})(?!192\.168(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|
        3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}
        (?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\x{00a1}-\x{ffff}0-9]+-?)*[a-z\x{00a1}-\x{ffff}
        0-9]+)(?:\.(?:[a-z\x{00a1}-\x{ffff}0-9]+-?)*[a-z\x{00a1}-\x{ffff}0-9]+)*(?:\.(?:[a-z\x{00a1}-\x{ff
        ff}]{2,})))(?::\d{2,5})?(?:/[^\s]*)?$_iuS""".r ^^
        {
            case u => URL(u)
        }

    def string: Parser[String] = """[a-zA-Z]+""".r

    def link_flags: Parser[Array[String]] = ("-l" ~> url) ^^
    {
        case c => Array[String]("-l", c.link)
    }
    def google_flags: Parser[Array[String]] = ("-g" ~> string ~ number) ^^
    {
        case s ~ n => Array[String]("-g", s, n.toString)
    }
    
    def get_flags: Parser[Array[String]]  = link_flags | google_flags



    def command: Parser[AddSeedCommand] = "as" ~> get_flags^^
    {
        case a => new AddSeedCommand(a.head, a.tail)
    }

}
