import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

public class Company{
String name;
static String companyTimes[] = {"9:00 am","10:00 am","11:00 am","12:00 pm","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm"};
HashMap<String,Integer> hoursAvailable = new HashMap<>();

public Company(String name) {
	this.hoursAvailable.put("9:00 am",0);
	this.hoursAvailable.put("10:00 am",0);
	this.hoursAvailable.put("11:00 am",0);
	this.hoursAvailable.put("12:00 pm",0);
	this.hoursAvailable.put("1:00 pm",0);
	this.hoursAvailable.put("2:00 pm",0);
	this.hoursAvailable.put("3:00 pm",0);
	this.hoursAvailable.put("4:00 pm",0);
	this.hoursAvailable.put("5:00 pm",0);
	this.name = name;
	
}



public String getName() {
	return name;
}




public String[] getCompanyTimes() {
	return companyTimes;
}



public void setCompanyTimes(String[] companyTimes) {
	this.companyTimes = companyTimes;
}



public void setName(String name) {
	this.name = name;
}



public String[] getHoursAvailable() {
	ArrayList<String> list = new ArrayList<>();
	for(String i : this.hoursAvailable.keySet()) {
		if(this.hoursAvailable.get(i) == 1) {
			list.add(i);
		}
	}
	
	return list.toArray(String[]:: new);
}




public String[] SelectHours(String...time) {
	if (time.length > 8) {
        throw new IllegalArgumentException("Exceeded maximum number of arguments (8)");
    }
	for(int i = 0; i < time.length; i++) {
		this.hoursAvailable.put(time[i],1);
	}
	return time;
}

}
