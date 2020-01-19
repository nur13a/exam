package com.company;

public class Main {

    public static void main(String[] args) {
	DBeaver db=new DBeaver();
	db.addNews(new News("Hello","World!"));
	db.addNews(new News("Hello","World!"));
	db.delete(1);
	db.changed("Hi","IT's Nuriza",2);
     db.printNews();
    }
}
