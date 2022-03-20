package gradle.util

class Input {

    static List<String> readFromFile(String fileName) {
        List<String> strings = new ArrayList<>()
        try {
            File file = new File(fileName)
            Scanner scanner = new Scanner(file)
            while (scanner.hasNextLine()) {
                String sql = scanner.nextLine()
                strings.add(sql)
            }
            scanner.close()
        } catch (FileNotFoundException e) {
            e.printStackTrace()
        }
        return strings
    }
}
