//import java.sql.DriverManager;
//// Establish a connection
//Connection connection = DriverManager.getConnection(url, user, password);
//
//// Create a statement
//Statement statement = connection.createStatement();
//
//// Execute a query and map results to Java objects
//ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
//while (resultSet.next()) {
//RPGItem item = new RPGItem();
//    item.setId(resultSet.getInt("id"));
//        item.setName(resultSet.getString("name"));
//        item.setType(resultSet.getString("type"));
//        item.setRarity(resultSet.getString("rarity"));
//        // Add item to a collection or perform other operations
//        }
//
//// Close resources
//        resultSet.close();
//statement.close();
//connection.close();
