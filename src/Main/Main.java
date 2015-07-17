package Main;

import graphe.Look;

import java.util.List;

import Dbase.*;
import MainMagasine.Categorier;
import MainMagasine.Produit;
import MainMagasine.Uniter;

public class Main {

	public static void main(String[] args) {
		
		DBinit start = new DBinit();
		/*List<Produit> LProduit = DBinit.ProduitList;
		List<Uniter> LUniter = DBinit.UniterList;
		List<Categorier> LCategorier = DBinit.CategorierList;
		for (Produit prd : LProduit) {
			System.out.println("produit "+ prd.getNomProduit()+"est de cat : " +start.findCategorierName(prd.getIdcat())
					+" "+start.findUniterNameCat(prd.getIdcat()));
		}
		*/
		Look look = new Look();
		look.startWindows();

		
//		MainWindows newWindow = new MainWindows();
//		newWindow.setVisible(true);
		/*Produit a = new Produit();
		a.setUniter("kg");
		a.setCat("masse");
		a.setRef("produit A");
		a.setQnt(1000);
		System.out.println("produit : "+a.getRef()+"\n cat : "+a.getCat()+"\n Qnt :"+a.getQnt()+" "+a.getUniter());
		*/
	//	ConnectionManager.getInstance().close();
	}

}
