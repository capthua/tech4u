package me.ffulauh.db.jdbcdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionDemo {

    public static Connection getConnection()throws SQLException, IOException {
        Properties properties=new Properties();

       InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
//         Thread.currentThread().getContextClassLoader().getResource("database.properties");

//        FileInputStream in=new FileInputStream("D:\\docs\\JavaProjects\\tech4u\\src\\main\\java\\me\\ffulauh\\db\\jdbcdemo\\database.properties");
//        properties.load(in);
//        in.close();

        properties.load(is);
        is.close();

//        String drivers=properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");
        return DriverManager.getConnection(url,username,password);
    }

    public static void main(String[] args) throws Exception{
        Connection conn=getConnection();
        System.out.println("hehe");

        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
//        String selectSql="update user set username=? where id=?";
//        PreparedStatement stat=conn.prepareStatement(selectSql);
//        stat.setString(1,"han");
//        stat.setString(2,"1");


//        Blob avatar=conn.createBlob();
//        int offset=1;
//        OutputStream out = avatar.setBinaryStream(1);
//        InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
//        byte[] buffer=new byte[100];
//        int byteRead;
//        while ((byteRead=is.read(buffer))!=-1){
//            out.write(buffer,0,byteRead);
//        }
//        String updateAvatar="update user set avatar=? where id=?";
//        PreparedStatement stat=conn.prepareStatement(updateAvatar);
//
//        stat.setBlob(1,avatar);
//        stat.setString(2,"1");
//        stat.executeUpdate();

        String updateName="update user set username=? where id=?";
        PreparedStatement stat=conn.prepareStatement(updateName);

        stat.setString(1,"sh");
        stat.setInt(2,1);
        stat.executeUpdate();

        conn.commit();
        System.out.println("hehe");

    }

}
