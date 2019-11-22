package com.jcg.examples;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DatabaseUtility
{
		public static ComboPooledDataSource getDataSource() throws PropertyVetoException
		{
				ComboPooledDataSource cpds = new ComboPooledDataSource();
//				cpds.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/rtdms");
//				cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/rtdms");
				cpds.setJdbcUrl("jdbc:postgresql://10.230.142.195:5432/rtdms");
				cpds.setUser("dmsirc0115");
				cpds.setPassword("PWDDMSIRC0115");

				// Optional Settings
				cpds.setInitialPoolSize(5);
				cpds.setMinPoolSize(5);
				cpds.setAcquireIncrement(5);
				cpds.setMaxPoolSize(20);
				cpds.setMaxStatements(100);

				return cpds;
		}

		public static void main(String[] args) throws SQLException
		{
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet resultSet = null;
				try
				{
						ComboPooledDataSource dataSource = DatabaseUtility.getDataSource();
						connection = dataSource.getConnection();
//						pstmt = connection.prepareStatement("SELECT * FROM account");
						pstmt = connection.prepareStatement("SELECT 1");

						System.out.println("The Connection Object is of Class: " + connection.getClass());
						
						resultSet = pstmt.executeQuery();
						while (resultSet.next())
						{
//								System.out.println(resultSet.getString(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3));
								System.out.println("Test: " + resultSet.getString(1));
						}

				}
				catch (Exception e)
				{
						connection.rollback();
						e.printStackTrace();
				}
		}
}
