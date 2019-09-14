package es.coritel.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBQuery {
	private PreparedStatement statment = null;
	private ResultSet result = null;
	private Connection con = null;

	private final String CHEKEMAIL = "SELECT email FROM customers WHERE email = ?";
	private final String UPDATE_SEQUENCE = "UPDATE seq_no SET next_no=next_no+1";
	private final String GET_CURRENT_SEQUENCER = "SELECT next_no FROM seq_no";
	private final String INSERT_CUSTOMERS = "INSERT INTO customers VALUES (?,?,?,?)";
	private final String INSERT_SUPP = "INSERT INTO supp_request VALUES (?,?,?,?,?)";
	private final String SELECT_NAME = "SELECT fname FROM customers WHERE email = ?";

	/**
	 * 
	 * @param con
	 */
	public DBQuery(Connection con) {
		this.con = con;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean isRegister(String email) {
		boolean status = false;
		String name = null;

		try {
			statment = con.prepareStatement(CHEKEMAIL);
			statment.setString(1, email);

			result = statment.executeQuery();
			if (result.next()) {
				name = result.getString("email");
				if (name.equals(email)) {
					status = true;
				}
			}
	

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {

				// e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
			} catch (Exception e) {
				// e.printStackTrace();
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
	public int registerCustomer(String email, String name, String lastName, String phone) {
		int status = -1;

		try {
			statment = con.prepareStatement(INSERT_CUSTOMERS);
			statment.setString(1, email);
			statment.setString(2, name);
			statment.setString(3, lastName);
			statment.setString(4, phone);

			status = statment.executeUpdate();
			System.out.println(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
			} catch (Exception e) {
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
	public int insertSupp(String email, String software, String so, String desc) {
		int status = -1;

		try {
			statment = con.prepareStatement(INSERT_SUPP);
			statment.setInt(1, getNext());
			statment.setString(2, email);
			statment.setString(3, software);
			statment.setString(4, so);
			statment.setString(5, desc);

			status = statment.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return status;
	}

	public String getCustomerName(String email) {
		String name = null;

		try {
			statment = con.prepareStatement(SELECT_NAME);
			statment.setString(1, email);

			result = statment.executeQuery();
			if(result.next()){
				name = result.getString("fname");
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
			} catch (Exception e) {
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

		try {
			statment = con.prepareStatement(UPDATE_SEQUENCE);
			status = statment.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
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

		try {
			statment = con.prepareStatement(GET_CURRENT_SEQUENCER);
			result = statment.executeQuery();
			if (result.next()) {
				status = result.getInt("next_no");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				DBConnector.closeStatement(statment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DBConnector.closeResulSet(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return status;
	}

}
