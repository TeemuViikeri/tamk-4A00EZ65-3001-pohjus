import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
	for (i in args.indices) {
		println(args[i])
		replaceTabs(args[i])
	}
}

fun replaceTabs(path: String) {
	try {
		val lines : MutableList<String> = Files.readAllLines(Paths.get(path))
		lines.forEach() {
			if (it.contains("\t")) {
				val line = it.replace("\t", "____")
				println(line)
			}
		}
		println("END OF FILE")
	}
	catch(e: Exception) {
		e.printStackTrace();
	}
}