package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private static final String INSERT_QUERY="INSERT INTO INTEREST_TAB VALUES(INT_SEQ.NEXTVAL,?,?,?,?,?,?)";
	private DataSource ds;
	public CustomerDAOImpl(DataSource ds) {
		this.ds=ds;
		}
	@Override
	public int insert(CustomerBO bo) throws Exception {
		
		
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		con=ds.getConnection();
		ps=con.prepareStatement(INSERT_QUERY);
		ps.setString(1, bo.getName());
		ps.setDouble(2, bo.getPrinciple());
		ps.setDouble(3, bo.getRate());
		ps.setInt(4, bo.getPeriod());
		ps.setDouble(5,bo.getSi() );
		ps.setDouble(6, bo.getCi());
		
		//execute the query
		count=ps.executeUpdate();
		//close jdbc connection
		ps.close();
		con.close();
		return count;
			}

}
