package com.icaballero.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iaballero.util.DBConnection;


public class TechSupportBean {

	
	private String email;
	private String software;
	private String os;
	private String problem;
	private String firstName;
	private String lastName;
	private	String phoneNumber;
	

	private final String CHEKEMAIL = "SELECT * FROM customers WHERE email = ?";
	private final String UPDATE_SEQUENCE = "UPDATE seq_no SET next_no=next_no+1";
	private final String GET_CURRENT_SEQUENCER = "SELECT next_no FROM seq_no";
	private final String INSERT_CUSTOMERS = "INSERT INTO customers VALUES (?,?,?,?)";
	private final String INSERT_SUPP = "INSERT INTO supp_request VALUES (?,?,?,?,?)";
	private final String SELECT_NAME = "SELECT fname FROM customers WHERE email = ?";
	
	
	public TechSupportBean() {
		
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isRegister(){
		boolean status = false;
		String name = null;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(CHEKEMAIL);
			statment.setString(1, this.email);

			result = statment.executeQuery();
			if (result.next()) {
				name = result.getString("email");
				if (name.equals(this.email)) {
					status = true;
					this.firstName = result.getString("fname");
					this.lastName = result.getString("lname");
					this.phoneNumber = result.getString("phone");
				}
			}
	

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {

				// e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				// e.printStackTrace();
			}
			
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}
	
	
	
	/**
	 * 
	 * @param email
	 * @param name
	 * @param lastName
	 * @param phone
	 * @return
	 */
	public int registerCustomer() {
		int status = -1;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(INSERT_CUSTOMERS);
			statment.setString(1, this.email);
			statment.setString(2, this.firstName);
			statment.setString(3, this.lastName);
			statment.setString(4, this.phoneNumber);

			status = statment.executeUpdate();
			System.out.println(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}

	/**
	 * 
	 * @param email
	 * @param software
	 * @param so
	 * @param desc
	 * @return
	 */
	public int insertSupp() {
		int status = -1;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(INSERT_SUPP);
			statment.setInt(1, getNext());
			statment.setString(2, this.email);
			statment.setString(3, this.software);
			statment.setString(4, this.os);
			statment.setString(5, this.problem);

			status = statment.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}
	
	
	public String getCustomerName() {
		String name = null;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(SELECT_NAME);
			statment.setString(1, this.email);

			result = statment.executeQuery();
			if(result.next()){
				name = result.getString("fname");
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNext() {

		return updateSequencer() >= 1 ? getCurrent() : -1;
	}
	/**
	 * 
	 * @return
	 */
	private int updateSequencer() {
		int status = -1;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(UPDATE_SEQUENCE);
			status = statment.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return status;
	}

	/**
	 * 
	 * @return
	 */
	private int getCurrent() {

		int status = -1;
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement(GET_CURRENT_SEQUENCER);
			result = statment.executeQuery();
			if (result.next()) {
				status = result.getInt("next_no");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnection.closeStatement(statment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnection.closeResulSet(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnection.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return status;
	}

	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSoftware() {
		return software;
	}


	public void setSoftware(String software) {
		this.software = software;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public String getProblem() {
		return problem;
	}


	public void setProblem(String problem) {
		this.problem = problem;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	
	
}
