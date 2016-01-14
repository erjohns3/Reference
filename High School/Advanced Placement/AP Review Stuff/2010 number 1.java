/** @return the sum of the number of boxes of all of the cookie orders
*/
public int getTotalBoxes()
{ 
	int total = 0;
	for (CookieOrder o : orders) {
		total += o.getNumBoxes();
	}
	return total;
}



int total = 0;
for (int i = 0; i<orders.size(); i++){

	total += orders.get(i).getNumBoxes();

	//OR//

	CookieOrder o = orders.get(i);
	total += o.getNumBoxes();

}
return total;
















public int removeVariety(String cookieVar) {

	for (int i = 0; i<orders.size(); i++){
		if (orders.get(i).getVariety().equals(cookieVar)){
			orders.remove(i);
			i--;
		}

	}

}


public int removeVariety(String cookieVar) {

	int total = 0;
	for (int i = 0; i<orders.size(); i++){

		CookieOrder o = orders.get(i);
		if (o.getVariety().equals(cookieVar)){
			total += o.getNumBoxes();
			orders.remove(i);
			i--;
		}

	}
	return total;

}



public int removeVariety(String cookieVar) {

	int total = 0;
	for (int i = 0; i<orders.size(); i++){

		CookieOrder o = orders.get(i);
		if (o.getVariety().equals(cookieVar)){
			total += orders.remove(i).getNumBoxes();
			i--;
		}

	}
	return total;

}































