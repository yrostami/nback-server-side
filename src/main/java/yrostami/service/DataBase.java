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

    private static ExecutorService executor = Executors.newFixedThreadPool(17);

    private static PGSimpleDataSource dataSource = new PGSimpleDataSource();

    public static void initializeDatabase()
    {


        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        dataSource.setUrl(dbUrl);
        dataSource.setSsl(true);
        dataSource.setSslfactory("org.postgresql.ssl.NonValidatingFactory");

//        dataSource.setServerName("localhost");
//        dataSource.setDatabaseName("nback");
//        dataSource.setPortNumber(5432);
//        dataSource.setUser("yousef");
//        dataSource.setPassword("yr00137255");
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
                        "(fname,lname,sexuality,age,married,education,state," +
                        "answer_count,correct_answer_count,correct_answer_percent," +
                        "wrong_answer_count,no_answer_count,time_average,time_standard_deviation," +
                        "t1n,t1e,t1o,t1a,t1c,t2p1,t2p2,t2p3,t2p4,t2p5,t3f1,t3f2,t3f3,t3f4) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try(Connection con = getConnection();
                    PreparedStatement statement = con.prepareStatement(sql)) {


                    statement.setString(1, result.getFirstName());
                    statement.setString(2, result.getLastName());
                    statement.setString(3, result.getSexuality());
                    statement.setInt(4, result.getAge());
                    statement.setString(5, result.getMarried());
                    statement.setString(6, result.getEducation());
                    statement.setString(7, result.getState());
                    statement.setInt(8, result.getAnswersCount());
                    statement.setInt(9, result.getCorrectAnswersCount());
                    statement.setFloat(10, result.getCorrectAnswersPercent());
                    statement.setInt(11, result.getWrongAnswersCount());
                    statement.setInt(12, result.getNoAnswersCount());
                    statement.setInt(13, result.getTimeAverage());
                    statement.setInt(14, result.getTimeStandardDeviation());

                    statement.setInt(15,result.getT1N());
                    statement.setInt(16,result.getT1E());
                    statement.setInt(17,result.getT1O());
                    statement.setInt(18,result.getT1A());
                    statement.setInt(19,result.getT1C());
                    statement.setInt(20,result.getT2p1());
                    statement.setInt(21,result.getT2p2());
                    statement.setInt(22,result.getT2p3());
                    statement.setInt(23,result.getT2p4());
                    statement.setInt(24,result.getT2p5());
                    statement.setInt(25,result.getT3f1());
                    statement.setInt(26,result.getT3f2());
                    statement.setInt(27,result.getT3f3());
                    statement.setInt(28,result.getT3f4());

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
                result.setState(rs.getString("state"));

                result.setAnswersCount(rs.getInt("answer_count"));
                result.setCorrectAnswersCount(rs.getInt("correct_answer_count"));
                result.setCorrectAnswersPercent(rs.getFloat("correct_answer_percent"));
                result.setWrongAnswersCount(rs.getInt("wrong_answer_count"));
                result.setNoAnswersCount(rs.getInt("no_answer_count"));
                result.setTimeAverage(rs.getInt("time_average"));
                result.setTimeStandardDeviation(rs.getInt("time_standard_deviation"));

                result.setT1N(rs.getInt("t1n"));
                result.setT1E(rs.getInt("t1e"));
                result.setT1O(rs.getInt("t1o"));
                result.setT1A(rs.getInt("t1a"));
                result.setT1C(rs.getInt("t1c"));
                result.setT2p1(rs.getInt("t2p1"));
                result.setT2p2(rs.getInt("t2p2"));
                result.setT2p3(rs.getInt("t2p3"));
                result.setT2p4(rs.getInt("t2p4"));
                result.setT2p5(rs.getInt("t2p5"));
                result.setT3f1(rs.getInt("t3f1"));
                result.setT3f2(rs.getInt("t3f2"));
                result.setT3f3(rs.getInt("t3f3"));
                result.setT3f4(rs.getInt("t3f4"));

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