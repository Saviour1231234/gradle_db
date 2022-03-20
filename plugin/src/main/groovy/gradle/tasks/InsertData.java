package gradle.tasks;

import gradle.util.Input;
import gradle.util.SqlService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.sql.*;
import java.util.List;

public class InsertData extends DefaultTask {

    @TaskAction
    public void insertData() throws ClassNotFoundException {
        List<String> readFromFile = Input.readFromFile("data.sql");

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(SqlService.DATABASE_URL, SqlService.USER, SqlService.PASS);
             Statement statement = connection.createStatement()){
            for (String sql : readFromFile) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
