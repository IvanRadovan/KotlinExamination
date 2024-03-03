import java.io.File

class FileReader {

     companion object {
         fun read(path: String): List<String> = File(path).bufferedReader().readLines()
     }

}