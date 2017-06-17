package yrostami.service;

import org.postgresql.ds.PGSimpleDataSource;
import yrostami.entity.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yousef.
 */
public class DataBase {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    private static PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public static void initializeDatabase(String serverName, String databaseName,
                                           int portNumber, String user, String password)
    {

        dataSource.setServerName(serverName);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(portNumber);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setSsl(true);
        dataSource.setSslfactory("org.postgresql.ssl.NonValidatingFactory");
    }

    public static void destroyDatabase() {
        executor.shutdown();
    }

    private static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void saveResult(final Result result){
        executor.submit(new Runnable() {
            public void run()
            {
                String sql = "INSERT INTO result"+
                        "(fname,lname,sexuality,age,married,education,occupation," +
                        "answer_count,correct_answer_count,correct_answer_percent," +
                        "wrong_answer_count,no_answer_count,time_average,time_standard_deviation) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try(Connection con = getConnection();
                    PreparedStatement statement = con.prepareStatement(sql)) {


                    statement.setString(1, result.getFirstName());
                    statement.setString(2, result.getLastName());
                    statement.setString(3, result.getSexuality());
                    statement.setInt(4, result.getAge());
                    statement.setString(5, result.getMarried());
                    statement.setString(6, result.getEducation());
                    statement.setString(7, result.getOccupation());
                    statement.setInt(8, result.getAnswersCount());
                    statement.setInt(9, result.getCorrectAnswersCount());
                    statement.setFloat(10, result.getCorrectAnswersPercent());
                    statement.setInt(11, result.getWrongAnswersCount());
                    statement.setInt(12, result.getNoAnswersCount());
                    statement.setInt(13, result.getTimeAverage());
                    statement.setInt(14, result.getTimeStandardDeviation());

                    statement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });// end executor.submit()
    }

    public static List<Result> getAllResults(){
        List<Result> list = new LinkedList<>();
        Result result;
        String sql = "SELECT * FROM result";

        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()) {

            while (rs.next()){
                result = new Result();
                result.setFirstName(rs.getString("fname"));
                result.setLastName(rs.getString("lname"));
                result.setSexuality(rs.getString("sexuality"));
                result.setAge(rs.getInt("age"));
                result.setMarried(rs.getString("married"));
                result.setEducation(rs.getString("education"));
                result.setOccupation(rs.getString("occupation"));

                result.setAnswersCount(rs.getInt("answer_count"));
                result.setCorrectAnswersCount(rs.getInt("correct_answer_count"));
                result.setCorrectAnswersPercent(rs.getFloat("correct_answer_percent"));
                result.setWrongAnswersCount(rs.getInt("wrong_answer_count"));
                result.setNoAnswersCount(rs.getInt("no_answer_count"));
                result.setTimeAverage(rs.getInt("time_average"));
                result.setTimeStandardDeviation(rs.getInt("time_standard_deviation"));
                list.add(result);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    public static boolean isValidUser(String username, String password)
    {
        boolean flag = false;
        String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";
        ResultSet rs = null;

        try(Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement(sql)){

            statement.setString(1,username);
            statement.setString(2,password);
            rs = statement.executeQuery();
            if (rs.next() && rs.getInt(1) > 0 )
                flag = true;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(rs != null)
                try {
                    rs.close();
                }catch (SQLException e){

                }
        }
        return flag;
    }

    public static int getResultsCount(){
        String sql = "SELECT COUNT(*) FROM result";
        int count = 0;

        try(Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery())
        {
            if (rs.next())
                count = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }
}