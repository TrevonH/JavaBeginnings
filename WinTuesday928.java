public void addItem(double price) {  }
public void clear() {  }
Gold reg = new Gold(); 
reg.clear(); 
reg.addItem(500.12); 
reg.addItem(2001.23); 
System.out.println(reg.getCount() + " " + reg.getTotal());