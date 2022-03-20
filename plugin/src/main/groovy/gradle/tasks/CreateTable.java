package gradle.tasks;

import gradle.util.Input;
import gradle.util.SqlService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable extends DefaultTask {

    @TaskAction
    public void createTable() throws ClassNotFoundException {
        String schema = Input.readFromFile("schema.sql").get(0);

        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection(
                SqlService.DATABASE_URL, "postgres", "postgres");
             Statement statement = conn.createStatement()) {
            statement.execute(schema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
