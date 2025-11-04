package com.example.demo;

import com.example.demo.hilos.MiRunnable;


public class Main {

	public static void main(String[] args) {
		MiRunnable miRunnable = new MiRunnable();
		Thread thread = new Thread(miRunnable);
		thread.start();
	}

}
