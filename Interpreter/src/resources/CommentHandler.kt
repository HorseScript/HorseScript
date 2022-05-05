/*
 * Copyright (c) 2022, HorseScript
 * All rights reserved.
 */

package resources

object CommentHandler {



    fun handle (line: String): String {


        if (line.replace(" ", "").replace("\t", "").startsWith("~")) {
            return ""
            // Line is a comment.
        }



        if (line.contains("\"")) {

            var isQuoted : Boolean;

            val firstQuote : Int = line.indexOfFirst { it == '"' }

            val lastQuote : Int = line.indexOfLast { it == '"' }

            val commentAt : Int = line.indexOfFirst { it == '~' }


            if (firstQuote == lastQuote) {
                HorseError.badLine(line, "Line must contain two quotation marks, not one.")
            }


            if (commentAt in (firstQuote + 1) until lastQuote) {
                // Comment is in quotes.
                return line
            } else {
                return line.substring(0, commentAt - 1)
                // Comment is not in quotes.
            }


        }

        return line
    }

}