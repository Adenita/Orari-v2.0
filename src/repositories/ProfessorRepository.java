package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.SqliteConnection;

import model.Professor;

public class ProfessorRepository {
    
    // public List<Professor> Read() throws SQLException {
    //     ResultSet result = SqliteConnection.Read("Select * From Professor");
    //     List<Professor> professors = new ArrayList<>();
    //     while(result.next()) {
    //         professors.add(Read(result));
    //     }

    //     return professors;

    // }

    // public Professor Read(int id) throws SQLException {
    //     ResultSet result = SqliteConnection.Read("Select * From Professor Where Id = " + id);
    //     while(result.next()) {
    //         return Read(result);
    //     }

    //     return null;
    // }


    // public Professor Read(ResultSet result) throws SQLException {
    //     return new Professor(result.getInt("Id"), result.getString("Name"), result.getString("title"), result.getString("preferedStartTime"));

    // }
}
