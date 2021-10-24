package Manager;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

public class ListManager {

	DBConnection mainConnection = new DBConnection();
	Connection connection = mainConnection.connect();
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement;

	public ArrayList<List> getList() {

		ArrayList<List> list = new ArrayList();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM list");

			List obj;
			while (resultSet.next()) {

				obj = new List();

				obj.setId(resultSet.getInt("id"));
				obj.setTask(resultSet.getString("task"));
				obj.setOnem(resultSet.getString("onem"));

				list.add(obj);
			}

			return list;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public boolean addTask(String task) {

		String query = "INSERT INTO list" + "(task)" + " VALUES" + "(?)";
		boolean key = false;

		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, task);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return key;
	}

	public boolean deleteTask(int id) {

		String query = "DELETE FROM list WHERE id = ?";
		boolean key = false;

		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return key;
	}

	public List getFetch(int id) {
		List list = new List();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM list WHERE id =" + id);
			
			while(resultSet.next()) {
				list.setId(resultSet.getInt("id"));
				list.setOnem(resultSet.getString("onem"));
				list.setTask(resultSet.getString("task"));
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public boolean updateTask(int id, String task) {
		String query = "UPDATE list SET task = ? WHERE id = ?";
		boolean key = false;
		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, task);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			
			key = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return key;
	}
	
	public boolean updateOnem(int id, String onem) {
		String query = "UPDATE list SET onem = ? WHERE id = ?";
		boolean key = false;
		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, onem);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			
			key = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return key;
	}

}
