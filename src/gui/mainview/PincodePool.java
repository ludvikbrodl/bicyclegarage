package gui.mainview;

import java.util.ArrayList;
import java.util.List;

import persistence.Database;

class PincodePool {

	private List<String> availablePincodes;
	
	public PincodePool(Database db) {
		availablePincodes = new ArrayList<String>();
		
		for (int i = 0; i < Database.MAX_USERS; i++) {
			String pincode = codify(i);
			if(!db.hasUserWithPin(pincode)){
				availablePincodes.add(pincode);
			}
		}
	}
	
	String getNextAvailablewPincode(){
		return availablePincodes.remove(availablePincodes.size()-1);
	}
	
	void returnPincodeToPool(String pincode){
		availablePincodes.add(pincode);
	}

	private String codify(int i) {
		StringBuilder s = new StringBuilder(Integer.toString(i));
		while (s.length() < 6) {
			s.append("0");
		}
		return s.toString();
	}
}
