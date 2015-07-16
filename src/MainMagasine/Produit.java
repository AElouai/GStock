package MainMagasine;

public class Produit {

		private int idproduit;
		private String ref;
		private int idcat;
		private int qnt;

		public int getIdproduit() {
			return idproduit;
		}
		public void setIdproduit(int idproduit) {
			this.idproduit = idproduit;
		}
		public String getNomProduit() {
			return ref;
		}
		public void setNomProduit(String ref) {
			this.ref = ref;
		}
		public int getQnt() {
			return qnt;
		}
		public void setQnt(int qnt) {
			this.qnt = qnt;
		}
		public int getIdcat() {
			return idcat;
		}
		public void setIdcat(int idcat) {
			this.idcat = idcat;
		}

}
