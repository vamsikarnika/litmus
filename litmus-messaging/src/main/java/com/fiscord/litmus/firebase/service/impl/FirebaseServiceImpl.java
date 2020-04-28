package com.fiscord.litmus.firebase.service.impl;

import org.springframework.stereotype.Service;

import com.fiscord.litmus.firebase.service.api.FirebaseService;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseServiceImpl implements FirebaseService{

	public Firestore getFirestoreDB() {
		System.out.println("Getting FirebaseDatabase");
		Firestore firestore=null;
		try {
			firestore= FirestoreClient.getFirestore();
		} catch (Exception e) {
			System.out.println("failed fetching firestoreDB");
			e.printStackTrace();
		}
		return firestore;
	}
}
