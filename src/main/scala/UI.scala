import scala.collection.{ mutable, immutable, generic }
import scala.io._
object UI  {

    val main_menu = "To add a seed manually, use \"as -l www.twitter.com\""+ "\n"+
                    "To add seeds from Google, use \"as -g cats 10\" this will " +
                    "add the first 10 search results for the Google query \"cats\""+
                    " as seeds or all search results if there are less than 10 results" +"\n"+
                    "Press q to quit"

    val db_location = "Where do you want the database to be located? ex. \"Documents/spider\""
    val db_max_storage = "What's the maximum amount of storage you want the database to take up? Enter in terms of GB ex. \"32\""


    def show_main_menu = main_menu

    def main(args: Array[String]) = {
        var input = ""
        println(show_main_menu)
        input = readLine
        while( input != "q"){
            println(show_main_menu)
            //TODO: Do something with input

            input = readLine
        }
    }
}
