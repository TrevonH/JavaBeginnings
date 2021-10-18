CashRegister reg = new CashRegister(); 
reg.clear(); 
reg.addItem(0.95); 
reg.addItem(0.95); 
System.out.println(reg.getCount() + " " + reg.getTotal());
