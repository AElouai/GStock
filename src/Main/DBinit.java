package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dbase.ConnectionManager;
import MainMagasine.*;

public class DBinit {
	
	public static List<Produit> ProduitList = new ArrayList<Produit>();
	public static List<Uniter> UniterList = new ArrayList<Uniter>();
	public static List<Categorier> CategorierList = new ArrayList<Categorier>();
	
	static Connection conn = ConnectionManager.getInstance().getConnection();

	public DBinit() {
		uniter();
		categorier();
		produit();
	}
//*************************************************************************
	public String findUniterNameCat(int id) {
	    for(Categorier cat : CategorierList) {
	        if(cat.getIdcat() == id) {
	            return findUniterName(cat.getIduniter());
	        }
	    }
	    return null;
	}
	
	public static String findUniterName(int id) {
	    for(Uniter unt : UniterList) {
	        if(unt.getIduniter() == id) {
	            return unt.getNomUniter();
	        }
	    }
	    return null;
	}
	public String findCategorierName(int id) {
	    for(Categorier cat : CategorierList) {
	        if(cat.getIdcat() == id) {
	            return cat.getNomCategorier();
	        }
	    }
	    return null;
	}
	public static int findCategorierID(String name) {
	    for(Categorier cat : CategorierList) {
	        if(cat.getNomCategorier() == name) {
	            return cat.getIdcat();
	        }
	    }
	    return 0;
	}
	
	public static Produit findProdiutWithName(String name){
		 for(Produit prd : ProduitList) {
		        if(prd.getNomProduit() == name) {
		            return prd;
		        }
		    }
		return null;
	}
//*************************************************************************	
	//public Vector getCategorierVector
//*************************************************************************
	public static List<Produit> ListOfProduitWithCat(int id) {
		List<Produit> lprd = new ArrayList<Produit>();
	    for(Produit prd : ProduitList) {
	        if(prd.getIdcat() == id) {
	            lprd.add(prd);
	        }
	    }
	    return lprd;
	}
//*************************************************************************	
public void uniter(){
		String sql = "SELECT * FROM uniter";
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			//System.out.println("uniter Table:");
			while (rs.next()) {
				Uniter uniter = new Uniter();
				uniter.setIduniter(rs.getInt("iduniter"));
				uniter.setNomUniter(rs.getString("nomuniter"));
				
				UniterList.add(uniter);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public void categorier(){
		String sql = "SELECT * FROM categorier";
		try (
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				){
			//System.out.println("uniter Table:");
			while (rs.next()) {
				Categorier categorier = new Categorier();
				categorier.setIdcat(rs.getInt("idcat"));
				categorier.setNomCategorier(rs.getString("nomcat"));
				categorier.setIduniter(rs.getInt("iduniter"));
				
				CategorierList.add(categorier);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public void produit(){
	String sql = "SELECT * FROM produit";
	try (
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			){
		//System.out.println("uniter Table:");
		while (rs.next()) {
			Produit produit = new Produit();
			produit.setIdcat(rs.getInt("cat"));
			produit.setIdproduit(rs.getInt("idproduit"));
			produit.setNomProduit(rs.getString("ref"));
			produit.setQnt(rs.getInt("qnt_unt"));
			ProduitList.add(produit);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public static Boolean updateProduit(int id,int qnt){
	

	String sql =
			"UPDATE Produit SET " +
			"qnt_unt = ? " +
			"WHERE idproduit = ?";
	try (
//			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
		
		stmt.setInt(1, id);
		stmt.setInt(2, qnt);
		
		int affected = stmt.executeUpdate();
		if (affected == 1) {
			new DBinit();
			return true;
		} else {
			return false;
		}
		
	}
	catch(SQLException e) {
		System.err.println(e);
		return false;
	}
}

	
}
