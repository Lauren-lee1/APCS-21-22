// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW75 -- Nodal Recall
// 2022-03-13
// time spent: 0.4hrs

public class LLNode {

	private String cargo;
	private LLNode[] linkage;

	public LLNode(String newCargo, LLNode[] newLinkage) {
		cargo = newCargo;
		linkage = newLinkage;
	}

	public String getCargo() {
		return cargo;
	}

	public String setCargo(String newCargo) {
		String temp = cargo;
		cargo = newCargo;
		return temp;
	}

	public LLNode[] getLinkage() {
		return linkage;
	}

	public LLNode[] setLinkage(LLNode[] newLinkage) {
		LLNode[] temp = linkage;
		linkage = newLinkage;
		return temp;
	}

}
